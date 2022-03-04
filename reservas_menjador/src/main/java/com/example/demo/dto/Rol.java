package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ValueGenerationType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "roles")
public class Rol {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id_rol;
	
	private String nombre;
	private String apellido;
	
	@OneToMany
	@JoinColumn(name = "id_rol")
	private List<Usuario> usuarios;
	
	public Rol() {
		
	}

	public Rol(int id_rol, String nombre, String apellido, List<Usuario> usuarios) {
		super();
		this.id_rol = id_rol;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuarios = usuarios;
	}

	public int getId_rol() {
		return id_rol;
	}

	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Usuario")
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "Rol [id_rol=" + id_rol + ", nombre=" + nombre + ", apellido=" + apellido + ", usuarios=" + usuarios
				+ "]";
	}
	
	
}
