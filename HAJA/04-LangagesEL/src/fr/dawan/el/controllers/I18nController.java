package fr.dawan.el.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/i18n")
public class I18nController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public I18nController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute( "action" , "i18n" );
		request.setAttribute("string", "324123,23234");
		request.setAttribute("date1" , new java.util.Date());
		
		request.setAttribute("string", "324123,23234");
		
		request.getRequestDispatcher( "/WEB-INF/views/" ).forward( request , response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
