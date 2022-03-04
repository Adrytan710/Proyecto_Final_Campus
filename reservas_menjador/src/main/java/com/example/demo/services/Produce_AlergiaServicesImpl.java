package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProduce_AlergiaDAO;
import com.example.demo.dto.Produce_Alergia;

@Service
public class Produce_AlergiaServicesImpl implements IProduce_AlergiaSERVICES{

	@Autowired
	IProduce_AlergiaDAO alergyDAO;
	
	@Override
	public List<Produce_Alergia> totalRegistro() {
		return alergyDAO.findAll();
	}

	@Override
	public Produce_Alergia ubicaPorID(int id) {
		return alergyDAO.findById(id).get();
	}

	@Override
	public void eliminaRegistroPorID(int id) {
		alergyDAO.deleteById(id);
	}

	@Override
	public Produce_Alergia agregaRegistro(Produce_Alergia alergy) {
		return alergyDAO.save(alergy);
	}

	@Override
	public Produce_Alergia actualizaResgistro(Produce_Alergia alergy) {
		return alergyDAO.save(alergy);
	}

}
