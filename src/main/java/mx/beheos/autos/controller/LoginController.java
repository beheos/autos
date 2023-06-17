package mx.beheos.autos.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import mx.beheos.autos.entity.modelo.Roles;
import mx.beheos.autos.entity.modelo.Usuarios;
import mx.beheos.autos.enums.RolesEnum;
import mx.beheos.autos.service.IRegistroService;

@Controller
public class LoginController {
	
	@Autowired
	IRegistroService IRegistroService;

	@GetMapping("/")
    public String login() {
        return "login";
    }
	
	@GetMapping("/registro")
    public String registro() {
        return "registro";
    }
	
	@PostMapping("/registro")
	private String resgistro(Usuarios usuario) {
		String paswordEncriptado = encriptarPassword(usuario.getPassword());
		usuario.setPassword(paswordEncriptado);
		Integer user_habilitado = 1;
		usuario.setEnabled(user_habilitado.byteValue());
		Roles roles = new Roles();
		roles.setUsername(usuario.getUsername());
		roles.setRol(RolesEnum.USUARIO.getValue());
		IRegistroService.usuarioCreado(usuario, roles);
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
