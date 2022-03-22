package ProyectoFinal.ReservesMenjador.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ProyectoFinal.ReservesMenjador.dto.*;
import ProyectoFinal.ReservesMenjador.services.*;

@RestController
@RequestMapping("/api") // POR DETERMINAR SU USO
public class PeticionController {

	@Autowired
	PeticionServicesImpl peticionSERV;

	@Autowired
	PlatoServicesImpl platoSERV;

	@Autowired
	OrdenServicesImpl ordenSERV;

	@GetMapping("/peticiones")
	public List<Peticion> totalRegistros(){
		return peticionSERV.totalRegistro();
	}

	@GetMapping("/peticiones/{id}")
	public Peticion ubicaPorID(@PathVariable (name = "id") int id) {
		Peticion peticion = new Peticion();
		peticion = peticionSERV.ubicaPorID(id);
		return peticion;
	}
	
	@GetMapping("/peticiones/plato/{id}")
	public List<Peticion> buscarPorPlato(@PathVariable (name = "id") int id){
		
		Plato plato = platoSERV.ubicaPorID(id);
		
		return peticionSERV.buscaPorPlato(plato);
	}
	
	@GetMapping("/peticiones/orden/{id}")
	public List<Peticion> buscarPorOrden(@PathVariable (name = "id") int id){
		
		Orden orden = ordenSERV.ubicaPorID(id);
		
		return peticionSERV.buscaPorOrden(orden);
	}

	@PostMapping("peticiones/add")
	public Peticion agregaRegistro(@RequestBody Peticion peticion) {
		return peticionSERV.agregaRegistro(peticion);
	}

	@PutMapping("peticiones/update/{id}")
	public Peticion actualizaRegistro(@PathVariable (name = "id") int id, @RequestBody Peticion peticion) {
		
		Peticion peticionSEL = new Peticion();
		Peticion peticionUPDATE = new Peticion();
		
		peticionSEL = peticionSERV.ubicaPorID(id);
		peticionSEL.setId(id);
		peticionSEL.setOrden(peticion.getOrden());
		peticionSEL.setPlato(peticion.getPlato());
		peticionUPDATE = peticionSERV.actualizaResgistro(peticionSEL);

		return peticionUPDATE;
	}

	@DeleteMapping("peticiones/delete/{id}")
	public void eliminaRegistro(@PathVariable (name = "id") int id) {
		peticionSERV.eliminaRegistroPorID(id);
	}
}
