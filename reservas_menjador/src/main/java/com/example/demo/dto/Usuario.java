package com.example.demo.dto;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String usuario;
	@Column
	private String pass_usuario;
	@Column
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "id_rol")
	private Rol rol;
	
	@OneToMany
	@JoinColumn(name = "id")
	private List<Orden> ordenes;
	
	@OneToMany
	@JoinColumn(name = "id")
	private List<Tiene_Alergia> alergias;
	
	public Usuario() {
		
	}

	public Usuario(int id, String usuario, String pass_usuario, String email, Rol rol, List<Orden> ordenes,
			List<Tiene_Alergia> alergias) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.pass_usuario = pass_usuario;
		this.email = email;
		this.rol = rol;
		this.ordenes = ordenes;
		this.alergias = alergias;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "Usuario [id=" + id + ", usuario=" + usuario + ", pass_usuario=" + pass_usuario
				+ ", email=" + email + ", rol=" + rol + ", ordenes=" + ordenes + ", alergias=" + alergias + "]";
	}

	
}
