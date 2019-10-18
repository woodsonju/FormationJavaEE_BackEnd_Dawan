package fr.dawan.cart.validator;

import fr.dawan.cart.bean.Library;

public class BookValidator {
	 public static String newBookValidator(Library library){
	        String message = "";
	        System.out.println("library.getPrix = " + library.getPrix() + ", library.gettitre : " + library.getTitre());
	        if(library.getPrix() == 0)
	            message += "prix";
	        if(library.getTitre().isEmpty())
	            message += "titre";
	        if(library.getAuteur().isEmpty())
	            message+="auteur";
	        if(!library.isDisponible())
	            message+="disponible";
	        return message;
	    }
	}
