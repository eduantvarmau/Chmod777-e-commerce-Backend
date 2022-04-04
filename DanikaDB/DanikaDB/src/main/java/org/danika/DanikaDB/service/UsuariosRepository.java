package org.danika.DanikaDB.service;

import java.util.Optional;

import org.danika.DanikaDB.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuariosRepository 
	
	extends JpaRepository<Usuario, Long>{
		@Query("SELECT u FROM Usuario u WHERE u.username=?1")
		Optional<Usuario> findByUsername (String username);
}//interface UsuariosRepository {
