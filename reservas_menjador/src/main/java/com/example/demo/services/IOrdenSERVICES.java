package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Orden;

public interface IOrdenSERVICES {

	// CRUD 
			public List<Orden> totalRegistro();					
			public Orden ubicaPorID(int id);
			public void eliminaRegistroPorID(int id);
			public Orden agregaRegistro(Orden orden);
			public Orden actualizaResgistro(Orden orden);
}
