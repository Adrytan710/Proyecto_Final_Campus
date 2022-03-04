package com.example.demo.dto;

import java.sql.Date;
import java.util.List;

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
@Table(name = "ordenes")
public class Orden {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_orden;
	
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@OneToMany
	@JoinColumn(name = "id_orden")
	private List<Peticion> peticion; 
	
	public Orden() {
		
	}

	public Orden(int id_orden, Date fecha, Usuario usuario, List<Peticion> peticion) {
		super();
		this.id_orden = id_orden;
		this.fecha = fecha;
		this.usuario = usuario;
		this.peticion = peticion;
	}

	public int getId_orden() {
		return id_orden;
	}

	public void setId_orden(int id_orden) {
		this.id_orden = id_orden;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Peticion")
	public List<Peticion> getPeticion() {
		return peticion;
	}

	public void setPeticion(List<Peticion> peticion) {
		this.peticion = peticion;
	}

	@Override
	public String toString() {
		return "Orden [id_orden=" + id_orden + ", fecha=" + fecha + ", usuario=" + usuario + ", peticion=" + peticion
				+ "]";
	}
}
