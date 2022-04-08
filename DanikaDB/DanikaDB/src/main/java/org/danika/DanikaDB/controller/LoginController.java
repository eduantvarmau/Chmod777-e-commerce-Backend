package org.danika.DanikaDB.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;

import org.danika.DanikaDB.jwt.config.JwtFilter;
import org.danika.DanikaDB.model.Token;
import org.danika.DanikaDB.model.Usuario;
import org.danika.DanikaDB.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(path="/api/login/")
@CrossOrigin("+")
public class LoginController {
	private final UsuariosService usuariosService;
	@Autowired
	public LoginController(UsuariosService usuariosService) {
		this.usuariosService = usuariosService;
	}//constructor
	
	@PostMapping
	public Token login(@RequestBody Usuario usuario) throws ServletException {
		if (usuariosService.validateUsuario(usuario)) {
			return new Token(generateToken(usuario.getUsername()));
			
		}//
		
		throw new ServletException("Nombre de usuario o contraseña incorrectos.");
	}//login
	
	private String generateToken(String username) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, 10);
		return Jwts.builder().setSubject(username).claim("role", "user")
				.setIssuedAt(new Date()).setExpiration(calendar.getTime())
				.signWith(SignatureAlgorithm.HS256, JwtFilter.secret).compact();
	}// generateToken



}//class LoginController