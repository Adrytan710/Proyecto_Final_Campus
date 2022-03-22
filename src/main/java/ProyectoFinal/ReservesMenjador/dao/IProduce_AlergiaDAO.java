package ProyectoFinal.ReservesMenjador.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ProyectoFinal.ReservesMenjador.dto.Alergia;
import ProyectoFinal.ReservesMenjador.dto.Plato;
import ProyectoFinal.ReservesMenjador.dto.Produce_Alergia;

public interface IProduce_AlergiaDAO extends JpaRepository<Produce_Alergia, Integer>{
	List<Produce_Alergia> findByPlato(Plato plato);
	List<Produce_Alergia> findByAlergia(Alergia alergia);
}
