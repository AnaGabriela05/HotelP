package edu.pe.idat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Habitacion {
	@Id
	private String idhabitacion;
	
	@Column(name ="idcategoria")
	private String idcategoria;
	
	@Column(name ="idestado")
	private String idestado;
	
	@Column(name ="idnivel")
	private String idnivel;

	public String getIdhabitacion() {
		return idhabitacion;
	}

	public void setIdhabitacion(String idhabitacion) {
		this.idhabitacion = idhabitacion;
	}

	public String getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(String idcategoria) {
		this.idcategoria = idcategoria;
	}

	public String getIdestado() {
		return idestado;
	}

	public void setIdestado(String idestado) {
		this.idestado = idestado;
	}

	public String getIdnivel() {
		return idnivel;
	}

	public void setIdnivel(String idnivel) {
		this.idnivel = idnivel;
	}

	public Habitacion(String idcategoria, String idestado, String idnivel) {
		super();
		this.idcategoria = idcategoria;
		this.idestado = idestado;
		this.idnivel = idnivel;
	}

	public Habitacion(String idhabitacion, String idcategoria, String idestado, String idnivel) {
		super();
		this.idhabitacion = idhabitacion;
		this.idcategoria = idcategoria;
		this.idestado = idestado;
		this.idnivel = idnivel;
	}

	public Habitacion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	}