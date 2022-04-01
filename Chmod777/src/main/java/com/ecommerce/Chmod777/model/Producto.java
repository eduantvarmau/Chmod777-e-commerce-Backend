package com.ecommerce.Chmod777.model;

public class Producto {

	private String name;
	private double price;
	private String thumbnail;
	private String descriptions;
	private String category;
	private int id;
	private static int total = 0;
	
	
	public Producto(String name, double price, String thumbnail, String descriptions, String category) {
		super();
		this.name = name;
		this.price = price;
		this.thumbnail = thumbnail;
		this.descriptions = descriptions;
		this.category = category;
		total++;
		this.id = total;
	}// Constructor producto
	
	public Producto() {
		total++;
		this.id = total;
	}


	public String getName() {
		return name;
	}//Get name

	public void setName(String name) {
		this.name = name;
	}//Set name

	public double getPrice() {
		return price;
	}//Get price

	public void setPrice(double price) {
		this.price = price;
	}//Set Price

	public String getThumbnail() {
		return thumbnail;
	}//Get Thumbnail

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}//Set Thumbnail

	public String getDescriptions() {
		return descriptions;
	}//Get descriptions

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}//Set descriptions

	public String getCategory() {
		return category;
	}//Get category

	public void setCategory(String category) {
		this.category = category;
	}//Set category
	
	public int getId () {
		return id;
	}

	@Override
	public String toString() {
		return "Producto [name=" + name + ", price=" + price + ", thumbnail=" + thumbnail
				+ ", descriptions=" + descriptions + ", category=" + category + "]";
	}//String
	
	

}//Class
