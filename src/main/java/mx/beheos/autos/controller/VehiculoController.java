package mx.beheos.autos.controller;

import java.util.Date;
import java.util.List;

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

import mx.beheos.autos.entity.modelo.SubMarca;
import mx.beheos.autos.entity.modelo.Vehiculo;
import mx.beheos.autos.service.ISucursalService;
import mx.beheos.autos.service.IVehiculoService;
import mx.beheos.autos.util.Utilerias;

@Controller
@RequestMapping("/vehiculo")
public class VehiculoController {
	
	@Autowired
	IVehiculoService iVehiculoService;
	@Autowired
	ISucursalService iSucursalService;
	
	@GetMapping("/")
	public String mostrar(@RequestParam(defaultValue = "0")int page, Model model) {
		Pageable pageable = PageRequest.of(page, 10);
		Page<Vehiculo> vehiculosPage = iVehiculoService.findAllVehiculo(pageable);
	    model.addAttribute("vehiculos", vehiculosPage);
	    model.addAttribute("tiposCarro", iVehiculoService.getTiposAutos());
	    model.addAttribute("colores", iVehiculoService.getColores());
	    model.addAttribute("marcas", iVehiculoService.getMarcas());
	    model.addAttribute("estados", iVehiculoService.getEstados());
	    model.addAttribute("sucursales", iSucursalService.getSucursales());
		return "vehiculo/vehiculo";
	}
	
	@PostMapping("/guardar")
	public String guardar(Vehiculo vehiculo) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		final String USUARIO_LOGEADO = authentication.getName(); 
		try {
			if(vehiculo.getId() != null) {
				Vehiculo vehiculoTemp = iVehiculoService.getVehiculo(vehiculo.getId());
				vehiculo.setCliente(vehiculoTemp.getCliente() != null ? vehiculoTemp.getCliente() : null);
				vehiculo.setFechaIngreso(vehiculoTemp.getFechaIngreso());
				vehiculo.setFechaModifico(Utilerias.formatearFecha(new Date()));
				vehiculo.setUsuarioIngreso(vehiculoTemp.getUsuarioIngreso());
				vehiculo.setUsuarioModifico(USUARIO_LOGEADO);
			}else {
				vehiculo.setFechaIngreso(Utilerias.formatearFecha(new Date()));
				vehiculo.setUsuarioIngreso(USUARIO_LOGEADO);
			}
			iVehiculoService.guardar(vehiculo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/vehiculo/";
	}
	
	@GetMapping("/getSubMarcas/{id}")
	public @ResponseBody String getSubMarcas(@PathVariable Long id) {
		Gson gson = new Gson();
		List<SubMarca> mar = iVehiculoService.getSubMarcas(id);
		return gson.toJson(mar);
	}
	
	@GetMapping("/editar/{id}")
	public @ResponseBody String editar(@PathVariable Long id) {
		Gson gson = new Gson();
		Vehiculo vehiculo = iVehiculoService.getVehiculo(id);
		return gson.toJson(vehiculo);
	}
	

}
