package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IOrdenDAO;
import com.example.demo.dto.Orden;

@Service
public class OrdenServicesImpl implements IOrdenSERVICES{
	
	@Autowired
	IOrdenDAO orderDAO;

	@Override
	public List<Orden> totalRegistro() {
		return orderDAO.findAll();
	}

	@Override
	public Orden ubicaPorID(int id) {
		return orderDAO.findById(id).get();
	}

	@Override
	public void eliminaRegistroPorID(int id) {
		orderDAO.deleteById(id);
	}

	@Override
	public Orden agregaRegistro(Orden orden) {
		return orderDAO.save(orden);
	}

	@Override
	public Orden actualizaResgistro(Orden orden) {
		return orderDAO.save(orden);
	}

}
