package fr.dawan.formation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.istack.internal.logging.Logger;

import fr.dawan.formation.domain.Client;
import fr.dawan.formation.domain.Multiplication;
import fr.dawan.formation.service.MultiplicationServiceImpl;

public class Application {
	
	private static ApplicationContext appContext;
	private static Logger LOGGER = Logger.getLogger(Application.class);
	
	public static void main(String[] args) {
		
		LOGGER.info("Lancement de mon application");
		LOGGER.finest("Message finest");
		
		appContext = new ClassPathXmlApplicationContext("beans.xml");
		
		//On ne peux plus instancier Contact car elle est abstracte =>  dans beans.xml abstract="true"
//		Contact contact = appContext.getBean("contact1", Contact.class);
//		LOGGER.info(contact.getNom());
		
		//Bean multiplication par constructeur
		Multiplication multiplication = appContext.getBean("multiplication", Multiplication.class);
		LOGGER.info(String.valueOf(multiplication.getResultat()));
		
		//Bean multiplication par property 
		Multiplication multiplication1 = appContext.getBean("multiplication1", Multiplication.class);
		LOGGER.info(String.valueOf(multiplication1.getResultat()));
		
//		try {
//			contact.destroy();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		LOGGER.info("============HERITAGE============");
		Client client = appContext.getBean("client", Client.class);
		LOGGER.info(client.getNumero() + " "+ client.getNom() + " " + client.getPrenom());
		
		
		LOGGER.info("============AUTOWIRE============");
		LOGGER.info(String.valueOf(client.getAdresse()));
		
		LOGGER.info("============List============");
		LOGGER.info(String.valueOf(client.getFavorites()));
		
		LOGGER.info("============SET============");
		LOGGER.info(String.valueOf(client.getNumbers()));
		
		LOGGER.info("============AUTOWIRED CONSRTUCTOR============");
		MultiplicationServiceImpl myservice = appContext.getBean("multiplicationService", MultiplicationServiceImpl.class);
		Multiplication multi = myservice.createRandomMultiplication();
		System.out.println(multi);

	}

}
