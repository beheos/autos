package mx.beheos.autos.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.google.gson.Gson;

import mx.beheos.autos.entity.modelo.Empleado;
import mx.beheos.autos.entity.modelo.Vehiculo;
import mx.beheos.autos.service.IEmpleadoService;
import mx.beheos.autos.service.ISucursalService;
import mx.beheos.autos.util.Utilerias;

@Controller
@RequestMapping("/empleados")
public class EmpleadosController {

	@Autowired
	IEmpleadoService iEmpleadoService;
	@Autowired
	ISucursalService iSucursalService;
	
	@GetMapping("/")
	public String inicio(@RequestParam(defaultValue = "0")int page, Model model) {
		Pageable pageable = PageRequest.of(page, 10);
		Page<Empleado> empleados = iEmpleadoService.findAllEmpleados(pageable);
		model.addAttribute("empleados", empleados);
		model.addAttribute("sucursales", iSucursalService.getSucursales());
		return "empleados/empleados";
	}
	
	@PostMapping("/guardar")
	public String guardar(Empleado empleado) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		final String USUARIO_LOGEADO = authentication.getName();
		try {
			if(empleado.getId() != null) {
				Empleado empTemp = iEmpleadoService.getEmpleado(empleado.getId());
				empleado.setUsuarioIngreso(empTemp.getUsuarioIngreso());
				empleado.setFechaIngreso(empTemp.getFechaIngreso());
				empleado.setIdEmpleado(empTemp.getIdEmpleado());
				empleado.setFechaModifico(Utilerias.formatearFecha(new Date()));
				empleado.setUsuarioModifico(USUARIO_LOGEADO);
				empleado.setEnabled(empTemp.getEnabled());
			}else {
				empleado.setFechaIngreso(Utilerias.formatearFecha(new Date()));
				empleado.setUsuarioIngreso(USUARIO_LOGEADO);
				empleado.setIdEmpleado(Utilerias.generarIdEmpleado());
				empleado.setEnabled((byte) 1);
			}
			iEmpleadoService.guardar(empleado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/empleados/";
	}
	
	@GetMapping("/editar/{id}")
	public @ResponseBody String editar(@PathVariable Long id) {
		Gson gson = new Gson();
		Empleado empleado = iEmpleadoService.getEmpleado(id);
		return gson.toJson(empleado);
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		final String USUARIO_LOGEADO = authentication.getName();
		Empleado empTemp = iEmpleadoService.getEmpleado(id);
		empTemp.setEnabled((byte) 0);
		empTemp.setUsuarioModifico(USUARIO_LOGEADO);
		empTemp.setFechaModifico(Utilerias.formatearFecha(new Date()));
		iEmpleadoService.guardar(empTemp);
		return "redirect:/empleados/";
	}
}
