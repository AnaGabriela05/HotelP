package edu.pe.idat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Listar_Habitacion {
	@Id
	private String idhabitacion;
	
	@Column(name ="categoria")
	private String categoria;
	
	@Column(name ="nomestado")
	private String nomestado;
	
	@Column(name ="numpiso")
	private String numpiso;

	public String getIdhabitacion() {
		return idhabitacion;
	}

	public void setIdhabitacion(String idhabitacion) {
		this.idhabitacion = idhabitacion;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNomestado() {
		return nomestado;
	}

	public void setNomestado(String nomestado) {
		this.nomestado = nomestado;
	}

	public String getNumpiso() {
		return numpiso;
	}

	public void setNumpiso(String numpiso) {
		this.numpiso = numpiso;
	}

	
	
	
	
	
	
	
	
	
	
	
}
