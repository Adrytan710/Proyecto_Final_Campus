package com.example.demo.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "alergias")
public class Alergia {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_alergia;
	
	private String nombre;
	
	@OneToMany
	@JoinColumn(name = "id_alergia")
	private List<Produce_Alergia> produce_Alergias;
	
	@OneToMany
	@JoinColumn(name = "id_alergia")
	private List<Tiene_Alergia> tiene_Alergias;
	
	public Alergia() {
		
	}

	public Alergia(int id_alergia, String nombre, List<Produce_Alergia> produce_Alergias,
			List<Tiene_Alergia> tiene_Alergias) {
		super();
		this.id_alergia = id_alergia;
		this.nombre = nombre;
		this.produce_Alergias = produce_Alergias;
		this.tiene_Alergias = tiene_Alergias;
	}

	public int getId_alergia() {
		return id_alergia;
	}

	public void setId_alergia(int id_alergia) {
		this.id_alergia = id_alergia;
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
		return "Alergia [id_alergia=" + id_alergia + ", nombre=" + nombre + ", produce_Alergias=" + produce_Alergias
				+ ", tiene_Alergias=" + tiene_Alergias + "]";
	}
	
	
}
