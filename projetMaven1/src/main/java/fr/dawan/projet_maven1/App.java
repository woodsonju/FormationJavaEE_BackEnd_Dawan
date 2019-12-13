package fr.dawan.projet_maven1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App 
{
	private static Logger myRootLogger = LogManager.getRootLogger();
	private static Logger myErrorLogger = LogManager.getLogger("myErrorLogger");

	public static void main( String[] args )
	{
		//System.out.println("Hello World!" );
		myRootLogger.info("mon log");

		try {
			int a = 6;
			int c = a/0;        
		} catch (Exception e) {
			myErrorLogger.error("erreur de calcul",e);
		}
	}

}
