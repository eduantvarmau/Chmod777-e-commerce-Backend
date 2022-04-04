package org.danika.DanikaDB.service;

import java.util.List;
import java.util.Optional;

import org.danika.DanikaDB.model.ChangePassword;
import org.danika.DanikaDB.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosService {

		private final UsuariosRepository
										usuariosRepository;
		@Autowired
		public UsuariosService(UsuariosRepository usuariosrepository) {
			super();
			this.usuariosRepository = usuariosrepository;
		}//constructor
		
		public List<Usuario> getUsuarios(){
			return usuariosRepository.findAll();
		}//getUsuarios
		
		public Usuario getUsuario (Long id) {
			return usuariosRepository.findById(id).orElseThrow(
					()-> new IllegalStateException("El Usuario con el id " + id + " no existe.")  );
		}//getUsuario
		
		public void deleteUsuario(Long id) {
			if (usuariosRepository.existsById(id) ) {
				usuariosRepository.deleteById(id);
			}//if exist
		}//deleteUsuario
		
		
		public void addUsuario(Usuario usuario) {
			Optional<Usuario> userByName=usuariosRepository.findByUsername(usuario.getUsername());
			if(userByName.isPresent()) {
				throw new IllegalStateException("El Usuario con el nombre [" + usuario.getUsername() + 
						"] YA existe."); 	
			} else {
				usuariosRepository.save(usuario);
			}//else 
		}//addUsuario

		public void updateUsuario(ChangePassword changePassword) {
			Optional<Usuario> userByName=usuariosRepository.findByUsername(changePassword.getUsername());
			if(userByName.isPresent()) {
				Usuario u = userByName.get();
				if(u.getPassword().equals(changePassword.getPassword())) {
					u.setPassword(changePassword.getNewPassword());
					usuariosRepository.save(u);
				}//password
			}//if isPresent
		}//updateUsuario
		
		
		
		
}//UsuariosService
