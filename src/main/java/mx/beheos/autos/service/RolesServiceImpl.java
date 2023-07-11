package mx.beheos.autos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.beheos.autos.dao.IRoles;
import mx.beheos.autos.entity.modelo.Roles;

@Service
public class RolesServiceImpl implements IRolesService {

	@Autowired
	IRoles iRolesDao;
	
	@Override
	public List<Roles> roles(String username) {
		return iRolesDao.findByUsername(username);
	}

	
	@Override
	@Transactional
	public void eliminarRol(String username, String rol) {
		iRolesDao.deleteByUsernameAndRol(username, rol);
	}


	@Override
	public Roles ingresarRol(Roles rol) {
		return iRolesDao.save(rol);
	}

}
