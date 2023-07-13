package mx.beheos.autos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.beheos.autos.entity.modelo.Color;
import mx.beheos.autos.entity.modelo.SubMarca;

public interface IColorDao extends JpaRepository<Color, Long> {
	
	Color findByColor(String color);

}
