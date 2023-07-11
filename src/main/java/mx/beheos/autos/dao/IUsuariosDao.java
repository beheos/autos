package mx.beheos.autos.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.beheos.autos.entity.modelo.Usuarios;
import mx.beheos.autos.entity.modeloDTO.UsuariosDTO;

public interface IUsuariosDao extends JpaRepository<Usuarios, Long> {
	
	Usuarios findByUsername(String username);
	
}
