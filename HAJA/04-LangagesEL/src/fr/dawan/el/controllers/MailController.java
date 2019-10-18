package fr.dawan.el.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.annotation.MultipartConfig;
import java.nio.file.Paths;
import javax.servlet.http.*; // Parts

import fr.dawan.el.dao.DaoMailing;
import java.io.*;


// imports ARNAUD
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.MessagingException;

import java.util.Date;
import java.util.Properties;


@WebServlet("/email")
public class MailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MailController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute( "action" , "email" );
		request.getRequestDispatcher( "/WEB-INF/views/" ).forward( request , response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if( request.getParameter( "action") != null) {
			switch(request.getParameter( "action")) {
				case "emptyEmail":
					System.out.println("Je passe dans sans pièce jointe");
					try {
						if( 
								request.getParameter( "recipient" )== "" ||
								request.getParameter( "sender" )== "" ||
								request.getParameter( "html_content") == "" ||
								request.getParameter( "subject" ) == ""
								) {
							request.setAttribute("mailError", "NOT_NULL");
							doGet(request, response);
							return;
						}
						
						
						if(!
								DaoMailing.isEmailAdress( request.getParameter( "recipient" ) )
						) {
							request.setAttribute( "recipientError" , request.getParameter( "recipient" ));
							doGet(request, response);
							return;
						}
						
						
						if(!
								DaoMailing.isEmailAdress( request.getParameter( "sender" ) )
							) {
								request.setAttribute( "senderError" , request.getParameter( "sender" ));
								doGet(request, response);
								return;
						}
					
						/**
						 * Attention, cette email partire réellement à l'adresse de destination !!!!
						 */
						DaoMailing.sendEmail(
							request.getParameter( "sender" ) ,
							request.getParameter( "recipient" ),
							request.getParameter( "subject" ), 
							request.getParameter( "html_content")
						);
						doGet(request, response);
						return;
						
					} catch(Exception e) {
						e.printStackTrace();
					}
					break;
				case "withAttachmentEmail":
					
					
					System.out.println("Je passe dans pièce jointe");
					
			        // Remplacer plus tard par un fichier choisi par l'utilisateur
			        String fileName = "C:/Users/HAJA/Pictures/a-supprimer.png" ;
			        System.out.println("Filename = " + fileName);
			        
					
					Properties props = System.getProperties();
					String host = "smtp.orange.fr"; 
					props.put("mail.smtp.host", host);
					props.put("mail.smtp.port", "465 ");
					
					Session session = Session.getInstance(props, null);
					
					try {
						MimeMessage msg = new MimeMessage(session);
						msg.setFrom(new InternetAddress( request.getParameter( "sender" ) ));
						InternetAddress[] address = { new InternetAddress( request.getParameter( "recipient" ) ) };
						msg.setRecipients(Message.RecipientType.TO, address);
						msg.setSubject( request.getParameter( "subject" ) );
						
						MimeBodyPart mbp2 = new MimeBodyPart();
						
						System.out.println("filename = " + fileName);
						File dir = new File ( fileName );

						// Attache le fichier du message
						
						FileDataSource fds = new FileDataSource( fileName );
						mbp2.setDataHandler(new DataHandler(fds));
						mbp2.setFileName(fds.getName());
						Multipart mp = new MimeMultipart();
						mp.addBodyPart(mbp2);
						msg.setContent(mp);
						msg.setSentDate(new Date());
						Transport.send(msg);
					} catch(MessagingException mex) {
						mex.getMessage();
						
						 mex.printStackTrace();
						 
						Exception ex = null;
						if ((ex = mex.getNextException()) != null) {
							ex.printStackTrace();
						}
					}
					
			        
					doGet(request, response);
					return;
			}
		}
		
	}

}
