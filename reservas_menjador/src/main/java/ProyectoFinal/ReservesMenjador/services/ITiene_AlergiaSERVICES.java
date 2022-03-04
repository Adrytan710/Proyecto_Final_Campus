package ProyectoFinal.ReservesMenjador.services;

import java.util.List;

import ProyectoFinal.ReservesMenjador.dto.Tiene_Alergia;

public interface ITiene_AlergiaSERVICES {

	// CRUD 
	public List<Tiene_Alergia> totalRegistro();					
	public Tiene_Alergia ubicaPorID(int id);
	public void eliminaRegistroPorID(int id);
	public Tiene_Alergia agregaRegistro(Tiene_Alergia tiene);
	public Tiene_Alergia actualizaResgistro(Tiene_Alergia tiene);
}
