package org.danika.DanikaDB.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name="id", unique=true, nullable=false)
	private Long id;
	private String username;
	private String lastname;
	private String password;
	private String email;
	private String cellphone;
	private String state;
	private String role;
	

	public Usuario(Long id, String username, String lastname, String password, String email, String cellphone,
			String state, String role) {
		super();
		this.id = id;
		this.username = username;
		this.lastname = lastname;
		this.password = password;
		this.email = email;
		this.cellphone = cellphone;
		this.state = state;
		this.role = role;
	}//constructor


	public Usuario() {} //constructor vacio


	public Long getId() {
		return id;
	}//getId

	public void setId(Long id) {
		this.id = id;
	}//setId

	public String getUsername() {
		return username;
	}//getUsername

	public void setUsername(String username) {
		this.username = username;
	}//setUsername

	public String getPassword() {
		return password;
	}//getPassword

	public void setPassword(String password) {
		this.password = password;
	}//setUsername

	public String getLastname() {
		return lastname;
	}//getLastname

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}//setLastname

	public String getEmail() {
		return email;
	}//getEmail

	public void setEmail(String email) {
		this.email = email;
	}//setEmail

	public String getRole() {
		return role;
	}//getRole

	public void setRole(String role) {
		this.role = role;
	}//setRole

	public String getCellphone() {
		return cellphone;
	}//getCellphone

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}//setCellphone

	public String getState() {
		return state;
	}//getState

	public void setState(String state) {
		this.state = state;
	}//setState

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", password=" + password + ", lastname=" + lastname
				+ ", email=" + email + ", role=" + role + ", cellphone=" + cellphone + ", state=" + state + "]";
	}//to String

	
	
	
}//class Usuario