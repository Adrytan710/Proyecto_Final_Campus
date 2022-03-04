package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICategoriaDAO;
import com.example.demo.dto.Categoria;

@Service
public class CategoriaServicesImpl implements ICategoriaSERVICES{
	
	@Autowired
	ICategoriaDAO categoriaDAO;

	@Override
	public List<Categoria> totalRegistro() {
		return categoriaDAO.findAll();
	}

	@Override
	public Categoria ubicaPorID(int id) {
		
		return categoriaDAO.findById(id).get();
	}

	@Override
	public void eliminaRegistroPorID(int id) {
		categoriaDAO.deleteById(id);
	}

	@Override
	public Categoria agregaRegistro(Categoria category) {
		return categoriaDAO.save(category);
	}

	@Override
	public Categoria actualizaResgistro(Categoria category) {
		return categoriaDAO.save(category);
	}

}
