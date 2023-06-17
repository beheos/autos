package mx.beheos.autos.entity.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cFinanciamiento")
public class Financiamiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String financiamiento;
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
	public String getFinanciamiento() {
		return financiamiento;
	}
	public void setFinanciamiento(String financiamiento) {
		this.financiamiento = financiamiento;
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
		return "Financiamiento [id=" + id + ", financiamiento=" + financiamiento + ", usuarioIngreso=" + usuarioIngreso
				+ ", usuarioModifico=" + usuarioModifico + ", fechaIngreso=" + fechaIngreso + ", fechaModifico="
				+ fechaModifico + "]";
	}
	
	
}
