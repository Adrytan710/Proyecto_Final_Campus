package ProyectoFinal.ReservesMenjador.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProyectoFinal.ReservesMenjador.dao.ITiene_AlergiaDAO;
import ProyectoFinal.ReservesMenjador.dto.Alergia;
import ProyectoFinal.ReservesMenjador.dto.Tiene_Alergia;
import ProyectoFinal.ReservesMenjador.dto.Usuario;

@Service
public class Tiene_AlergiaServicesImpl implements ITiene_AlergiaSERVICES{

	@Autowired
	ITiene_AlergiaDAO tieneDAO;
	
	@Override
	public List<Tiene_Alergia> totalRegistro() {
		return tieneDAO.findAll();
	}

	@Override
	public Tiene_Alergia ubicaPorID(int id) {
		return tieneDAO.findById(id).get();
	}

	@Override
	public void eliminaRegistroPorID(int id) {
		tieneDAO.deleteById(id);
	}

	@Override
	public Tiene_Alergia agregaRegistro(Tiene_Alergia tiene) {
		return tieneDAO.save(tiene);
	}

	@Override
	public Tiene_Alergia actualizaResgistro(Tiene_Alergia tiene) {
		return tieneDAO.save(tiene);
	}

	@Override
	public List<Tiene_Alergia> buscaPorUsuario(Usuario usuario) {
		return tieneDAO.findByUsuario(usuario);
	}

	@Override
	public List<Tiene_Alergia> buscaPorAlergia(Alergia alergia) {
		return tieneDAO.findByAlergia(alergia);
	}

}
