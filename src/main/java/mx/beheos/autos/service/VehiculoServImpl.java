package mx.beheos.autos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mx.beheos.autos.dao.IColorDao;
import mx.beheos.autos.dao.IEstadoDao;
import mx.beheos.autos.dao.IMarcaoDao;
import mx.beheos.autos.dao.ISubMarcaDao;
import mx.beheos.autos.dao.ITipoVehiculoDao;
import mx.beheos.autos.dao.IVehiculoDao;
import mx.beheos.autos.entity.modelo.Color;
import mx.beheos.autos.entity.modelo.Estado;
import mx.beheos.autos.entity.modelo.Marca;
import mx.beheos.autos.entity.modelo.SubMarca;
import mx.beheos.autos.entity.modelo.TipoAutomovil;
import mx.beheos.autos.entity.modelo.Vehiculo;

@Service
public class VehiculoServImpl implements IVehiculoService{

	@Autowired
	IVehiculoDao iVehiculoDao;
	@Autowired
	ITipoVehiculoDao iTipoVehiculoDao;
	@Autowired
	IMarcaoDao iMarcaoDao;
	@Autowired
	ISubMarcaDao iSubMarcaDao;
	@Autowired
	IColorDao iColorDao;
	@Autowired
	IEstadoDao iEstadoDao;
	
	@Override
	public Vehiculo getVehiculo(Long id) {
		return iVehiculoDao.findById(id).orElse(null);
	}

	@Override
	public Page<Vehiculo> findAllVehiculo(Pageable pageable) {
		return iVehiculoDao.listaVehiculos(pageable);
	}

	@Override
	public Vehiculo guardar(Vehiculo vehiculo) {
		return iVehiculoDao.save(vehiculo);
	}

	@Override
	public List<TipoAutomovil> getTiposAutos() {
		return iTipoVehiculoDao.findAll();
	}

	@Override
	public List<Marca> getMarcas() {
		return iMarcaoDao.findAll();
	}

	@Override
	public List<Color> getColores() {
		return iColorDao.findAll();
	}

	@Override
	public List<Estado> getEstados() {
		return iEstadoDao.findAll();
	}

	@Override
	public List<SubMarca> getSubMarcas(Long idMarca) {
		return iSubMarcaDao.findAllByIdMarca(idMarca);
	}

	@Override
	public TipoAutomovil getTipoAutoByTipo(String tipo) {
		return iTipoVehiculoDao.findByTipo(tipo);
	}

	@Override
	public Marca getMarcaByMarca(String marca) {
		return iMarcaoDao.findByMarca(marca);
	}

	@Override
	public SubMarca getSubmarcaBySubmarca(String subMarca) {
		return iSubMarcaDao.findBySubMarca(subMarca);
	}

	@Override
	public Color getColorByColor(String Color) {
		return iColorDao.findByColor(Color);
	}

	@Override
	public Estado getEstado(Long id) {
		return iEstadoDao.findById(id).orElse(null);
	}

}
