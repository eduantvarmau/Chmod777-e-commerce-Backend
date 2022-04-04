package org.danika.DanikaDB.service;

import java.util.Optional;

import org.danika.DanikaDB.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductosRepository extends JpaRepository<Producto, Long>{
	@Query("SELECT p FROM Producto p WHERE p.nombre=?1")
	Optional<Producto> findByNombre (String nombre);

}//interface ProductosRepository
