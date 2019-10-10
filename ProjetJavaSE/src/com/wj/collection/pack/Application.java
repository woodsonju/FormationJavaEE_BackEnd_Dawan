package com.wj.collection.pack;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Application {

	public static void main(String[] args) {

		//Liste
		List list = new ArrayList();   //Déclaration et initialisation d'une liste non typé
		list.add(new String("azerty"));
		list.add(new Integer(10));	//Appel du wrapper car la liste ne stock que des objets
		
		//afficher la taille de la liste
		System.out.println(list.size());
		
		//Supprimer le premier element
		list.remove(0);
		System.out.println(list.size());
		System.out.println(list);
		
		list.add(new String("Bonjour"));
		list.add(new Double(15.5));
		
		System.out.println("\n");

		System.out.println("**************parcourir liste******************");
		for(Object ob : list) {
			System.out.println(ob);
		}
		
		System.out.println("\n" + "Iterator");
		Iterator it = list.listIterator();
		while(it.hasNext())
			System.out.println(it.next());
		
		System.out.println("\n" + "Lambda Expression");
		list.forEach(l -> {
			System.out.println(l);
		});
		
		list.add("a");
		list.add("b");
		
		//remplacer la chaine "a" par la chaine "z"
		int index = list.indexOf("a"); //recuperer l'index de la chaine a
		list.add(index, "z"); //insérer la chaine "z" à la position de la chaine "a"
		
		//afficher la liste
		System.out.println("***********Contenu de la liste*************");
		System.out.println(list);
		
		//Liste typée
		List<String> listTypee = new ArrayList<String>();	//Le type coté gauche est obligatoire  optionnelle coté droit
		listTypee.add("test");
		listTypee.add("list");
		listTypee.add("array");
		
		System.out.println("***************boucle classique***************");
		for(int i=0; i<listTypee.size(); i++)
			System.out.println(listTypee.get(i));
		
		System.out.println("***************boucle Foreach***************");
		for(String l: listTypee)
			System.out.println(l);
		
		
		//MAP <cle:valeur>  -- liste qui stocke des objets de type cle:valeur
		Map<Integer, String> mp = new HashMap<Integer, String>();//Le type de la clé et valeur coté gauche est obligatoire, et optionnelle coté droit
		mp.put(1, "user");
		mp.put(2, "password");
		
		System.out.println("**************map key************************");
		
		//Recupère la valeur stocké dans la clé 2
		System.out.println("La valeur stockée dans la clé est : " + mp.get(2));
		
		
		
		//HashTable
		System.out.println("*******************HASHTABLE**********************");
		Hashtable ht = new Hashtable(); 
		ht.put(1, "été");
		ht.put(2, "hiver");
		ht.put(3, "printemps");
		ht.put(4, "automne");
		
		//Transformer la Hashtable en une énumeration
		Enumeration enumeration = ht.elements();
		
		//Parcours d'une énumeration
		System.out.println("--------------parcourir l'enumeration-----------------------");
		while(enumeration.hasMoreElements())
			System.out.println(enumeration.nextElement());

	}
}
