package ProyectoFinal.ReservesMenjador.services;

import java.util.List;

import ProyectoFinal.ReservesMenjador.dto.Orden;
import ProyectoFinal.ReservesMenjador.dto.Usuario;

public interface IOrdenSERVICES {

	// CRUD 
			public List<Orden> totalRegistro();					
			public Orden ubicaPorID(int id);
			public void eliminaRegistroPorID(int id);
			public Orden agregaRegistro(Orden orden);
			public Orden actualizaResgistro(Orden orden);
			public List<Orden> buscaPorUsuario(Usuario usuario);		
}
