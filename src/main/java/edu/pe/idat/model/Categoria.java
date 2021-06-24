package edu.pe.idat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "categoriahabitacion")
public class Categoria {
	
	@Id
	private String idcategoria;
	
	@Column(name ="categoria")
	private String categoria;
	
	@Column(name ="descriph")
	private String descriph;
	
	@Column(name ="preciobase")
	private double preciobase;
	
	@Column(name ="preciodescuento")
	private double preciodescuento;
	
	@Column(name ="estado")
	private String estado;
	
	@Column(name ="foto")
	private String foto;


	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(String idcategoria) {
		this.idcategoria = idcategoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescriph() {
		return descriph;
	}

	public void setDescriph(String descriph) {
		this.descriph = descriph;
	}


	public double getPreciobase() {
		return preciobase;
	}

	public void setPreciobase(double preciobase) {
		this.preciobase = preciobase;
	}

	public double getPreciodescuento() {
		return preciodescuento;
	}

	public void setPreciodescuento(double preciodescuento) {
		this.preciodescuento = preciodescuento;
	}

	
	
	

	public Categoria(String categoria, String descriph, double preciobase, String estado, String foto) {
		super();
		this.categoria = categoria;
		this.descriph = descriph;
		this.preciobase = preciobase;
		this.estado = estado;
		this.foto = foto;
	}

	

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Categoria() {
		super();
		
	}
	
	
	
	

}
