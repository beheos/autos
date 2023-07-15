package mx.beheos.autos.entity.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "id_marca")
	private Marca marca;
	@ManyToOne
	@JoinColumn(name = "id_sub_marca")
	private SubMarca subMarca;
	private Integer modelo;
	@ManyToOne
	@JoinColumn(name = "id_estado")
	private Estado estado;
	@ManyToOne
	@JoinColumn(name = "id_sucursal")
	private Sucursal sucursal;
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name = "id_tipo_carro")
	private TipoAutomovil tipoAutomovil;
	private String numeroSerie;
	@ManyToOne
	@JoinColumn(name = "id_color")
	private Color color;
	private BigDecimal kilometraje;
	private BigDecimal precio;
	private Integer nPuertas;
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
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	public SubMarca getSubMarca() {
		return subMarca;
	}
	public void setSubMarca(SubMarca subMarca) {
		this.subMarca = subMarca;
	}
	public Integer getModelo() {
		return modelo;
	}
	public void setModelo(Integer modelo) {
		this.modelo = modelo;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Sucursal getSucursal() {
		return sucursal;
	}
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public TipoAutomovil getTipoAutomovil() {
		return tipoAutomovil;
	}
	public void setTipoAutomovil(TipoAutomovil tipoAutomovil) {
		this.tipoAutomovil = tipoAutomovil;
	}
	public String getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public BigDecimal getKilometraje() {
		return kilometraje;
	}
	public void setKilometraje(BigDecimal kilometraje) {
		this.kilometraje = kilometraje;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public Integer getnPuertas() {
		return nPuertas;
	}
	public void setnPuertas(Integer nPuertas) {
		this.nPuertas = nPuertas;
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
		return "Vehiculo [id=" + id + ", marca=" + marca + ", subMarca=" + subMarca + ", modelo=" + modelo + ", estado="
				+ estado + ", sucursal=" + sucursal + ", cliente=" + cliente + ", tipoAutomovil=" + tipoAutomovil
				+ ", numeroSerie=" + numeroSerie + ", color=" + color + ", kilometraje=" + kilometraje + ", precio="
				+ precio + ", nPuertas=" + nPuertas + ", observaciones=" + observaciones + ", usuarioIngreso="
				+ usuarioIngreso + ", usuarioModifico=" + usuarioModifico + ", fechaIngreso=" + fechaIngreso
				+ ", fechaModifico=" + fechaModifico + "]";
	}
	
}
