package mx.beheos.autos.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mx.beheos.autos.entity.modelo.Usuarios;

public interface IUsuarioService {
	
	Page<Usuarios>getUsuaurios(Pageable pageable);
	Usuarios getObtenerUusario(Long id);
	Usuarios getObtenerusuarioByUsername(String username);
	Usuarios guardar(Usuarios usuario);

}
