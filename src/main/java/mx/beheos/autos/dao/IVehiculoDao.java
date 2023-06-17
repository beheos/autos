package mx.beheos.autos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.beheos.autos.entity.modelo.Vehiculo;

public interface IVehiculoDao extends JpaRepository<Vehiculo, Long> {

}
