package ProyectoFinal.ReservesMenjador.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ProyectoFinal.ReservesMenjador.dto.Alergia;
import ProyectoFinal.ReservesMenjador.dto.Tiene_Alergia;
import ProyectoFinal.ReservesMenjador.dto.Usuario;

public interface ITiene_AlergiaDAO extends JpaRepository<Tiene_Alergia, Integer>{
	List<Tiene_Alergia> findByUsuario(Usuario usuario);
	List<Tiene_Alergia> findByAlergia(Alergia alergia);
}
