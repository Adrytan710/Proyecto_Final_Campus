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

import ProyectoFinal.ReservesMenjador.dto.Tiene_Alergia;
import ProyectoFinal.ReservesMenjador.services.Tiene_AlergiaServicesImpl;
@RestController
@RequestMapping("/api") // POR DETERMINAR SU USO
public class Tiene_AlergiaController {

	@Autowired
	Tiene_AlergiaServicesImpl tieneSERV;

	@GetMapping("/tienen")
	public List<Tiene_Alergia> totalRegistros(){
		return tieneSERV.totalRegistro();
	}

	@GetMapping("/tienen/{id}")
	public Tiene_Alergia ubicaPorID(@PathVariable (name = "id") int id) {
		Tiene_Alergia tiene = new Tiene_Alergia();
		tiene = tieneSERV.ubicaPorID(id);
		return tiene;
	}

	@PostMapping("tienen/add")
	public Tiene_Alergia agregaRegistro(@RequestBody Tiene_Alergia tiene) {
		return tieneSERV.agregaRegistro(tiene);
	}

	@PutMapping("tienen/{id}/agrega")
	public Tiene_Alergia actualizaRegistro(@PathVariable (name = "id") int id, @RequestBody Tiene_Alergia tiene) {
		Tiene_Alergia tieneSEL = new Tiene_Alergia();
		Tiene_Alergia tieneUPDATE = new Tiene_Alergia();
		tieneSEL = tieneSERV.ubicaPorID(id);
		tieneSEL.setAlergia(tiene.getAlergia());
		tieneSEL.setUsuario(tiene.getUsuario());
		tieneUPDATE = tieneSEL;

		return tieneUPDATE;
	}

	@DeleteMapping("tienen/{id}/delete")
	public void eliminaRegistro(@PathVariable (name = "id") int id) {
		tieneSERV.eliminaRegistroPorID(id);
	}
}
