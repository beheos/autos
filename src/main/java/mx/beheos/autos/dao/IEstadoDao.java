package mx.beheos.autos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.beheos.autos.entity.modelo.Estado;

public interface IEstadoDao extends JpaRepository<Estado, Long> {

}
