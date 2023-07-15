package mx.beheos.autos.entity.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "usuarios")
public class Usuarios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "El campo usuario no puede ser vacio")
	private String username;
	@NotEmpty(message = "El campo password no puede ser vacio")
	private String password;
	private byte enabled;
	@NotEmpty(message = "El campo mail no puede ser vacio")
	@Email(message = "No es un formato Valido para email")
	private String mail;
	private String usuarioModifico;
	private String fechaIngreso;
	private String fechaModifico;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public byte getEnabled() {
		return enabled;
	}
	public void setEnabled(byte enabled) {
		this.enabled = enabled;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getUsuarioModifico() {
		return usuarioModifico;
	}
	public void setUsuarioModifico(String usuarioModifico) {
		this.usuarioModifico = usuarioModifico;
	}
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getFechaModifico() {
		return fechaModifico;
	}
	public void setFechaModifico(String fechaModifico) {
		this.fechaModifico = fechaModifico;
	}
	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", username=" + username + ", password=" + password + ", enabled=" + enabled
				+ "]";
	}
	
}
