package edu.pe.idat.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_usuario")
public class TipoUsuario {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String idtipo;
	
	@Column
	private String nomtipo;

	public String getIdtipo() {
		return idtipo;
	}

	public void setIdtipo(String idtipo) {
		this.idtipo = idtipo;
	}

	public String getNomtipo() {
		return nomtipo;
	}

	public void setNomtipo(String nomtipo) {
		this.nomtipo = nomtipo;
	}

	public TipoUsuario(String idtipo, String nomtipo) {
		super();
		this.idtipo = idtipo;
		this.nomtipo = nomtipo;
	}

	public TipoUsuario() {
		super();
	}
	
}
