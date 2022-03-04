package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IUsuarioDAO;
import com.example.demo.dto.Usuario;

@Service
public class UsuarioServicesImpl implements IUsuarioSERVICES{

	@Autowired
	IUsuarioDAO userDAO;
	
	@Override
	public List<Usuario> totalRegistro() {
		return userDAO.findAll();
	}

	@Override
	public Usuario ubicaPorID(int id) {
		return userDAO.findById(id).get();
	}

	@Override
	public void eliminaRegistroPorID(int id) {
		userDAO.deleteById(id);
	}

	@Override
	public Usuario agregaRegistro(Usuario usuario) {
		return userDAO.save(usuario);
	}

	@Override
	public Usuario actualizaResgistro(Usuario usuario) {
		return userDAO.save(usuario);
	}

}
