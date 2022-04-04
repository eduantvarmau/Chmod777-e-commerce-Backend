package org.danika.DanikaDB.model;

public class ChangePassword {

	private String username;
	private String password;
	private String newPassword;
	
	public ChangePassword(String username, String password, String newPassword) {
		super();
		this.username = username;
		this.password = password;
		this.newPassword = newPassword;
	}//constructor
	
	public ChangePassword() {
	}

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
	}//setPassword

	public String getNewPassword() {
		return newPassword;
	}//getNewPassword

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}//setNewPassword

	@Override
	public String toString() {
		return "ChangePassword [username=" + username + ", password=" + password + ", newPassword=" + newPassword + "]";
	}//String

	
	
	
}//class ChangePassword
