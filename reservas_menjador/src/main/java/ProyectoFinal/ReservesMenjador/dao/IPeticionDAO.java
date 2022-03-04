package ProyectoFinal.ReservesMenjador.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ProyectoFinal.ReservesMenjador.dto.Peticion;

public interface IPeticionDAO extends JpaRepository<Peticion, Integer>{

}
