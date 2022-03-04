package ProyectoFinal.ReservesMenjador.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProyectoFinal.ReservesMenjador.dao.IPeticionDAO;
import ProyectoFinal.ReservesMenjador.dto.Peticion;

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

}
