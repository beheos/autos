package mx.beheos.autos.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mx.beheos.autos.entity.modelo.Empleado;

public interface IEmpleadoService {

	Page<Empleado> findAllEmpleados(Pageable pageable);
	Empleado guardar(Empleado empleado);
	Empleado getEmpleado(Long idEmpleado);
}
