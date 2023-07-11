package mx.beheos.autos.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.beheos.autos.entity.modelo.Empleado;

public interface IEmpleadoDao extends JpaRepository<Empleado, Long> {

	@Query(value = "select * from autos.empleado where enabled = 1 order by id desc", nativeQuery = true)
	Page<Empleado>listaEmpleados(Pageable pageable);
}
