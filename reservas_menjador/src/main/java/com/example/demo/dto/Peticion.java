package com.example.demo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "realiza_peticiones")
public class Peticion {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_peticiones;
	
	@ManyToOne
	@JoinColumn(name = "id_orden")
	private Orden orden;
	
	@ManyToOne
	@JoinColumn(name = "id_plato")
	private Plato plato;
	
	public Peticion() {
		
	}

	public Peticion(int id_peticiones, Orden orden, Plato plato) {
		super();
		this.id_peticiones = id_peticiones;
		this.orden = orden;
		this.plato = plato;
	}

	public int getId_peticiones() {
		return id_peticiones;
	}

	public void setId_peticiones(int id_peticiones) {
		this.id_peticiones = id_peticiones;
	}

	public Orden getOrden() {
		return orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}

	@Override
	public String toString() {
		return "Peticion [id_peticiones=" + id_peticiones + ", orden=" + orden + ", plato=" + plato + "]";
	}
	
}
