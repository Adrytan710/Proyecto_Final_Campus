package com.example.demo.controller;

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

import com.example.demo.dto.Usuario;
import com.example.demo.services.UsuarioServicesImpl;

@RestController
@RequestMapping("/api") // POR DETERMINAR SU USO
public class UsuarioController {

								@Autowired
								UsuarioServicesImpl usuarioSERV;
								
									@GetMapping("/usuarios")
									public List<Usuario> totalRegistros(){
										return usuarioSERV.totalRegistro();
									}
									
									@GetMapping("/usuarios/{id}")
									public Usuario ubicaPorID(@PathVariable (name = "id") int id) {
										return usuarioSERV.ubicaPorID(id);
									}
									
									@PostMapping("usuarios/add")
									public Usuario agregaRegistro(@RequestBody Usuario usuario) {
										return usuarioSERV.agregaRegistro(usuario);
									}
									
									@PutMapping("usuarios/{id}/agrega")
									public Usuario actualizaRegistro(@PathVariable (name = "id") int id, @RequestBody Usuario usuario) {
										Usuario usuarioSEL = new Usuario();
										Usuario usuarioUPDATE = new Usuario();
										usuarioSEL = usuarioSERV.ubicaPorID(id);
										usuarioSEL.setUsuario(usuario.getUsuario());
										usuarioSEL.setPass_usuario(usuario.getPass_usuario());
										usuarioSEL.setEmail(usuario.getEmail());
										usuarioSEL.setRol(usuario.getRol());
										usuarioSEL.setOrdenes(usuario.getOrdenes());
										usuarioSEL.setAlergias(usuario.getAlergias());
										usuarioUPDATE = usuarioSEL;
										
										return usuarioUPDATE;
									}
									
									@DeleteMapping("usuarios/{id}/delete")
									public void eliminaRegistro(@PathVariable (name = "id") int id) {
										usuarioSERV.eliminaRegistroPorID(id);
									}
}
