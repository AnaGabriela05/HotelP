package edu.pe.idat.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Temporada {
	
	@Id
	private String idtemporada;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")			
	@Column(name ="fechafi")
	private LocalDate fechafi;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name ="fechaini")
	private LocalDate fechaini;
	
	@Column(name ="temporada")
	private String temporada;
	
	@Column(name ="descripcion")
	private String descripcion;
	
	@Column(name ="estado")
	private String estado;
	
	@Column(name ="foto")
	private String foto;

	public String getIdtemporada() {
		return idtemporada;
	}
	
	
	
	
	
	public void setIdtemporada(String idtemporada) {
		this.idtemporada = idtemporada;
	}

	
	public Temporada() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LocalDate getFechafi() {
		return fechafi;
	}

	public void setFechafi(LocalDate fechafi) {
		this.fechafi = fechafi;
	}

	public LocalDate getFechaini() {
		return fechaini;
	}

	public void setFechaini(LocalDate fechaini) {
		this.fechaini = fechaini;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Temporada(LocalDate fechafi, LocalDate fechaini, String temporada, String descripcion, String estado) {
		super();
		this.fechafi = fechafi;
		this.fechaini = fechaini;
		this.temporada = temporada;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Temporada(String idtemporada, LocalDate fechafi, LocalDate fechaini, String temporada,
			String descripcion, String estado) {
		super();
		this.idtemporada = idtemporada;
		this.fechafi = fechafi;
		this.fechaini = fechaini;
		this.temporada = temporada;
		this.descripcion = descripcion;
		this.estado = estado;
	}
	
	
	
	public String getFoto() {
		return foto;
	}





	public void setFoto(String foto) {
		this.foto = foto;
	}





	public Temporada(LocalDate fechafi, LocalDate fechaini, String temporada, String descripcion, String estado,String foto) {
		super();
		this.fechafi = fechafi;
		this.fechaini = fechaini;
		this.temporada = temporada;
		this.descripcion = descripcion;
		this.estado = estado;
		this.foto = foto;
	}
	

}
