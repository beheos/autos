package mx.beheos.autos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.beheos.autos.entity.modelo.SubMarca;
import mx.beheos.autos.entity.modelo.Sucursal;
import mx.beheos.autos.entity.modelo.TipoAutomovil;

public interface ISubMarcaDao extends JpaRepository<SubMarca, Long> {

	List<SubMarca>findAllByIdMarca(Long idMarca);
	SubMarca findBySubMarca(String subMarca);
}
