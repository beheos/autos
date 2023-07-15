package mx.beheos.autos.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mx.beheos.autos.entity.modelo.Roles;
import mx.beheos.autos.entity.modelo.Usuarios;
import mx.beheos.autos.service.IRolesService;
import mx.beheos.autos.service.IUsuarioService;
import mx.beheos.autos.util.Utilerias;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	IUsuarioService iUsuarioService;
	@Autowired
	IRolesService iRolesService;
	
	@GetMapping("/")
	private String mostrar(@RequestParam(defaultValue = "0")int page,Model model) {
		Pageable pageable = PageRequest.of(page, 10);
		model.addAttribute("usuarios", iUsuarioService.getUsuaurios(pageable));
		String roles[] = {"ADMIN","RH", "VENTAS"};
		model.addAttribute("roles", roles);
		return "usuarios/usuario";
	}
	
	
	//El username no se debe de poder modificar
	@SuppressWarnings("unlikely-arg-type")
	@PostMapping("/guardar")
	private String guardar(Usuarios usuarios, @RequestParam(value = "roles", required = false) String[] rolesSeleccionados,
			RedirectAttributes redirectAttributes) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		try {
			final String USUARIO_LOGEADO = authentication.getName();
			Usuarios usrTem = iUsuarioService.getObtenerUusario(usuarios.getId());
			usuarios.setPassword(usuarios.getPassword().isEmpty() || usuarios.getPassword() == null ?
								usrTem.getPassword() : Utilerias.encriptarPassword(usuarios.getPassword()));
			usuarios.setFechaIngreso(usrTem.getFechaIngreso());
			usuarios.setFechaModifico(Utilerias.formatearFecha(new Date()));
			usuarios.setUsuarioModifico(USUARIO_LOGEADO);
			usuarios = iUsuarioService.guardar(usuarios);
			redirectAttributes.addFlashAttribute("mensaje", "Se modifico al usuario " + usuarios.getUsername());
			List<Roles>roles = iRolesService.roles(usuarios.getUsername());
	        //Se eleimina los roles
			for (Roles rol : roles) {
	        		iRolesService.eliminarRol(usuarios.getUsername(), rol.getRol());
	        }
	        //Se agrega los nuevos roles
	        for (String rolNuevo : rolesSeleccionados) {
	            		Roles rolTem = new Roles(usuarios.getUsername(), rolNuevo);
	            		iRolesService.ingresarRol(rolTem);
	        }
		}catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensaje", "Ocurrio un error al modificar el usuario");
			e.printStackTrace();
		}
		
		return "redirect:/usuarios/";
	}
	
	
	@GetMapping("/editar/{username}")
	public @ResponseBody Map<String, Object> editar(@PathVariable String username) {
		Map<String, Object>resp = new HashMap<String, Object>();
		Usuarios usuarios = iUsuarioService.getObtenerusuarioByUsername(username);
		List<Roles>roles = iRolesService.roles(username);
		resp.put("usuario", usuarios);
		resp.put("roles", roles);
		return resp;
	}
	
}
