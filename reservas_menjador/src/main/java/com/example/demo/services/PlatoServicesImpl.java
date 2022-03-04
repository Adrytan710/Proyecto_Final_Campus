package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IPlatoDAO;
import com.example.demo.dto.Plato;

@Service
public class PlatoServicesImpl implements IPlatoSERVICES{

	@Autowired
	IPlatoDAO platoDAO;
	
	@Override
	public List<Plato> totalRegistro() {
		return platoDAO.findAll();
	}

	@Override
	public Plato ubicaPorID(int id) {
		return platoDAO.findById(id).get();
	}

	@Override
	public void eliminaRegistroPorID(int id) {
		platoDAO.deleteById(id);
	}

	@Override
	public Plato agregaRegistro(Plato dish) {
		return platoDAO.save(dish);
	}

	@Override
	public Plato actualizaResgistro(Plato dish) {
		return platoDAO.save(dish);
	}
}
