package fr.dawan.projet1.entities;

import java.io.Serializable;

public class Product implements Serializable {
	
	private String description;
	private float price;
	
	
	public Product() {
		super();
	}
	
	public Product(String description, float price) {
		super();
		this.description = description;
		this.price = price;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

}
