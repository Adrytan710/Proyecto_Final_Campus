package ProyectoFinal.ReservesMenjador.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ProyectoFinal.ReservesMenjador.dto.Orden;

public interface IOrdenDAO extends JpaRepository<Orden, Integer>{

}
