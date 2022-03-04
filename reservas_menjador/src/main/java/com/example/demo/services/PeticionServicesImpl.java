package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IPeticionDAO;
import com.example.demo.dto.Peticion;

@Service
public class PeticionServicesImpl implements IPeticionSERVICES{
	
	@Autowired
	IPeticionDAO peticionDAO;

	@Override
	public List<Peticion> totalRegistro() {
		return peticionDAO.findAll();
	}

	@Override
	public Peticion ubicaPorID(int id) {
		return peticionDAO.findById(id).get();
	}

	@Override
	public void eliminaRegistroPorID(int id) {
		peticionDAO.deleteById(id);
	}

	@Override
	public Peticion agregaRegistro(Peticion peticion) {
		return peticionDAO.save(peticion);
	}

	@Override
	public Peticion actualizaResgistro(Peticion peticion) {
		return peticionDAO.save(peticion);
	}

}
