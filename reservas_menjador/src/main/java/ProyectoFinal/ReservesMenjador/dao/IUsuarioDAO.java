package ProyectoFinal.ReservesMenjador.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ProyectoFinal.ReservesMenjador.dto.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Integer>{

}
