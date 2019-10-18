package fr.dawan.el.dao;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DaoMailing {
	

		public static boolean isEmailAdress(String email){
			Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$");
			Matcher m = p.matcher(email.toUpperCase());
			return m.matches();
			}
		
		public static void sendEmail(String from, String to, String subject, String htmlContent) throws  Exception {

	        final String username = "hrabesiaka@jehann.fr";
	        final String password = "unMotDePasse";
	        String host = "smtp.orange.fr";
	        Properties props = new Properties();
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtp.port", "465 ");
	        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {return new PasswordAuthentication(username, password);}
	        });
	        try {
	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(from));
	            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
	            message.setSubject(subject);
	            message.setContent( htmlContent,"text/html");
	         
	            
	            /**
	             * Encodage UTF-8 du corps du message.
	             */
	            message.setHeader("Content-Type", "text/html; charset=UTF-8");
	            
	            session.setDebug(true);
	            Transport.send(message);
	        } catch (Exception e) {
	            System.out.println("Problème");
	            e.printStackTrace();
	        }
	    
		}
}
