package mx.beheos.autos.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mx.beheos.autos.entity.modelo.Color;
import mx.beheos.autos.entity.modelo.Estado;
import mx.beheos.autos.entity.modelo.Marca;
import mx.beheos.autos.entity.modelo.SubMarca;
import mx.beheos.autos.entity.modelo.TipoAutomovil;
import mx.beheos.autos.entity.modelo.Vehiculo;

public interface IVehiculoService {
	
	Vehiculo getVehiculo(Long id);
	
	Page<Vehiculo> findAllVehiculo(Pageable pageable);
	
	Vehiculo guardar(Vehiculo vehiculo);
	
	List<TipoAutomovil>getTiposAutos();
	
	List<Marca>getMarcas();
	
	List<SubMarca>getSubMarcas(Long idMarca);
	
	List<Color>getColores();
	
	List<Estado>getEstados();
	
	TipoAutomovil getTipoAutoByTipo(String tipo);
	
	Marca getMarcaByMarca(String marca);
	
	SubMarca getSubmarcaBySubmarca(String subMarca);
	
	Color getColorByColor(String Color);
	
	Estado getEstado(Long i);
	
}
