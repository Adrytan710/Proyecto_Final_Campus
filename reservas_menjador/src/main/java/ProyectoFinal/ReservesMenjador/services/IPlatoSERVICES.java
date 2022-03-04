package ProyectoFinal.ReservesMenjador.services;

import java.util.List;

import ProyectoFinal.ReservesMenjador.dto.Plato;

public interface IPlatoSERVICES {

	// CRUD 
	public List<Plato> totalRegistro();					
	public Plato ubicaPorID(int id);
	public void eliminaRegistroPorID(int id);
	public Plato agregaRegistro(Plato dish);
	public Plato actualizaResgistro(Plato dish);
}
