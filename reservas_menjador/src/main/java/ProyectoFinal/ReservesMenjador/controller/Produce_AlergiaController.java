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

import ProyectoFinal.ReservesMenjador.dto.Produce_Alergia;
import ProyectoFinal.ReservesMenjador.services.Produce_AlergiaServicesImpl;

@RestController
@RequestMapping("/api") // POR DETERMINAR SU USO
public class Produce_AlergiaController {

	@Autowired
	Produce_AlergiaServicesImpl produceSERV;

	@GetMapping("/producen")
	public List<Produce_Alergia> totalRegistros(){
		return produceSERV.totalRegistro();
	}

	@GetMapping("/producen/{id}")
	public Produce_Alergia ubicaPorID(@PathVariable (name = "id") int id) {
		return produceSERV.ubicaPorID(id);
	}

	@PostMapping("producen/add")
	public Produce_Alergia agregaRegistro(@RequestBody Produce_Alergia produce) {
		return produceSERV.agregaRegistro(produce);
	}

	@PutMapping("producen/{id}/agrega")
	public Produce_Alergia actualizaRegistro(@PathVariable (name = "id") int id, @RequestBody Produce_Alergia produce) {
		Produce_Alergia produceSEL = new Produce_Alergia();
		Produce_Alergia produceUPDATE = new Produce_Alergia();
		produceSEL = produceSERV.ubicaPorID(id);
		produceSEL.setAlergia(produce.getAlergia());
		produceSEL.setPlato(produce.getPlato());
		produceUPDATE = produceSEL;

		return produceUPDATE;
	}

	@DeleteMapping("producen/{id}/delete")
	public void eliminaRegistro(@PathVariable (name = "id") int id) {
		produceSERV.eliminaRegistroPorID(id);
	}
}
