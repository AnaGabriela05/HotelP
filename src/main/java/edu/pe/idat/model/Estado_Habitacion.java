package edu.pe.idat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Estado_Habitacion {
	@Id
	private String idestado;
	
	@Column(name ="nomestado")
	private String nomestado;

	public String getIdestado() {
		return idestado;
	}

	public void setIdestado(String idestado) {
		this.idestado = idestado;
	}

	public String getNomestado() {
		return nomestado;
	}

	public void setNomestado(String nomestado) {
		this.nomestado = nomestado;
	}
	
	
	
}
