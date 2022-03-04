package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Rol;
import com.example.demo.services.RolServicesImpl;

@RestController
@RequestMapping("/api") // POR DETERMINAR SU USO
public class RolController {

	@Autowired
	RolServicesImpl rolSERV;

	@GetMapping("/roles")
	public List<Rol> totalRegistros(){
		return rolSERV.totalRegistro();
	}

	@GetMapping("/roles/{id}")
	public Rol ubicaPorID(@PathVariable (name = "id") int id) {
		return rolSERV.ubicaPorID(id);
	}

	@PostMapping("roles/add")
	public Rol agregaRegistro(@RequestBody Rol rol) {
		return rolSERV.agregaRegistro(rol);
	}

	@PutMapping("roles/{id}/agrega")
	public Rol actualizaRegistro(@PathVariable (name = "id") int id, @RequestBody Rol rol) {
		Rol rolSEL = new Rol();
		Rol rolUPDATE = new Rol();
		rolSEL = rolSERV.ubicaPorID(id);
		rolSEL.setNombre(rol.getNombre());
		rolUPDATE = rolSEL;

		return rolUPDATE;
	}

	@DeleteMapping("roles/{id}/delete")
	public void eliminaRegistro(@PathVariable (name = "id") int id) {
		rolSERV.eliminaRegistroPorID(id);
	}
}
