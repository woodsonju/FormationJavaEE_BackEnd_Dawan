package fr.dawan.formation.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Adresse {
	
	@Id
	private int number;
	private String street;
	private String zip;
	private String city;
	
	public Adresse() {
		super();
	
	}
	
	public Adresse(int number, String street, String zip, String city) {
		super();
		this.number = number;
		this.street = street;
		this.zip = zip;
		this.city = city;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Adresse [number=" + number + ", street=" + street + ", zip=" + zip + ", city=" + city + "]";
	}
	
}
