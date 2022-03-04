package com.example.demo.dto;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "alergias")
public class Alergia {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String nombre;
	
	@OneToMany
	@JoinColumn(name = "id")
	private List<Produce_Alergia> produce_Alergias;
	
	@OneToMany
	@JoinColumn(name = "id")
	private List<Tiene_Alergia> tiene_Alergias;
	
	public Alergia() {
		
	}

	public Alergia(int id, String nombre, List<Produce_Alergia> produce_Alergias,
			List<Tiene_Alergia> tiene_Alergias) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.produce_Alergias = produce_Alergias;
		this.tiene_Alergias = tiene_Alergias;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Produce_Alergia")
	public List<Produce_Alergia> getProduce_Alergias() {
		return produce_Alergias;
	}

	public void setProduce_Alergias(List<Produce_Alergia> produce_Alergias) {
		this.produce_Alergias = produce_Alergias;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Tiene_Alergia")
	public List<Tiene_Alergia> getTiene_Alergias() {
		return tiene_Alergias;
	}

	public void setTiene_Alergias(List<Tiene_Alergia> tiene_Alergias) {
		this.tiene_Alergias = tiene_Alergias;
	}

	@Override
	public String toString() {
		return "Alergia [id=" + id + ", nombre=" + nombre + ", produce_Alergias=" + produce_Alergias
				+ ", tiene_Alergias=" + tiene_Alergias + "]";
	}
	
	
}
