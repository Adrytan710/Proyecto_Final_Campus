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

import com.example.demo.dto.Alergia;
import com.example.demo.services.AlergiaServicesImpl;

@RestController
@RequestMapping("/api") // POR DETERMINAR SU USO
public class AlergiaController {

	@Autowired
	AlergiaServicesImpl alergySERV;

	@GetMapping("/alergias")
	public List<Alergia> totalRegistros(){
		return alergySERV.totalRegistro();
	}

	@GetMapping("/alergias/{id}")
	public Alergia ubicaPorID(@PathVariable (name = "id") int id) {
		return alergySERV.ubicaPorID(id);
	}

	@PostMapping("alergias/add")
	public Alergia agregaRegistro(@RequestBody Alergia alergy) {
		return alergySERV.agregaRegistro(alergy);
	}

	@PutMapping("alergias/{id}/agrega")
	public Alergia actualizaRegistro(@PathVariable (name = "id") int id, @RequestBody Alergia alergy) {
		Alergia alergySEL = new Alergia();
		Alergia alergyUPDATE = new Alergia();
		alergySEL = alergySERV.ubicaPorID(id);
		alergySEL.setNombre(alergy.getNombre());
		alergySEL.setProduce_Alergias(alergy.getProduce_Alergias());
		alergySEL.setTiene_Alergias(alergy.getTiene_Alergias());
		alergyUPDATE = alergySEL;

		return alergyUPDATE;
	}

	@DeleteMapping("alergias/{id}/delete")
	public void eliminaRegistro(@PathVariable (name = "id") int id) {
		alergySERV.eliminaRegistroPorID(id);
	}
}
