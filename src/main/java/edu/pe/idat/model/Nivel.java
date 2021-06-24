package edu.pe.idat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Nivel {
	@Id
	private String idnivel;
	
	@Column(name ="numpiso")
	private String numpiso;
	
	@Column(name ="capacidad")
	private int capacidad;
	
	@Column(name ="estado")
	private String estado;

	public String getIdnivel() {
		return idnivel;
	}

	public void setIdnivel(String idnivel) {
		this.idnivel = idnivel;
	}

	public String getNumpiso() {
		return numpiso;
	}

	public void setNumpiso(String numpiso) {
		this.numpiso = numpiso;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Nivel(String idnivel, String numpiso, int capacidad, String estado) {
		super();
		this.idnivel = idnivel;
		this.numpiso = numpiso;
		this.capacidad = capacidad;
		this.estado = estado;
	}

	public Nivel(String numpiso, int capacidad, String estado) {
		super();
		this.numpiso = numpiso;
		this.capacidad = capacidad;
		this.estado = estado;
	}

	public Nivel() {
		super();
	
	}

	
	
	
	
	
}