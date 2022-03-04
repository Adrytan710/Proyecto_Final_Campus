package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Peticion;

public interface IPeticionSERVICES {

	// CRUD 
	public List<Peticion> totalRegistro();					
	public Peticion ubicaPorID(int id);
	public void eliminaRegistroPorID(int id);
	public Peticion agregaRegistro(Peticion peticion);
	public Peticion actualizaResgistro(Peticion peticion);
}
