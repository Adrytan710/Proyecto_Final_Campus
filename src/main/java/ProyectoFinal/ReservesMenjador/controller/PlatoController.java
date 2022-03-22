package ProyectoFinal.ReservesMenjador.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ProyectoFinal.ReservesMenjador.dto.Categoria;
import ProyectoFinal.ReservesMenjador.dto.Plato;
import ProyectoFinal.ReservesMenjador.services.CategoriaServicesImpl;
import ProyectoFinal.ReservesMenjador.services.PlatoServicesImpl;

@RestController
@RequestMapping("/api") // POR DETERMINAR SU USO
public class PlatoController {

	@Autowired
	PlatoServicesImpl platoSERV;

	@Autowired
	CategoriaServicesImpl categoriaSERVICES;

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
	
	@GetMapping("/platos/categoria/{id}")
	public List<Plato> buscarPorCategoria(@PathVariable (name = "id") int id){
		
		Categoria categoria = categoriaSERVICES.ubicaPorID(id);
		
		return platoSERV.buscaPorCategoria(categoria);
	}

	@PostMapping("platos/add")
	public Plato agregaRegistro(@RequestBody Plato plato) {
		return platoSERV.agregaRegistro(plato);
	}

	@PutMapping("platos/update/{id}")
	public Plato actualizaRegistro(@PathVariable (name = "id") int id, @RequestBody Plato plato) {
		
		Plato platoSEL = new Plato();
		Plato platoUPDATE = new Plato();
		
		platoSEL = platoSERV.ubicaPorID(id);
		platoSEL.setId(id);
		platoSEL.setNombre(plato.getNombre());
		platoSEL.setFoto(plato.getFoto());
		platoSEL.setCategoria(plato.getCategoria());
		platoUPDATE = platoSERV.actualizaResgistro(platoSEL);

		return platoUPDATE;
	}

	@DeleteMapping("platos/delete/{id}")
	public void eliminaRegistro(@PathVariable (name = "id") int id) {
		platoSERV.eliminaRegistroPorID(id);
	}
}

