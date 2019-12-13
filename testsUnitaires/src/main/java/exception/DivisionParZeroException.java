package exception;

public class DivisionParZeroException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public DivisionParZeroException() {
		super("Erreur: Division par zéro interdite");
	}
	
}
