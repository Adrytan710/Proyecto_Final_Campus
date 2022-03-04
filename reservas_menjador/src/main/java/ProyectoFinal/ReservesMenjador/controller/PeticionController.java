package ProyectoFinal.ReservesMenjador.controller;

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

import ProyectoFinal.ReservesMenjador.dto.Peticion;
import ProyectoFinal.ReservesMenjador.services.PeticionServicesImpl;

@RestController
@RequestMapping("/api") // POR DETERMINAR SU USO
public class PeticionController {

	@Autowired
	PeticionServicesImpl peticionSERV;

	@GetMapping("/peticiones")
	public List<Peticion> totalRegistros(){
		return peticionSERV.totalRegistro();
	}

	@GetMapping("/peticiones/{id}")
	public Peticion ubicaPorID(@PathVariable (name = "id") int id) {
		return peticionSERV.ubicaPorID(id);
	}

	@PostMapping("peticiones/add")
	public Peticion agregaRegistro(@RequestBody Peticion peticion) {
		return peticionSERV.agregaRegistro(peticion);
	}

	@PutMapping("peticiones/{id}/agrega")
	public Peticion actualizaRegistro(@PathVariable (name = "id") int id, @RequestBody Peticion peticion) {
		Peticion peticionSEL = new Peticion();
		Peticion peticionUPDATE = new Peticion();
		peticionSEL = peticionSERV.ubicaPorID(id);
		peticionSEL.setOrden(peticion.getOrden());
		peticionSEL.setPlato(peticion.getPlato());
		peticionUPDATE = peticionSEL;

		return peticionUPDATE;
	}

	@DeleteMapping("peticiones/{id}/delete")
	public void eliminaRegistro(@PathVariable (name = "id") int id) {
		peticionSERV.eliminaRegistroPorID(id);
	}
}
