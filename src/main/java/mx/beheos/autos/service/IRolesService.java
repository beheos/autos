package mx.beheos.autos.service;

import java.util.List;

import mx.beheos.autos.entity.modelo.Roles;

public interface IRolesService {
	
	List<Roles>roles(String username);
	void eliminarRol(String username, String rol);
	Roles ingresarRol(Roles rol);

}
