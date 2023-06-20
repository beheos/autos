package mx.beheos.autos.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mx.beheos.autos.entity.modelo.Roles;
import mx.beheos.autos.entity.modelo.Usuarios;
import mx.beheos.autos.enums.RolesEnum;
import mx.beheos.autos.service.IRegistroService;

@Controller
public class LoginController {
	
	@Autowired
	IRegistroService IRegistroService;

	/*@GetMapping("/")
    public String login() {
        return "login";
    }*/
	
	@GetMapping("/")
    public String showLoginForm(Model model, @RequestParam(value = "error", required = false) String error) {
        if (error != null) {
            model.addAttribute("errorMessage", "El usuario y/o la contraseña son incorrectas");
        }
        return "login";
    }
	
	@GetMapping("/registro")
    public String registro(ModelMap model) {
		model.addAttribute("usuarios", new Usuarios());
        return "registro";
    }
	
	@PostMapping("/registro")
	private String resgistro(@Valid Usuarios usuarios, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return "registro";
		//map.addAttribute("usuario", usuarios);
		String paswordEncriptado = encriptarPassword(usuarios.getPassword());
		usuarios.setPassword(paswordEncriptado);
		Integer user_habilitado = 1;
		usuarios.setEnabled(user_habilitado.byteValue());
		Roles roles = new Roles();
		roles.setUsername(usuarios.getUsername());
		roles.setRol(RolesEnum.USUARIO.getValue());
		IRegistroService.usuarioCreado(usuarios, roles);
		return "redirect:/";
	}

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }
	
	private String encriptarPassword(String password) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(password);
	}
}
