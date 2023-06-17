package mx.beheos.autos.service;

import mx.beheos.autos.entity.modelo.Roles;
import mx.beheos.autos.entity.modelo.Usuarios;

public interface IRegistroService {
	
	Usuarios guardar(Usuarios usuario);
	Roles guardarRol(Roles roles);
	void usuarioCreado(Usuarios usuario, Roles roles);

}
