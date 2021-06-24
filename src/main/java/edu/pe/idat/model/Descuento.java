package edu.pe.idat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Descuento {
	@Id
	private String idprecio;
	
	
	@Column(name ="categoria")
	private String categoria;
	
	@Column(name ="temporada")
	private String temporada;
	
	@Column(name ="descuento")
	private int descuento;
	
	@Column(name ="preciobase")
	private Double preciobase;
	
	@Column(name ="precio_descuento")
	private Double precio_descuento;
	
	@Column(name ="diferencia")
	private Double diferencia;
	
	

	public String getIdprecio() {
		return idprecio;
	}

	public void setIdprecio(String idprecio) {
		this.idprecio = idprecio;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public Double getPreciobase() {
		return preciobase;
	}

	public void setPreciobase(Double preciobase) {
		this.preciobase = preciobase;
	}

	public Double getPrecio_descuento() {
		return precio_descuento;
	}

	public void setPrecio_descuento(Double precio_descuento) {
		this.precio_descuento = precio_descuento;
	}

	public Double getDiferencia() {
		return diferencia;
	}

	public void setDiferencia(Double diferencia) {
		this.diferencia = diferencia;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	
}
