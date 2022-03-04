package com.example.demo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "producen")
public class Produce_Alergia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_alerg_prod;
	
	@ManyToOne
	@JoinColumn(name = "id_plato")
	private Plato plato;
	
	@ManyToOne
	@JoinColumn(name = "id_alergia")
	private Alergia alergia;
	
	public Produce_Alergia() {
		
	}

	public Produce_Alergia(int id_alerg_prod, Plato plato, Alergia alergia) {
		super();
		this.id_alerg_prod = id_alerg_prod;
		this.plato = plato;
		this.alergia = alergia;
	}

	public int getId_alerg_prod() {
		return id_alerg_prod;
	}

	public void setId_alerg_prod(int id_alerg_prod) {
		this.id_alerg_prod = id_alerg_prod;
	}

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}

	public Alergia getAlergia() {
		return alergia;
	}

	public void setAlergia(Alergia alergia) {
		this.alergia = alergia;
	}

	@Override
	public String toString() {
		return "Produce_Alergia [id_alerg_prod=" + id_alerg_prod + ", plato=" + plato + ", alergia=" + alergia + "]";
	}
	
	
}
