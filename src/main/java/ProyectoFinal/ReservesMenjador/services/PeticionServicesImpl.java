package ProyectoFinal.ReservesMenjador.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProyectoFinal.ReservesMenjador.dao.IPeticionDAO;
import ProyectoFinal.ReservesMenjador.dto.Orden;
import ProyectoFinal.ReservesMenjador.dto.Peticion;
import ProyectoFinal.ReservesMenjador.dto.Plato;

@Service
public class PeticionServicesImpl implements IPeticionSERVICES{
	
	@Autowired
	IPeticionDAO peticionDAO;

	@Override
	public List<Peticion> totalRegistro() {
		return peticionDAO.findAll();
	}

	@Override
	public Peticion ubicaPorID(int id) {
		return peticionDAO.findById(id).get();
	}

	@Override
	public void eliminaRegistroPorID(int id) {
		peticionDAO.deleteById(id);
	}

	@Override
	public Peticion agregaRegistro(Peticion peticion) {
		return peticionDAO.save(peticion);
	}

	@Override
	public Peticion actualizaResgistro(Peticion peticion) {
		return peticionDAO.save(peticion);
	}

	@Override
	public List<Peticion> buscaPorOrden(Orden orden) {
		return peticionDAO.findByOrden(orden);
	}

	@Override
	public List<Peticion> buscaPorPlato(Plato plato) {
		return peticionDAO.findByPlato(plato);
	}

}
