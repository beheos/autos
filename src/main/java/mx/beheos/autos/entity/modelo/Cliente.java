package mx.beheos.autos.entity.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long idDomicilio;
	private Long idIdentificacion;
	private Integer estatus;
	private String nombre;
	private String paterno;
	private String materno;
	private String telefono;
	private String correo;
	private BigDecimal ingresos;
	private String numIdentificacion;
	private String usuarioIngreso;
	private String usuarioModifico;
	private String fechaIngreso;
	private String fechaModifico;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdDomicilio() {
		return idDomicilio;
	}
	public void setIdDomicilio(Long idDomicilio) {
		this.idDomicilio = idDomicilio;
	}
	public Long getIdIdentificacion() {
		return idIdentificacion;
	}
	public void setIdIdentificacion(Long idIdentificacion) {
		this.idIdentificacion = idIdentificacion;
	}
	public Integer getEstatus() {
		return estatus;
	}
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPaterno() {
		return paterno;
	}
	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}
	public String getMaterno() {
		return materno;
	}
	public void setMaterno(String materno) {
		this.materno = materno;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public BigDecimal getIngresos() {
		return ingresos;
	}
	public void setIngresos(BigDecimal ingresos) {
		this.ingresos = ingresos;
	}
	public String getNumIdentificacion() {
		return numIdentificacion;
	}
	public void setNumIdentificacion(String numIdentificacion) {
		this.numIdentificacion = numIdentificacion;
	}
	public String getUsuarioIngreso() {
		return usuarioIngreso;
	}
	public void setUsuarioIngreso(String usuarioIngreso) {
		this.usuarioIngreso = usuarioIngreso;
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
		return "Cliente [id=" + id + ", idDomicilio=" + idDomicilio + ", idIdentificacion=" + idIdentificacion
				+ ", estatus=" + estatus + ", nombre=" + nombre + ", paterno=" + paterno + ", materno=" + materno
				+ ", telefono=" + telefono + ", correo=" + correo + ", ingresos=" + ingresos + ", numIdentificacion="
				+ numIdentificacion + ", usuarioIngreso=" + usuarioIngreso + ", usuarioModifico=" + usuarioModifico
				+ ", fechaIngreso=" + fechaIngreso + ", fechaModifico=" + fechaModifico + "]";
	}

}
