package com.ecommerce.Chmod777.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Chmod777.model.Usuarios;
import com.ecommerce.Chmod777.service.UsuariosService;

@RestController
@RequestMapping (path = "/api/usuarios/")

public class UsuarioController {
private final UsuariosService usuariosService;

@Autowired
public UsuarioController(UsuariosService usuariosService) {
	this.usuariosService =  usuariosService;
}//constructor

@PostMapping
public Usuarios addUsuarios(@RequestBody Usuarios usuarios) {
	return usuariosService.addUsuarios(usuarios);
}//addUsuarios

@GetMapping
public ArrayList<Usuarios> getUsuarios(){
	return usuariosService.getUsuarios();
}//getUsuarios


}// class usuarioController
