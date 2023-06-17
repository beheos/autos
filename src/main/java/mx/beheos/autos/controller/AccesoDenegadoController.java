package mx.beheos.autos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/errores")
public class AccesoDenegadoController {
	
    @RequestMapping("/eccesoDenegado")
    public String eccesoDenegado() {
        return "/errores/error403";
    }
    
    @RequestMapping("/noEncontrado")
    public String accessDenied() {
        return "/errores/error404";
    }

}
