package org.danika.DanikaDB.service;

import java.util.List;
import java.util.Optional;

import org.danika.DanikaDB.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

	private final ProductosRepository productosRepository;
	
	@Autowired
	public ProductoService(ProductosRepository productosRepository) {
		this.productosRepository = productosRepository;
	}//constructor

	public List<Producto> getProductos(){
		return productosRepository.findAll(); 
	}//getProductos
	
	public Producto getProducto(Long id) {
		return productosRepository.findById(id).orElseThrow(
				()-> new IllegalStateException("El Producto con el id " + id + " no existe.")  );
	}//getProducto

	public Producto deleteProducto(Long id) {
		Producto tmpProducto = null;
		if (productosRepository.existsById(id) ) {
			tmpProducto = productosRepository.findById(id).get();
			productosRepository.deleteById(id);
		}//exist
		return tmpProducto;
	}//deleteProducto

	public Producto addProducto(Producto producto) {
		Producto tmpProducto = null;
		Optional<Producto> prodByName=productosRepository.findByNombre(producto.getNombre());
		if(prodByName.isPresent()) {
			throw new IllegalStateException("El Producto con el nombre [" + producto.getNombre() + 
					"] YA existe."); 	
		} else {
			productosRepository.save(producto);
			tmpProducto = producto;
		}//else 
		return tmpProducto;
	}//addProducto

	public Producto updateProducto(Long id, String nombre, String descripcion, String URL_imagen, Double precio, String categoria) {
	
		Producto tmpProducto = null;
		if (productosRepository.existsById(id)) {
			tmpProducto = productosRepository.findById(id).get();
			if(nombre!=null)tmpProducto.setNombre(nombre);
			if(descripcion!=null) tmpProducto.setDescripcion(descripcion);
			if(URL_imagen!=null) tmpProducto.setURL_imagen(URL_imagen);
			if(precio!=null && precio.doubleValue()>0) tmpProducto.setPrecio(precio);
			if(categoria!=null) tmpProducto.setCategoria(categoria);
			productosRepository.save(tmpProducto);
		}else {
			System.out.println("No existe el producto con el id " + id);
		}//else //if
		
		return tmpProducto;
	}//updateProduct
	
	
	
	
}//class ProductoService
