package ProyectoFinal.ReservesMenjador.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ProyectoFinal.ReservesMenjador.dto.Orden;
import ProyectoFinal.ReservesMenjador.dto.Usuario;

public interface IOrdenDAO extends JpaRepository<Orden, Integer>{
	List<Orden> findByUsuario(Usuario usuario);
}
