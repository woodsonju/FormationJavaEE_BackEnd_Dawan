package fr.dawan.cart.bean;

import java.util.Date;

public class Library {
	private int id;
    private String titre;
    private String auteur;
    private String langue;
    private String isbn;
    private String image;
    private Date dateAchat;
    private String anneeSortie;
    private String domaine;
    private String synopsis;
    private boolean disponible;
    private String description;
    private double prix;
    private boolean star;
    
	public Library() {
		super();
	
	}
    
	public Library(String titre, String auteur, String langue, String isbn, String image, Date dateAchat,
			String anneeSortie, String domaine, String synopsis, boolean disponible, String description, double prix,
			boolean star) {
		super();
		this.titre = titre;
		this.auteur = auteur;
		this.langue = langue;
		this.isbn = isbn;
		this.image = image;
		this.dateAchat = dateAchat;
		this.anneeSortie = anneeSortie;
		this.domaine = domaine;
		this.synopsis = synopsis;
		this.disponible = disponible;
		this.description = description;
		this.prix = prix;
		this.star = star;
	}
	
	public Library(int id, String titre, String auteur, String langue, String isbn, String image, Date dateAchat,
			String anneeSortie, String domaine, String synopsis, boolean disponible, String description, double prix,
			boolean star) {
		super();
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
		this.langue = langue;
		this.isbn = isbn;
		this.image = image;
		this.dateAchat = dateAchat;
		this.anneeSortie = anneeSortie;
		this.domaine = domaine;
		this.synopsis = synopsis;
		this.disponible = disponible;
		this.description = description;
		this.prix = prix;
		this.star = star;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}

	public String getAnneeSortie() {
		return anneeSortie;
	}

	public void setAnneeSortie(String anneeSortie) {
		this.anneeSortie = anneeSortie;
	}

	public String getDomaine() {
		return domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public boolean isStar() {
		return star;
	}

	public void setStar(boolean star) {
		this.star = star;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anneeSortie == null) ? 0 : anneeSortie.hashCode());
		result = prime * result + ((auteur == null) ? 0 : auteur.hashCode());
		result = prime * result + ((dateAchat == null) ? 0 : dateAchat.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (disponible ? 1231 : 1237);
		result = prime * result + ((domaine == null) ? 0 : domaine.hashCode());
		result = prime * result + id;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((langue == null) ? 0 : langue.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prix);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (star ? 1231 : 1237);
		result = prime * result + ((synopsis == null) ? 0 : synopsis.hashCode());
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Library other = (Library) obj;
		if (anneeSortie == null) {
			if (other.anneeSortie != null)
				return false;
		} else if (!anneeSortie.equals(other.anneeSortie))
			return false;
		if (auteur == null) {
			if (other.auteur != null)
				return false;
		} else if (!auteur.equals(other.auteur))
			return false;
		if (dateAchat == null) {
			if (other.dateAchat != null)
				return false;
		} else if (!dateAchat.equals(other.dateAchat))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (disponible != other.disponible)
			return false;
		if (domaine == null) {
			if (other.domaine != null)
				return false;
		} else if (!domaine.equals(other.domaine))
			return false;
		if (id != other.id)
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (langue == null) {
			if (other.langue != null)
				return false;
		} else if (!langue.equals(other.langue))
			return false;
		if (Double.doubleToLongBits(prix) != Double.doubleToLongBits(other.prix))
			return false;
		if (star != other.star)
			return false;
		if (synopsis == null) {
			if (other.synopsis != null)
				return false;
		} else if (!synopsis.equals(other.synopsis))
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		return true;
	}
    
    
}
