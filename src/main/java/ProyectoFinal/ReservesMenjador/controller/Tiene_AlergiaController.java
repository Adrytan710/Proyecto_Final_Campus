package ProyectoFinal.ReservesMenjador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ProyectoFinal.ReservesMenjador.dto.*;
import ProyectoFinal.ReservesMenjador.services.*;

@RestController
@RequestMapping("/api") // POR DETERMINAR SU USO
public class Tiene_AlergiaController {

	@Autowired
	Tiene_AlergiaServicesImpl tieneSERV;

	@Autowired
	AlergiaServicesImpl alergySERV;

	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;

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

	@GetMapping("/tienen/usuario/{usuario}")
	public List<Tiene_Alergia> buscarPorUsuario(@PathVariable (name = "usuario") String usuario) {
		
		Usuario usuarioSel = usuarioServiceImpl.buscaPorUsuario(usuario);
		
		return tieneSERV.buscaPorUsuario(usuarioSel);
	}

	@GetMapping("/tienen/alergia/{id}")
	public List<Tiene_Alergia> buscarPorAlergia(@PathVariable (name = "id") int id) {

		Alergia alergia = alergySERV.ubicaPorID(id);
		
		return tieneSERV.buscaPorAlergia(alergia);
	}

	@PostMapping("tienen/add")
	public Tiene_Alergia agregaRegistro(@RequestBody Tiene_Alergia tiene) {
		return tieneSERV.agregaRegistro(tiene);
	}

	@PutMapping("tienen/update/{id}")
	public Tiene_Alergia actualizaRegistro(@PathVariable (name = "id") int id, @RequestBody Tiene_Alergia tiene) {
		
		Tiene_Alergia tieneSEL = new Tiene_Alergia();
		Tiene_Alergia tieneUPDATE = new Tiene_Alergia();
		
		tieneSEL = tieneSERV.ubicaPorID(id);
		tieneSEL.setId(id);
		tieneSEL.setAlergia(tiene.getAlergia());
		tieneSEL.setUsuario(tiene.getUsuario());
		tieneUPDATE = tieneSERV.actualizaResgistro(tieneSEL);

		return tieneUPDATE;
	}

	@DeleteMapping("tienen/delete/{id}")
	public void eliminaRegistro(@PathVariable (name = "id") int id) {
		tieneSERV.eliminaRegistroPorID(id);
	}
}
