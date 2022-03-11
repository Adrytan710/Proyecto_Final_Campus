package ProyectoFinal.ReservesMenjador.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ProyectoFinal.ReservesMenjador.dto.Categoria;
import ProyectoFinal.ReservesMenjador.dto.Plato;

public interface IPlatoDAO extends JpaRepository<Plato, Integer>{
	List<Plato> findByCategoria(Categoria categoria);
}
