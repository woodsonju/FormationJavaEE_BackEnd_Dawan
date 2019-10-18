package com.wj.dawan.personnalisationTId.exceptions;

public class DivisionByZeroException extends ArithmeticException {
	
	public DivisionByZeroException() {
        super();
	}

	public DivisionByZeroException(int id) {
	        super( String.format("Division de  %s par 0 !", id));
	}	
	
}
