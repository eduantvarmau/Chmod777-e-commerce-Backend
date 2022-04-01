package com.ecommerce.Chmod777.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.ecommerce.Chmod777.model.Usuarios;
@Service
public class UsuariosService {

	public final ArrayList<Usuarios> lista = new ArrayList<Usuarios>();
	public UsuariosService() {
		
		lista.add(new Usuarios("Brenda","Valdez","5552528975","EdoMex", "nenemy@gmail.com","Password"));
		lista.add(new Usuarios("Alice","Castro","5552473483","EdoMex", "alice@gmail.com","Password"));
	}//Array UsuariosService
	
	public Usuarios addUsuarios(Usuarios usuarios) {
		lista.add(usuarios);
		return usuarios;
	}//addUsuario
	
	public ArrayList<Usuarios> getUsuarios(){
		return lista;
	}
}//class UsuariosService
