package ProyectoFinal.ReservesMenjador.services;

import java.util.List;

import ProyectoFinal.ReservesMenjador.dto.Usuario;

public interface IUsuarioSERVICES {

	// CRUD 
	public List<Usuario> totalRegistro();					
	public Usuario ubicaPorID(int id);
	public void eliminaRegistroPorID(int id);
	public Usuario agregaRegistro(Usuario tiene);
	public Usuario actualizaResgistro(Usuario tiene);
}
