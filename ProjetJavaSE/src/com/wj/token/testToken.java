package com.wj.token;

import java.util.StringTokenizer;

public class testToken {

	public static void main(String[] args) {
		
		/**
		 * Prend en paramètre une chaine de caractères et renvoie
		 * les tokens contenus dans cette chaine
		 */
		StringTokenizer st = new StringTokenizer("ceci est un test");
		while(st.hasMoreTokens()) {
			if(st.nextToken().equals("un")) 
				System.out.println("Le mot existe");
			else
				System.out.println("Le mot n'existe pas");
			
			//System.out.println(st.nextToken());
		}
		
		
	}

}
