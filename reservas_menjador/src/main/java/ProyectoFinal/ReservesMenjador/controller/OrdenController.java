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

import ProyectoFinal.ReservesMenjador.dto.Orden;
import ProyectoFinal.ReservesMenjador.services.OrdenServicesImpl;

@RestController
@RequestMapping("/api") // POR DETERMINAR SU USO
public class OrdenController {

	@Autowired
	OrdenServicesImpl ordenSERV;

	@GetMapping("/ordenes")
	public List<Orden> totalRegistros(){
		return ordenSERV.totalRegistro();
	}

	@GetMapping("/ordenes/{id}")
	public Orden ubicaPorID(@PathVariable (name = "id") int id) {
		return ordenSERV.ubicaPorID(id);
	}

	@PostMapping("ordenes/add")
	public Orden agregaRegistro(@RequestBody Orden orden) {
		return ordenSERV.agregaRegistro(orden);
	}

	@PutMapping("ordenes/{id}/agrega")
	public Orden actualizaRegistro(@PathVariable (name = "id") int id, @RequestBody Orden orden) {
		Orden ordenSEL = new Orden();
		Orden ordenUPDATE = new Orden();
		ordenSEL = ordenSERV.ubicaPorID(id);
		ordenSEL.setFecha(orden.getFecha());
		ordenSEL.setPeticion(orden.getPeticion());
		ordenSEL.setUsuario(orden.getUsuario());
		ordenUPDATE = ordenSEL;

		return ordenUPDATE;
	}

	@DeleteMapping("ordenes/{id}/delete")
	public void eliminaRegistro(@PathVariable (name = "id") int id) {
		ordenSERV.eliminaRegistroPorID(id);
	}
}
