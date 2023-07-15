package mx.beheos.autos.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;

import mx.beheos.autos.entity.modelo.Color;
import mx.beheos.autos.entity.modelo.Marca;
import mx.beheos.autos.entity.modelo.SubMarca;
import mx.beheos.autos.entity.modelo.Sucursal;
import mx.beheos.autos.entity.modelo.TipoAutomovil;
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
	
	@GetMapping("/cargamasiva")
	public String cargaMasiva() {
		return "vehiculo/vehiculoExcel";
	}
	
	@PostMapping("/guardar")
	public String guardar(Vehiculo vehiculo, RedirectAttributes redirectAttributes) {
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
				redirectAttributes.addFlashAttribute("mensaje", "editado");
			}else {
				vehiculo.setFechaIngreso(Utilerias.formatearFecha(new Date()));
				vehiculo.setUsuarioIngreso(USUARIO_LOGEADO);
				redirectAttributes.addFlashAttribute("mensaje", "agregado");
			}
			iVehiculoService.guardar(vehiculo);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensaje", "error");
			e.printStackTrace();
		}
		return "redirect:/vehiculo/";
	}
	
	@PostMapping("/subirCargaMasiva")
	public String subirCarbaMasiva(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		final String USUARIO_LOGEADO = authentication.getName();
		int contador = 0;
		try (Workbook workbook = WorkbookFactory.create(file.getInputStream())) {
			Sheet sheet = workbook.getSheetAt(0);
			List<String>errores = new ArrayList<>();
			
			//recorremos las filas
			for(Row row: sheet) {
				if(row.getRowNum() != 0) {
					Vehiculo vehiculo = new Vehiculo();
					 Cell cell = null;
					 cell = row.getCell(0);
						 Sucursal suc = iSucursalService.getSucursalBySucursal(cell.getStringCellValue());
						 if(suc != null) {
							 vehiculo.setSucursal(suc);
						 }else {
							 errores.add("en la fila " + row.getRowNum() + 1 + " en la celda 1 no es correcto el valor" );
							 continue;
						 }
					cell = row.getCell(1);
						TipoAutomovil tipoAut = iVehiculoService.getTipoAutoByTipo(cell.getStringCellValue());
						 if(tipoAut != null) {
							 vehiculo.setTipoAutomovil(tipoAut);
						 }else {
							 errores.add("en la fila " + row.getRowNum() + 1 + " en la celda 1 no es correcto el valor" );
							 continue;
						 }
					cell = row.getCell(2);
						Marca marca = iVehiculoService.getMarcaByMarca(cell.getStringCellValue());
					 if(marca != null) {
						 vehiculo.setMarca(marca);
					 }else {
						 errores.add("en la fila " + row.getRowNum() + 1 + " en la celda 2 no es correcto el valor" );
						 continue;
					 }
					cell = row.getCell(3);
						SubMarca subMarca = iVehiculoService.getSubmarcaBySubmarca(cell.getStringCellValue());
					 if(subMarca != null) {
						 vehiculo.setSubMarca(subMarca);
					 }else {
						 errores.add("en la fila " + row.getRowNum() + 1 + " en la celda 3 no es correcto el valor" );
						 continue;
					 }
					 cell = row.getCell(4);
					 if(cell != null) {
						    if (cell.getCellType() == CellType.STRING) {
						        String serie = cell.getStringCellValue();
						        vehiculo.setNumeroSerie(serie);
						    } else if (cell.getCellType() == CellType.NUMERIC) {
						        double valorNumerico = cell.getNumericCellValue();
						        String serie = String.valueOf(valorNumerico);
						        vehiculo.setNumeroSerie(serie);
						    } else {
						        errores.add("En la fila " + (row.getRowNum() + 1) + ", en la celda 4, el tipo de celda no es correcto");
						        continue;
						    }
					 }else {
						 errores.add("en la fila " + row.getRowNum() + 1 + " en la celda 4 no es correcto el valor" );
						 continue;
					 }
					cell = row.getCell(5);
						Color color = iVehiculoService.getColorByColor(cell.getStringCellValue());
					 if(color != null) {
						 vehiculo.setColor(color);
					 }else {
						 errores.add("en la fila " + row.getRowNum() + 1 + " en la celda 5 no es correcto el valor" );
						 continue;
					 }
					 cell = row.getCell(6);
					 if(cell.getCellType() != CellType.BLANK) {
						 int nPuertas = (int) cell.getNumericCellValue();
						 vehiculo.setnPuertas(nPuertas);
					 }else {
						 errores.add("en la fila " + row.getRowNum() + 1 + " en la celda 6 no es correcto el valor" );
						 continue;
					 }
					 cell = row.getCell(7);
					 if(cell.getCellType() != CellType.BLANK) {
						 int modelo = (int) cell.getNumericCellValue();
						 vehiculo.setModelo(modelo);
					 }else {
						 errores.add("en la fila " + row.getRowNum() + 1 + " en la celda 7 no es correcto el valor" );
						 continue;
					 }
					 cell = row.getCell(8);
					 if(cell.getCellType() != CellType.BLANK) {
						 BigDecimal precio =  new BigDecimal(cell.getNumericCellValue());
						 vehiculo.setPrecio(precio);
					 }else {
						 errores.add("en la fila " + row.getRowNum() + 1 + " en la celda 8 no es correcto el valor" );
						 continue;
					 }
					 cell = row.getCell(9);
					 if(cell.getCellType() != CellType.BLANK) {
						 BigDecimal kilometraje =  new BigDecimal(cell.getNumericCellValue());
						 vehiculo.setKilometraje(kilometraje);
					 }else {
						 errores.add("en la fila " + row.getRowNum() + 1 + " en la celda 9 no es correcto el valor" );
						 continue;
					 }
					 	 cell = row.getCell(10);
						 vehiculo.setObservaciones(cell == null ? "" : cell.getStringCellValue());
					
					 vehiculo.setEstado(iVehiculoService.getEstado((long)1));
					 vehiculo.setFechaIngreso(Utilerias.formatearFecha(new Date()));
					 vehiculo.setUsuarioIngreso(USUARIO_LOGEADO);
					 iVehiculoService.guardar(vehiculo);
					 contador++;
				}
			}
			redirectAttributes.addFlashAttribute("mensaje", "Ingresaron " + contador + " Vehiculo(s)");
		}catch(IOException e){
			redirectAttributes.addFlashAttribute("mensaje", "Ocurrio un error se ingresaron " + contador + " Vehiculos");
			e.printStackTrace();
		}
		return "redirect:/vehiculo/cargamasiva";
		
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
