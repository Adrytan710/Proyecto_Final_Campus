package ProyectoFinal.ReservesMenjador.services;

import java.util.List;

import ProyectoFinal.ReservesMenjador.dto.Categoria;

public interface ICategoriaSERVICES {

	// CRUD 
		public List<Categoria> totalRegistro();					
		public Categoria ubicaPorID(int id);
		public void eliminaRegistroPorID(int id);
		public Categoria agregaRegistro(Categoria category);
		public Categoria actualizaResgistro(Categoria category);
}
