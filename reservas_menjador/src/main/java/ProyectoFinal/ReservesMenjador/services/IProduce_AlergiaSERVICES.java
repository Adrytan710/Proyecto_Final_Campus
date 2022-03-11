package ProyectoFinal.ReservesMenjador.services;

import java.util.List;

import ProyectoFinal.ReservesMenjador.dto.Alergia;
import ProyectoFinal.ReservesMenjador.dto.Plato;
import ProyectoFinal.ReservesMenjador.dto.Produce_Alergia;

public interface IProduce_AlergiaSERVICES {

	// CRUD 
	public List<Produce_Alergia> totalRegistro();					
	public Produce_Alergia ubicaPorID(int id);
	public void eliminaRegistroPorID(int id);
	public Produce_Alergia agregaRegistro(Produce_Alergia alergy);
	public Produce_Alergia actualizaResgistro(Produce_Alergia alergy);
	public List<Produce_Alergia> buscaPorPlato(Plato plato);
	public List<Produce_Alergia> buscaPorAlergia(Alergia alergia);
}
