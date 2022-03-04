package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Categoria;

public interface ICategoriaSERVICES {

	// CRUD 
		public List<Categoria> totalRegistro();					
		public Categoria ubicaPorID(int id);
		public void eliminaRegistroPorID(int id);
		public Categoria agregaRegistro(Categoria category);
		public Categoria actualizaResgistro(Categoria category);
}
