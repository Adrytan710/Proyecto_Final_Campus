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

import ProyectoFinal.ReservesMenjador.dto.Plato;
import ProyectoFinal.ReservesMenjador.services.PlatoServicesImpl;
import net.bytebuddy.implementation.bind.ArgumentTypeResolver.ParameterIndexToken;
@RestController
@RequestMapping("/api") // POR DETERMINAR SU USO
public class PlatoController {

	@Autowired
	PlatoServicesImpl platoSERV;

	@GetMapping("/platos")
	public List<Plato> totalRegistros(){
		return platoSERV.totalRegistro();
	}

	@GetMapping("/platos/{id}")
	public Plato ubicaPorID(@PathVariable (name = "id") int id) {
		Plato plato = new Plato();
		plato = platoSERV.ubicaPorID(id);
		return plato;
	}

	@PostMapping("platos/add")
	public Plato agregaRegistro(@RequestBody Plato plato) {
		return platoSERV.agregaRegistro(plato);
	}

	@PutMapping("platos/{id}/agrega")
	public Plato actualizaRegistro(@PathVariable (name = "id") int id, @RequestBody Plato plato) {
		Plato platoSEL = new Plato();
		Plato platoUPDATE = new Plato();
		platoSEL = platoSERV.ubicaPorID(id);
		platoSEL.setNombre(plato.getNombre());
		platoSEL.setFoto(plato.getFoto());
		platoSEL.setCategoria(plato.getCategoria());
		platoSEL.setPeticions(plato.getPeticions());
		platoUPDATE = platoSEL;

		return platoUPDATE;
	}

	@DeleteMapping("platos/{id}/delete")
	public void eliminaRegistro(@PathVariable (name = "id") int id) {
		platoSERV.eliminaRegistroPorID(id);
	}
}

