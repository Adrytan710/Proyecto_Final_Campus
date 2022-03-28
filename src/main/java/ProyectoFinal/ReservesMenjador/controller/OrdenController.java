package ProyectoFinal.ReservesMenjador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ProyectoFinal.ReservesMenjador.dto.Orden;
import ProyectoFinal.ReservesMenjador.dto.Usuario;
import ProyectoFinal.ReservesMenjador.services.OrdenServicesImpl;
import ProyectoFinal.ReservesMenjador.services.UsuarioServiceImpl;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", methods= {RequestMethod.OPTIONS,RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api") // POR DETERMINAR SU USO
public class OrdenController {

	@Autowired
	OrdenServicesImpl ordenSERV;

	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;

	@GetMapping("/ordenes")
	public List<Orden> totalRegistros(){
		return ordenSERV.totalRegistro();
	}

	@GetMapping("/ordenes/{id}")
	public Orden ubicaPorID(@PathVariable (name = "id") int id) {
		Orden orden = new Orden();
		orden = ordenSERV.ubicaPorID(id);
		return orden;
	}

	@GetMapping("/ordenes/usuario/{usuario}")
	public List<Orden> buscarPorUsuario(@PathVariable (name = "usuario") String usuario) {
		
		Usuario usuarioSel = usuarioServiceImpl.buscaPorUsuario(usuario);
		
		return ordenSERV.buscaPorUsuario(usuarioSel);
	}

	@PostMapping("ordenes/add")
	public Orden agregaRegistro(@RequestBody Orden orden) {
		return ordenSERV.agregaRegistro(orden);
	}

	@PutMapping("ordenes/update/{id}")
	public Orden actualizaRegistro(@PathVariable (name = "id") int id, @RequestBody Orden orden) {
		
		Orden ordenSEL = new Orden();
		Orden ordenUPDATE = new Orden();
		
		ordenSEL = ordenSERV.ubicaPorID(id);
		ordenSEL.setId(id);
		ordenSEL.setFecha(orden.getFecha());
		ordenSEL.setUsuario(orden.getUsuario());
		ordenUPDATE = ordenSERV.actualizaResgistro(ordenSEL);

		return ordenUPDATE;
	}

	@DeleteMapping("ordenes/delete/{id}")
	public void eliminaRegistro(@PathVariable (name = "id") int id) {
		ordenSERV.eliminaRegistroPorID(id);
	}
}
