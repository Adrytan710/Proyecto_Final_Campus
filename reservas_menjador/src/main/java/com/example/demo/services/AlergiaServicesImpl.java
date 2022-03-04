package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IAlergiaDAO;
import com.example.demo.dto.Alergia;

@Service
public class AlergiaServicesImpl implements IAlergiaSERVICES{

	@Autowired
	IAlergiaDAO alergyDAO;
	
	@Override
	public List<Alergia> totalRegistro() {
		return alergyDAO.findAll();
	}

	@Override
	public Alergia ubicaPorID(int id) {
		return alergyDAO.findById(id).get();
	}

	@Override
	public void eliminaRegistroPorID(int id) {
		alergyDAO.deleteById(id);
	}

	@Override
	public Alergia agregaRegistro(Alergia alergy) {
		return alergyDAO.save(alergy);
	}

	@Override
	public Alergia actualizaResgistro(Alergia alergy) {
		return alergyDAO.save(alergy);
	}

}
