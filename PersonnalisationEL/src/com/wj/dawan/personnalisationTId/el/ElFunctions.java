package com.wj.dawan.personnalisationTId.el;

import com.wj.dawan.personnalisationTId.exceptions.DivisionByZeroException;

public class ElFunctions {
	
	public static final double VAT = 19.76/ 100 ; // TVA
    
    
    public static int sum(int a, int b) {
            return a + b;
    }
    
    public static int substraction(int a, int b) {
            return a - b;
    }
    
    public static double division(int a, int b) {
            if( b == 0 ) {
                    throw new DivisionByZeroException(a);
            }
            return (double) (double) a / (double) b;
    }
    
    public static int multiplication(int a, int b) {
            return a * b;
    }        
    
    
    /**
     * Calcul de prix TTC
     * @param p
     * Taux de TVA (en pourcentage)
     * @return
     * Un double
     */
    public static double price(double p) { // prix TTC
            return p + (p * VAT);
    }}
