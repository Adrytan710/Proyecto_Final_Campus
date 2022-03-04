package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Alergia;

public interface IAlergiaSERVICES {

	// CRUD 
	public List<Alergia> totalRegistro();					
	public Alergia ubicaPorID(int id);
	public void eliminaRegistroPorID(int id);
	public Alergia agregaRegistro(Alergia alergy);
	public Alergia actualizaResgistro(Alergia alergy);
}
