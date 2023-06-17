package mx.beheos.autos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.beheos.autos.entity.modelo.Marca;

public interface IMarcaoDao extends JpaRepository<Marca, Long> {

}
