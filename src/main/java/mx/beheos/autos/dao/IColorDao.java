package mx.beheos.autos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.beheos.autos.entity.modelo.Color;

public interface IColorDao extends JpaRepository<Color, Long> {

}
