package mx.beheos.autos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mx.beheos.autos.dao.IEmpleadoDao;
import mx.beheos.autos.entity.modelo.Empleado;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	IEmpleadoDao iEmpleadoDao;
	
	@Override
	public Page<Empleado> findAllEmpleados(Pageable pageable) {
		return iEmpleadoDao.listaEmpleados(pageable);
	}

	@Override
	public Empleado guardar(Empleado empleado) {
		return iEmpleadoDao.save(empleado);
	}

	@Override
	public Empleado getEmpleado(Long idEmpleado) {
		return iEmpleadoDao.findById(idEmpleado).orElse(null);
	}

}
