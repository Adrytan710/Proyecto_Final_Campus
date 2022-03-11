package ProyectoFinal.ReservesMenjador.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProyectoFinal.ReservesMenjador.dao.IProduce_AlergiaDAO;
import ProyectoFinal.ReservesMenjador.dto.Alergia;
import ProyectoFinal.ReservesMenjador.dto.Plato;
import ProyectoFinal.ReservesMenjador.dto.Produce_Alergia;

@Service
public class Produce_AlergiaServicesImpl implements IProduce_AlergiaSERVICES{

	@Autowired
	IProduce_AlergiaDAO alergyDAO;
	
	@Override
	public List<Produce_Alergia> totalRegistro() {
		return alergyDAO.findAll();
	}

	@Override
	public Produce_Alergia ubicaPorID(int id) {
		return alergyDAO.findById(id).get();
	}

	@Override
	public void eliminaRegistroPorID(int id) {
		alergyDAO.deleteById(id);
	}

	@Override
	public Produce_Alergia agregaRegistro(Produce_Alergia alergy) {
		return alergyDAO.save(alergy);
	}

	@Override
	public Produce_Alergia actualizaResgistro(Produce_Alergia alergy) {
		return alergyDAO.save(alergy);
	}

	@Override
	public List<Produce_Alergia> buscaPorPlato(Plato plato) {
		return alergyDAO.findByPlato(plato);
	}

	@Override
	public List<Produce_Alergia> buscaPorAlergia(Alergia alergia) {
		return alergyDAO.findByAlergia(alergia);
	}

}
