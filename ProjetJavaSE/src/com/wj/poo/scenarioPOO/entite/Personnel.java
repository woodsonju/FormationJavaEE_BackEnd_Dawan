package com.wj.poo.scenarioPOO.entite;

public class Personnel {
	
	private Employee[] employees;
	private int nbreEmployee;
	private final static int MAXEMPLOYE = 100;
	
	
	
	public Personnel() {
		//Pour initialiser les attributs on passe par les constructeurs
		this.employees = new Employee[MAXEMPLOYE];
		this.nbreEmployee = 0;
	}


	public void ajouterEmploye(Employee employee) {
		++nbreEmployee;
		if(nbreEmployee <= MAXEMPLOYE)
			employees[nbreEmployee - 1] = employee;
		else {
			System.out.println("Pas plus de " + MAXEMPLOYE + " employés");
			return;
		}
	}
	
	public void afficherSalaire() {
		for(int i=0; i<nbreEmployee; i++) {
			System.out.println(employees[i].getNom() + 
					" gagne " + employees[i].calculerSalaire() + 
					" euros");
		}
	}
	
	public double salaireMoyen() {
		double somme = 0;
		for(int i=0; i<nbreEmployee; i++) {
			somme += employees[i].calculerSalaire();
		}
		return somme/nbreEmployee;
	}
	
}
