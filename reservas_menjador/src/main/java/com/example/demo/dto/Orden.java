package com.example.demo.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ordenes")
public class Orden {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@OneToMany
	@JoinColumn(name = "id")
	private List<Peticion> peticion; 
	
	public Orden() {
		
	}

	public Orden(int id, Date fecha, Usuario usuario, List<Peticion> peticion) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.usuario = usuario;
		this.peticion = peticion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "Orden [id=" + id + ", fecha=" + fecha + ", usuario=" + usuario + ", peticion=" + peticion
				+ "]";
	}
}
