package mx.beheos.autos.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.beheos.autos.dao.IRoles;
import mx.beheos.autos.dao.IUsuariosDao;
import mx.beheos.autos.entity.modelo.Roles;
import mx.beheos.autos.entity.modelo.Usuarios;

@Service
public class RegistroServiceImpl implements IRegistroService {

	@Autowired
	IUsuariosDao iUsuariosDao;
	@Autowired
	IRoles iRoles;
	
	@Override
	public Usuarios guardar(Usuarios usuario) {
		return iUsuariosDao.save(usuario);
	}

	@Override
	public Roles guardarRol(Roles roles) {
		return iRoles.save(roles);
	}

	@Transactional
	@Override
	public void usuarioCreado(Usuarios usuario, Roles roles) {
		iUsuariosDao.save(usuario);
		iRoles.save(roles);
	}	

}
