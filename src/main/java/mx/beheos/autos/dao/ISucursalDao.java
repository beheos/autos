package mx.beheos.autos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.beheos.autos.entity.modelo.Sucursal;

public interface ISucursalDao extends JpaRepository<Sucursal, Long> {

}
