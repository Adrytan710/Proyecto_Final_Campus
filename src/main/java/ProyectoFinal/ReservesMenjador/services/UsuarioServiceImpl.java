package ProyectoFinal.ReservesMenjador.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProyectoFinal.ReservesMenjador.dao.IUsuarioDAO;
import ProyectoFinal.ReservesMenjador.dto.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioSERVICE{
	
	@Autowired
	IUsuarioDAO iUsuarioDAO;

	@Override
	public Usuario buscaPorUsuario(String usuario) 
	{
		return iUsuarioDAO.findByUsuario(usuario);
	}
}
