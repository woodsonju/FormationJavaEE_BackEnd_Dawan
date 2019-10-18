package fr.dawan.cart.bean;

import java.io.Serializable;
import java.util.Date;


public class Library implements Serializable {

    /**
     * Dans PHPMyAdmin : exécuter le SQL.
     CREATE TABLE livre(
     id          Int  NOT NULL ,
     titre       Varchar (255) ,
     auteur      Varchar (70) ,
     langue      Varchar (25) ,
     isbn        Varchar (55) ,
     anneeSortie Varchar (50) ,
     image       Varchar (255) ,
     */
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

    }

    public boolean isStar() {
        return star;
    }

    public void setStar(boolean star) {
        this.star = star;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getDomaine() {
        return domaine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Library library = (Library) o;

        if (id != library.id) return false;
        if (disponible != library.disponible) return false;
        if (Double.compare(library.prix, prix) != 0) return false;
        if (star != library.star) return false;
        if (titre != null ? !titre.equals(library.titre) : library.titre != null) return false;
        if (auteur != null ? !auteur.equals(library.auteur) : library.auteur != null) return false;
        if (langue != null ? !langue.equals(library.langue) : library.langue != null) return false;
        if (isbn != null ? !isbn.equals(library.isbn) : library.isbn != null) return false;
        if (image != null ? !image.equals(library.image) : library.image != null) return false;
        if (dateAchat != null ? !dateAchat.equals(library.dateAchat) : library.dateAchat != null) return false;
        if (anneeSortie != null ? !anneeSortie.equals(library.anneeSortie) : library.anneeSortie != null) return false;
        if (domaine != null ? !domaine.equals(library.domaine) : library.domaine != null) return false;
        if (synopsis != null ? !synopsis.equals(library.synopsis) : library.synopsis != null) return false;
        return description != null ? description.equals(library.description) : library.description == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (titre != null ? titre.hashCode() : 0);
        result = 31 * result + (auteur != null ? auteur.hashCode() : 0);
        result = 31 * result + (langue != null ? langue.hashCode() : 0);
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (dateAchat != null ? dateAchat.hashCode() : 0);
        result = 31 * result + (anneeSortie != null ? anneeSortie.hashCode() : 0);
        result = 31 * result + (domaine != null ? domaine.hashCode() : 0);
        result = 31 * result + (synopsis != null ? synopsis.hashCode() : 0);
        result = 31 * result + (disponible ? 1 : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        temp = Double.doubleToLongBits(prix);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (star ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", langue='" + langue + '\'' +
                ", isbn='" + isbn + '\'' +
                ", image='" + image + '\'' +
                ", dateAchat=" + dateAchat +
                ", anneeSortie='" + anneeSortie + '\'' +
                ", domaine='" + domaine + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", disponible=" + disponible +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                ", star=" + star +
                '}';
    }
}
