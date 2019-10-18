package fr.dawan.cart.tool;

public class StringFunctions {

	 /**
     * Met le premier caractère en majuscule
     * @param string
     * La chaîne d'entrée
     * @return
     * Retourne la chaîne string après avoir remplacé le premier caractère par sa majuscule, si le premier caractère est alphabétique.
     */
    public static String ucFirst(String string){
        if(!string.equals(""))
            return string.substring(0, 1).toUpperCase()+ string.substring(1).toLowerCase();
        else
            return "";
    }
    
}
