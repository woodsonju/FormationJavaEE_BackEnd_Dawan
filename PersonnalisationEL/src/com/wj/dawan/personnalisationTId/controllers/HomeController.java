package com.wj.dawan.personnalisationTId.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("")
public class HomeController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
	public HomeController() {
	    super();
	}

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            System.out.println("==========> Je passe dans le CONTROLLEUR");
            request.getRequestDispatcher( "WEB-INF/home/" ).forward( request , response);
    }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
    }
}
