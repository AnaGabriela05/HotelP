package edu.pe.idat.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.FetchType;

@Entity
@Table(name="Usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String idUsuario;
	
	@Column
	private String nombre;
	
	@Column
	private String usuario;

	@Column
	private String password;

	@Column
	private boolean enabled;
	
	@Column
	private String telefono;
	
	@Column 
	private String idpais;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_tipo", joinColumns = @JoinColumn(name = "idusuario"), inverseJoinColumns = @JoinColumn(name = "idtipo"))
	private Set<TipoUsuario> tipousuario;

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getIdpais() {
		return idpais;
	}

	public void setIdpais(String idpais) {
		this.idpais = idpais;
	}

	public Set<TipoUsuario> getTipousuario() {
		return tipousuario;
	}

	public void setTipousuario(Set<TipoUsuario> tipousuario) {
		this.tipousuario = tipousuario;
	}

	public Usuario(String idUsuario, String nombre, String usuario, String password, boolean enabled, String telefono,
			String idpais, Set<TipoUsuario> tipousuario) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.usuario = usuario;
		this.password = password;
		this.enabled = enabled;
		this.telefono = telefono;
		this.idpais = idpais;
		this.tipousuario = tipousuario;
	}

	public Usuario() {
		super();
	}
	
	
	 
	
}
