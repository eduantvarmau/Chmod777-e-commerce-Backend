package com.ecommerce.Chmod777.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Chmod777.model.Producto;
import com.ecommerce.Chmod777.service.ProductosService;

@RestController
@RequestMapping (path = "/api/productos/")

public class ProductosController {
	private final ProductosService prodService;
	@Autowired
	public ProductosController(ProductosService prodService) {
		this.prodService = prodService;
	}//constructor
	
	@PostMapping 
	public Producto addProducto(@RequestBody Producto producto) {
		return prodService.addProducto(producto);
	}

}//Text to class product control
