package ProyectoFinal.ReservesMenjador.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ProyectoFinal.ReservesMenjador.dto.Usuario;
import ProyectoFinal.ReservesMenjador.dao.IUsuarioDAO;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UsuarioController {

	private IUsuarioDAO iUsuarioDAO;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UsuarioController(IUsuarioDAO iUsuarioDAO, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.iUsuarioDAO = iUsuarioDAO;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@GetMapping("/response-entity-builder-with-http-headers")
	public ResponseEntity<String> usingResponseEntityBuilderAndHttpHeaders() {
	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("Baeldung-Example-Header", "Value-ResponseEntityBuilderWithHttpHeaders");
	    return ResponseEntity.ok()
	      .headers(responseHeaders)
	      .body("Response with header using ResponseEntity");
	}
	
	@PostMapping("/usuarios/")
	public Usuario saveUsuario(@RequestBody Usuario user) {
		user.setPass_usuario(bCryptPasswordEncoder.encode(user.getPass_usuario()));
		iUsuarioDAO.save(user);
		return user;
	}

	@GetMapping("/usuarios/")
	public List<Usuario> getAllUsuarios() {
		return iUsuarioDAO.findAll();
	}

	@GetMapping("/usuarios/{usuario}")
	public Usuario getUsuario(@PathVariable String usuario) {
		return iUsuarioDAO.findByUsuario(usuario);
	}
	
	@DeleteMapping("/usuarios/{id}")
	public String eliminarUser(@PathVariable(name="id")int id) {
		iUsuarioDAO.deleteById(id);
		return "User deleted.";
	}
}
