package com.example.demo.dto;

import javax.persistence.*;

@Entity
@Table(name = "realiza_peticiones")
public class Peticion {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_orden")
	private Orden orden;
	
	@ManyToOne
	@JoinColumn(name = "id_plato")
	private Plato plato;
	
	public Peticion() {
		
	}

	public Peticion(int id, Orden orden, Plato plato) {
		super();
		this.id = id;
		this.orden = orden;
		this.plato = plato;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "Peticion [id=" + id + ", orden=" + orden + ", plato=" + plato + "]";
	}
	
}
