package ProyectoFinal.ReservesMenjador.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProyectoFinal.ReservesMenjador.dao.IPlatoDAO;
import ProyectoFinal.ReservesMenjador.dto.Categoria;
import ProyectoFinal.ReservesMenjador.dto.Plato;

@Service
public class PlatoServicesImpl implements IPlatoSERVICES{

	@Autowired
	IPlatoDAO platoDAO;
	
	@Override
	public List<Plato> totalRegistro() {
		return platoDAO.findAll();
	}

	@Override
	public Plato ubicaPorID(int id) {
		return platoDAO.findById(id).get();
	}

	@Override
	public void eliminaRegistroPorID(int id) {
		platoDAO.deleteById(id);
	}

	@Override
	public Plato agregaRegistro(Plato dish) {
		return platoDAO.save(dish);
	}

	@Override
	public Plato actualizaResgistro(Plato dish) {
		return platoDAO.save(dish);
	}

	@Override
	public List<Plato> buscaPorCategoria(Categoria categoria) {
		return platoDAO.findByCategoria(categoria);
	}
}
