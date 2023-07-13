package mx.beheos.autos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.beheos.autos.entity.modelo.TipoAutomovil;

public interface ITipoVehiculoDao extends JpaRepository<TipoAutomovil, Long> {

	TipoAutomovil findByTipo(String tipo);
	
}
