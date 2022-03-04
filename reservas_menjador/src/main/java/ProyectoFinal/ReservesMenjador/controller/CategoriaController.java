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

import ProyectoFinal.ReservesMenjador.dto.Categoria;
import ProyectoFinal.ReservesMenjador.services.CategoriaServicesImpl;


@RestController
@RequestMapping("/api") // POR DETERMINAR SU USO
public class CategoriaController {

	@Autowired
	CategoriaServicesImpl categoriaSERVICES;

	@GetMapping("/categorias")
	public List<Categoria> totalRegistros(){
		return categoriaSERVICES.totalRegistro();
	}

	@GetMapping("/categorias/{id}")
	public Categoria ubicaPorID(@PathVariable (name = "id") int id) {
		return categoriaSERVICES.ubicaPorID(id);
	}

	@PostMapping("categorias/add")
	public Categoria agregaRegistro(@RequestBody Categoria categoria) {
		return categoriaSERVICES.agregaRegistro(categoria);
	}

	@PutMapping("categorias/{id}/agrega")
	public Categoria actualizaRegistro(@PathVariable (name = "id") int id, @RequestBody Categoria categoria) {
		Categoria categoriaSEL = new Categoria();
		Categoria categoriaUPDATE = new Categoria();
		categoriaSEL = categoriaSERVICES.ubicaPorID(id);
		categoriaSEL.setNombre(categoria.getNombre());
		categoriaSEL.setPlatos(categoria.getPlatos());
		categoriaUPDATE = categoriaSEL;

		return categoriaUPDATE;
	}

	@DeleteMapping("categorias/{id}/delete")
	public void eliminaRegistro(@PathVariable (name = "id") int id) {
		categoriaSERVICES.eliminaRegistroPorID(id);
	}
}
