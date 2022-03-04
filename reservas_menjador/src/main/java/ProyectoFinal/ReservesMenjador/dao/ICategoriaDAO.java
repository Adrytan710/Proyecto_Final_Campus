package ProyectoFinal.ReservesMenjador.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ProyectoFinal.ReservesMenjador.dto.Categoria;

public interface ICategoriaDAO extends JpaRepository<Categoria, Integer>{

}
