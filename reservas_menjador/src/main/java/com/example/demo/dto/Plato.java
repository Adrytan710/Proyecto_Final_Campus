package com.example.demo.dto;

import java.sql.Blob;
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
@Table(name = "platos")
public class Plato {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_plato;
	private String nombre;
	private Blob foto; ///VERIFICAR SI DE ESTA MANERA SE TRABAJA
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	
	@OneToMany
	@JoinColumn(name = "id_plato")
	private List<Peticion> peticions;
	
	public Plato() {
		
	}

	public Plato(int id_plato, String nombre, Blob foto, Categoria categoria, List<Peticion> peticions) {
		super();
		this.id_plato = id_plato;
		this.nombre = nombre;
		this.foto = foto;
		this.categoria = categoria;
		this.peticions = peticions;
	}

	public int getId_plato() {
		return id_plato;
	}

	public void setId_plato(int id_plato) {
		this.id_plato = id_plato;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Blob getFoto() {
		return foto;
	}

	public void setFoto(Blob foto) {
		this.foto = foto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Peticion")
	public List<Peticion> getPeticions() {
		return peticions;
	}

	public void setPeticions(List<Peticion> peticions) {
		this.peticions = peticions;
	}

	@Override
	public String toString() {
		return "Plato [id_plato=" + id_plato + ", nombre=" + nombre + ", foto=" + foto + ", categoria=" + categoria
				+ ", peticions=" + peticions + "]";
	}
	
}
