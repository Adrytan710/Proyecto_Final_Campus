package ProyectoFinal.ReservesMenjador.services;

import java.util.List;

import ProyectoFinal.ReservesMenjador.dto.Orden;
import ProyectoFinal.ReservesMenjador.dto.Peticion;
import ProyectoFinal.ReservesMenjador.dto.Plato;

public interface IPeticionSERVICES {

	// CRUD 
	public List<Peticion> totalRegistro();					
	public Peticion ubicaPorID(int id);
	public void eliminaRegistroPorID(int id);
	public Peticion agregaRegistro(Peticion peticion);
	public Peticion actualizaResgistro(Peticion peticion);
	public List<Peticion> buscaPorOrden(Orden orden);	
	public List<Peticion> buscaPorPlato(Plato plato);	
}
