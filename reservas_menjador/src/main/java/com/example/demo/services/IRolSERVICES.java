package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Rol;

public interface IRolSERVICES {

	// CRUD 
	public List<Rol> totalRegistro();					
	public Rol ubicaPorID(int id);
	public void eliminaRegistroPorID(int id);
	public Rol agregaRegistro(Rol rol);
	public Rol actualizaResgistro(Rol rol);
}
