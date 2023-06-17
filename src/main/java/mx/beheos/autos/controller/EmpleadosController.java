package mx.beheos.autos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/empleados")
public class EmpleadosController {

	@GetMapping("/")
	public String inicio() {
		return "empleados/empleados";
	}
}
