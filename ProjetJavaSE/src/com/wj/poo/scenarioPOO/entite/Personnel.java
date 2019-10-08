package com.wj.poo.scenarioPOO.entite;

public class Personnel {
	
	private Employee[] staff;
	private int nbreEmployee;
	private final static int MAXEMPLOYE = 100;
	
	
	
	public Personnel() {
		super();
		this.staff = staff;
		this.nbreEmployee = 0;
	}



	public void ajouterEmploye(Employee employee) {
		++nbreEmployee;
		if(nbreEmployee <= MAXEMPLOYE)
			staff[nbreEmployee - 1] = employee;
		else {
			System.out.println("Pas plus de " + MAXEMPLOYE + " employés");
			return;
		}
	}
	
	public void afficherSalaire() {
		for(int i=0; i<nbreEmployee; i++) {
			System.out.println(staff[i].getNom() + 
					" gagne " + staff[i].calculerSalaire() + 
					" euros");
		}
	}
	
	public double salaireMoyen() {
		double somme = 0;
		for(int i=0; i<nbreEmployee; i++) {
			somme += staff[i].calculerSalaire();
		}
		return somme/nbreEmployee;
	}
	
}
