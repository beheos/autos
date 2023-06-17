package mx.beheos.autos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.beheos.autos.entity.modelo.Usuarios;

public interface IUsuariosDao extends JpaRepository<Usuarios, Long> {

}
