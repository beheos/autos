package mx.beheos.autos.entity.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cotizacion")
public class Cotizacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long idAuto;
	private Long idCliente;
	private Long tipoFinanciamiento;
	private Long idEmpleado;
	private BigDecimal montoSinIva;
	private BigDecimal montoTotal;
	private String observaciones;
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
	public Long getIdAuto() {
		return idAuto;
	}
	public void setIdAuto(Long idAuto) {
		this.idAuto = idAuto;
	}
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public Long getTipoFinanciamiento() {
		return tipoFinanciamiento;
	}
	public void setTipoFinanciamiento(Long tipoFinanciamiento) {
		this.tipoFinanciamiento = tipoFinanciamiento;
	}
	public Long getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public BigDecimal getMontoSinIva() {
		return montoSinIva;
	}
	public void setMontoSinIva(BigDecimal montoSinIva) {
		this.montoSinIva = montoSinIva;
	}
	public BigDecimal getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(BigDecimal montoTotal) {
		this.montoTotal = montoTotal;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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
		return "Cotizacion [id=" + id + ", idAuto=" + idAuto + ", idCliente=" + idCliente + ", tipoFinanciamiento="
				+ tipoFinanciamiento + ", idEmpleado=" + idEmpleado + ", montoSinIva=" + montoSinIva + ", montoTotal="
				+ montoTotal + ", observaciones=" + observaciones + ", usuarioIngreso=" + usuarioIngreso
				+ ", usuarioModifico=" + usuarioModifico + ", fechaIngreso=" + fechaIngreso + ", fechaModifico="
				+ fechaModifico + "]";
	}

}
