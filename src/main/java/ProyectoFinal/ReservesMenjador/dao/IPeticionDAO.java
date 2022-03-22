package ProyectoFinal.ReservesMenjador.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ProyectoFinal.ReservesMenjador.dto.Orden;
import ProyectoFinal.ReservesMenjador.dto.Peticion;
import ProyectoFinal.ReservesMenjador.dto.Plato;

public interface IPeticionDAO extends JpaRepository<Peticion, Integer>{
	List<Peticion> findByOrden(Orden orden);
	List<Peticion> findByPlato(Plato plato);
}
