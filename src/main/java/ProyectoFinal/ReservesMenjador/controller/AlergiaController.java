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

import ProyectoFinal.ReservesMenjador.dto.Alergia;
import ProyectoFinal.ReservesMenjador.services.AlergiaServicesImpl;

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
		Alergia alergy = new Alergia();
		alergy = alergySERV.ubicaPorID(id);
		return alergy;
	}

	@PostMapping("alergias/add")
	public Alergia agregaRegistro(@RequestBody Alergia alergy) {
		return alergySERV.agregaRegistro(alergy);
	}

	@PutMapping("alergias/update/{id}")
	public Alergia actualizaRegistro(@PathVariable (name = "id") int id, @RequestBody Alergia alergy) {
		
		Alergia alergySEL = new Alergia();
		Alergia alergyUPDATE = new Alergia();
		
		alergySEL = alergySERV.ubicaPorID(id);
		alergySEL.setId(id);
		alergySEL.setNombre(alergy.getNombre());
		
		alergyUPDATE = alergySERV.actualizaResgistro(alergySEL);

		return alergyUPDATE;
	}

	@DeleteMapping("alergias/delete/{id}")
	public void eliminaRegistro(@PathVariable (name = "id") int id) {
		alergySERV.eliminaRegistroPorID(id);
	}
}
