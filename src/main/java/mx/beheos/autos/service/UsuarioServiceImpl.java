package mx.beheos.autos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mx.beheos.autos.dao.IUsuariosDao;
import mx.beheos.autos.entity.modelo.Usuarios;
import mx.beheos.autos.entity.modeloDTO.UsuariosDTO;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	IUsuariosDao iUsuariosDao;
	
	@Override
	public Page<Usuarios> getUsuaurios(Pageable pageable) {
		return iUsuariosDao.findAll(pageable);
	}

	@Override
	public Usuarios getObtenerUusario(Long id) {
		return iUsuariosDao.findById(id).orElse(null);
	}

	@Override
	public Usuarios getObtenerusuarioByUsername(String username) {
		return iUsuariosDao.findByUsername(username);
	}

	@Override
	public Usuarios guardar(Usuarios usuario) {
		return iUsuariosDao.save(usuario);
	}

}
