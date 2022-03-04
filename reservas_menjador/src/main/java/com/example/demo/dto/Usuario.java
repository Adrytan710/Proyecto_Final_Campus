package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_usuario;
	
	private String usuario;
	private String pass_usuario;
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "id_rol")
	private Rol rol;
	
	@OneToMany
	@JoinColumn(name = "id_usuario")
	private List<Orden> ordenes;
	
	@OneToMany
	@JoinColumn(name = "id_usuario")
	private List<Tiene_Alergia> alergias;
	
	public Usuario() {
		
	}

	public Usuario(int id_usuario, String usuario, String pass_usuario, String email, Rol rol, List<Orden> ordenes,
			List<Tiene_Alergia> alergias) {
		super();
		this.id_usuario = id_usuario;
		this.usuario = usuario;
		this.pass_usuario = pass_usuario;
		this.email = email;
		this.rol = rol;
		this.ordenes = ordenes;
		this.alergias = alergias;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPass_usuario() {
		return pass_usuario;
	}

	public void setPass_usuario(String pass_usuario) {
		this.pass_usuario = pass_usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Orden")
	public List<Orden> getOrdenes() {
		return ordenes;
	}

	public void setOrdenes(List<Orden> ordenes) {
		this.ordenes = ordenes;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Tiene_Alergia")
	public List<Tiene_Alergia> getAlergias() {
		return alergias;
	}

	public void setAlergias(List<Tiene_Alergia> alergias) {
		this.alergias = alergias;
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", usuario=" + usuario + ", pass_usuario=" + pass_usuario
				+ ", email=" + email + ", rol=" + rol + ", ordenes=" + ordenes + ", alergias=" + alergias + "]";
	}

	
}
