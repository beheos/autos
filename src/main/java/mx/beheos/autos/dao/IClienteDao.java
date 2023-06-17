package mx.beheos.autos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.beheos.autos.entity.modelo.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Long> {

}
