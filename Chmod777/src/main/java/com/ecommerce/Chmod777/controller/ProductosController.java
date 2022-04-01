package com.ecommerce.Chmod777.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Chmod777.model.Producto;
import com.ecommerce.Chmod777.service.ProductosService;

@RestController
@RequestMapping (path = "/api/productos/")

public class ProductosController {
	private final ProductosService productosService;
	@Autowired
	public ProductosController(ProductosService prodService) {
		this.productosService = prodService;
	}//constructor
	
	@PostMapping 
	public Producto addProducto(@RequestBody Producto producto) {
		return productosService.addProducto(producto);
	}
	
	@GetMapping
	public ArrayList<Producto> getProductos() {
	
		return productosService.getProductos();	
	}//getProductos
	
	@GetMapping(path="{prodId}")
    public Producto getProducto(@PathVariable("prodId") Long prodId) {
        return productosService.getProducto(prodId);
    }//getProducto
	
	@DeleteMapping(path="{prodId}")
    public Producto deleteProducto(@PathVariable("prodId") Long prodId) {
        return productosService.deleteProducto(prodId);
    }//deleteproducto
	
	
	
}//Text to class product control
