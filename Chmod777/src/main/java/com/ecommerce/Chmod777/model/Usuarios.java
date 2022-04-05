package com.ecommerce.Chmod777.model;

public class Usuarios {

	private String nombre;
	private String apellido;
	private String telefono;
	private String estado;
	private String correo;
	private String contraseña;
	private int id;
	private static int total = 0;
	
	public Usuarios(String nombre, String apellido, String telefono, String estado, String correo, String contraseña) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.estado = estado;
		this.correo = correo;
		this.contraseña = contraseña;
		total++;
		this.id= total;
		}//constructor
	
	
	public Usuarios(){
		
		total++;
		this.id = total;
	}
	


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getCorreo() {
		return correo;
	}// get and set
	
	

	@Override
	public String toString() {
		return "Usuarios [nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", estado=" + estado
				+ ", correo=" + correo + ", contraseña=" + contraseña + "]";
	}//ToString
	
}// class Usuarios
