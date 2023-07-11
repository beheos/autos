package mx.beheos.autos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.beheos.autos.entity.modelo.Roles;

@Repository
public interface IRoles extends JpaRepository<Roles, Long> {
	
	@Query(value = "SELECT * FROM autos.roles where username = :username", nativeQuery = true)
	List<Roles>findByUsername(@Param("username") String username);
	
	void deleteByUsernameAndRol(String username, String rol);

	

}
