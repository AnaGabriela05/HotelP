package edu.pe.idat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "descuento_precio")
public class Descuento_temporadaXcategoria {
	@Id
	private String idprecio;
	
	@Column(name ="descuento")
	private int descuento;
	
	@Column(name ="idtemporada")
	private String idtemporada;
	
	@Column(name ="idcategoria")
	private String idcategoria;

	public String getIdprecio() {
		return idprecio;
	}

	public void setIdprecio(String idprecio) {
		this.idprecio = idprecio;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public String getIdtemporada() {
		return idtemporada;
	}

	public void setIdtemporada(String idtemporada) {
		this.idtemporada = idtemporada;
	}

	public String getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(String idcategoria) {
		this.idcategoria = idcategoria;
	}

	public Descuento_temporadaXcategoria() {
		super();
		
	}

	public Descuento_temporadaXcategoria(int descuento) {
		super();
		this.descuento = descuento;
		
	}

	public Descuento_temporadaXcategoria(String idprecio, int descuento, String idtemporada, String idcategoria) {
		super();
		this.idprecio = idprecio;
		this.descuento = descuento;
		this.idtemporada = idtemporada;
		this.idcategoria = idcategoria;
	}

	public Descuento_temporadaXcategoria(String idprecio, int descuento) {
		super();
		this.idprecio = idprecio;
		this.descuento = descuento;
	}
	
	
	
	
	
	
}
