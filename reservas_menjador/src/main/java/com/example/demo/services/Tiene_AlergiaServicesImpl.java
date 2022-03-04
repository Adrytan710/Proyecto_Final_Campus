package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ITiene_AlergiaDAO;
import com.example.demo.dto.Tiene_Alergia;

@Service
public class Tiene_AlergiaServicesImpl implements ITiene_AlergiaSERVICES{

	@Autowired
	ITiene_AlergiaDAO tieneDAO;
	
	@Override
	public List<Tiene_Alergia> totalRegistro() {
		return tieneDAO.findAll();
	}

	@Override
	public Tiene_Alergia ubicaPorID(int id) {
		return tieneDAO.findById(id).get();
	}

	@Override
	public void eliminaRegistroPorID(int id) {
		tieneDAO.deleteById(id);
	}

	@Override
	public Tiene_Alergia agregaRegistro(Tiene_Alergia tiene) {
		return tieneDAO.save(tiene);
	}

	@Override
	public Tiene_Alergia actualizaResgistro(Tiene_Alergia tiene) {
		return tieneDAO.save(tiene);
	}

}
