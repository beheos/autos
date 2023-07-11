package mx.beheos.autos.entity.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String idEmpleado;
	@ManyToOne
	@JoinColumn(name = "id_sucursal")
	private Sucursal sucursal;
	private String nombre;
	private String paterno;
	private String materno;
	private Integer edad;
	private String usuarioIngreso;
	private String usuarioModifico;
	private String fechaIngreso;
	private String fechaModifico;
	private byte enabled;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
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
	public Sucursal getSucursal() {
		return sucursal;
	}
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	public String getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", idEmpleado=" + idEmpleado + ", sucursal=" + sucursal + ", nombre=" + nombre
				+ ", paterno=" + paterno + ", materno=" + materno + ", edad=" + edad + ", usuarioIngreso="
				+ usuarioIngreso + ", usuarioModifico=" + usuarioModifico + ", fechaIngreso=" + fechaIngreso
				+ ", fechaModifico=" + fechaModifico + "]";
	}
	public byte getEnabled() {
		return enabled;
	}
	public void setEnabled(byte enabled) {
		this.enabled = enabled;
	}
	
	
}
