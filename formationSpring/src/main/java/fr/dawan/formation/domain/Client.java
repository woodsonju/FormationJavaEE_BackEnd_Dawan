package fr.dawan.formation.domain;

import java.util.List;
import java.util.Set;

public class Client extends Contact{
	
	private String numero;
	private Adresse adresse;  
	private List<String> favorites;
	private Set<String> numbers;

	public Client() {
		super();

	}

	public Client(String numero) {
		super();
		this.numero = numero;
	}

	public Client(String numero, Adresse adresse) {
		super();
		this.numero = numero;
		this.adresse = adresse;
	}


	public Client(String numero, Adresse adresse, List<String> favorites) {
		super();
		this.numero = numero;
		this.adresse = adresse;
		this.favorites = favorites;
	}
	
	

	public Client(String numero, Adresse adresse, List<String> favorites, Set<String> numbers) {
		super();
		this.numero = numero;
		this.adresse = adresse;
		this.favorites = favorites;
		this.numbers = numbers;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<String> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<String> favorites) {
		this.favorites = favorites;
	}

	public Set<String> getNumbers() {
		return numbers;
	}

	public void setNumbers(Set<String> numbers) {
		this.numbers = numbers;
	}
	
}
