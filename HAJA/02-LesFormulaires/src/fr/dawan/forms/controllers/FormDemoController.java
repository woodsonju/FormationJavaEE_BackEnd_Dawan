package fr.dawan.forms.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Chapitre 02 : formulaires", urlPatterns = "")
public class FormDemoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FormDemoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		if( request.getParameter( "action" ) != null ) {
			System.out.println("action = " + request.getParameter( "action" ));
			request.setAttribute( "my_name" , request.getParameter( "name" ));		
		}
				
		request.getRequestDispatcher( "/WEB-INF/" ).forward( request , response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String text = request.getParameter( "un_texte" );
		// un petit traitement : convertir le texte en majuscules.
		request.setAttribute( "texte" , text.toUpperCase());
		doGet(request, response);
	}
}