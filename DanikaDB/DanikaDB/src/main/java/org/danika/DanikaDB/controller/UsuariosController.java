package org.danika.DanikaDB.controller;

import java.util.List;

import org.danika.DanikaDB.model.ChangePassword;
import org.danika.DanikaDB.model.Usuario;
import org.danika.DanikaDB.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path="/api/usuarios/")
public class UsuariosController {
	private final UsuariosService usuariosService;
		@Autowired
		public UsuariosController(UsuariosService usuariosService) {
			this.usuariosService = usuariosService;
		}//constructor
		
	
		@GetMapping
		public List<Usuario> getUsuarios(){
			return usuariosService.getUsuarios();
		}//getUsuarios
		
		@GetMapping (path="{prodId}")
		public Usuario getUsuario(@PathVariable("prodId") Long id){
			return usuariosService.getUsuario(id);
		}//getUsuario
		
		@DeleteMapping (path="{prodId}")
		public void deleteProducto(@PathVariable("prodId")  Long id) {
			usuariosService.deleteUsuario(id);
		}//deleteUsuario
		
		@PostMapping
		public void  addUsuario(@RequestBody Usuario usuario) {
			usuariosService.addUsuario(usuario);
		}//addUsuario
		
		@PutMapping 
		public void updateUsuario(@RequestBody ChangePassword changePassword) {
			usuariosService.updateUsuario(changePassword);
		}//updateUsuario

		
}//class UsuariosController
