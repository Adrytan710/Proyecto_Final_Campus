package ProyectoFinal.ReservesMenjador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ProyectoFinal.ReservesMenjador.dto.Plato;
import ProyectoFinal.ReservesMenjador.dto.Produce_Alergia;
import ProyectoFinal.ReservesMenjador.services.PlatoServicesImpl;
import ProyectoFinal.ReservesMenjador.services.Produce_AlergiaServicesImpl;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", methods= {RequestMethod.OPTIONS,RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api") // POR DETERMINAR SU USO
public class Produce_AlergiaController {

	@Autowired
	Produce_AlergiaServicesImpl produceSERV;

	@Autowired
	PlatoServicesImpl platoSERV;

	@GetMapping("/producen")
	public List<Produce_Alergia> totalRegistros(){
		return produceSERV.totalRegistro();
	}

	@GetMapping("/producen/{id}")
	public Produce_Alergia ubicaPorID(@PathVariable (name = "id") int id) {
		Produce_Alergia  alergy = new Produce_Alergia();
		alergy = produceSERV.ubicaPorID(id);
		return alergy;
	}

	@GetMapping("/producen/plato/{id}")
	public List<Produce_Alergia> buscarPorPlato(@PathVariable (name = "id") int id) {
		
		Plato plato = platoSERV.ubicaPorID(id);
		
		return produceSERV.buscaPorPlato(plato);
	}

	@PostMapping("producen/add")
	public Produce_Alergia agregaRegistro(@RequestBody Produce_Alergia produce) {
		return produceSERV.agregaRegistro(produce);
	}

	@PutMapping("producen/update/{id}")
	public Produce_Alergia actualizaRegistro(@PathVariable (name = "id") int id, @RequestBody Produce_Alergia produce) {
		
		Produce_Alergia produceSEL = new Produce_Alergia();
		Produce_Alergia produceUPDATE = new Produce_Alergia();
		
		produceSEL = produceSERV.ubicaPorID(id);
		produceSEL.setAlergia(produce.getAlergia());
		produceSEL.setPlato(produce.getPlato());
		produceUPDATE = produceSERV.actualizaResgistro(produceSEL);

		return produceUPDATE;
	}

	@DeleteMapping("producen/delete/{id}")
	public void eliminaRegistro(@PathVariable (name = "id") int id) {
		produceSERV.eliminaRegistroPorID(id);
	}
}
