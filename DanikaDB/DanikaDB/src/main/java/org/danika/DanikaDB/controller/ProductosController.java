package org.danika.DanikaDB.controller;

import java.util.List;

import org.danika.DanikaDB.model.Producto;
import org.danika.DanikaDB.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path="/api/productos/")
public class ProductosController {

	private final ProductoService prodService;
	@Autowired
	public ProductosController(ProductoService prodService) {
		this.prodService = prodService;
	} // constructor
	
	@GetMapping
	public List<Producto> getProductos() {
		return prodService.getProductos();
	} //getProductos
	
	@GetMapping (path="{prodId}")
	public Producto getProducto(@PathVariable("prodId")  Long id) {
		return prodService.getProducto(id);
	}//getProducto
	
	@DeleteMapping (path="{prodId}")
	public Producto deleteProducto(@PathVariable("prodId")  Long id) {
		Producto tmpProducto = prodService.deleteProducto(id);
		return tmpProducto;
	}//deleteProducto
	
	@PostMapping
	public Producto addProducto(@RequestBody Producto producto) {
		return prodService.addProducto(producto);
	}//addProducto
	
	@PutMapping(path="{prodId}")
	public Producto updateProducto(@PathVariable("prodId") Long id,
			@RequestParam(required = false) String nombre,
			@RequestParam(required = false) String descripcion,
			@RequestParam(required = false) String URL_imagen,
			@RequestParam(required = false) Double precio,
			@RequestParam(required = false) String categoria) {
		return prodService.updateProducto(id, nombre, descripcion, URL_imagen, precio, categoria);
	}//updateProducto
	
	
}//class ProductosController
