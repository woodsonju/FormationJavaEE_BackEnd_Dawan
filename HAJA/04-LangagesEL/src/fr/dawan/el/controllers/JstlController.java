package fr.dawan.el.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.el.beans.Student;



@WebServlet("/jstl")
public class JstlController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JstlController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setAttribute( "action", "jstl");
		
		List<Student> students = new ArrayList();
		students.add( new Student( "Roxy Willard", 22, "B.D.S." ) );
		students.add( new Student( "Todd Lanz", 22 , "B.T." ) );
		students.add( new Student( "Varlene Lade", 21 , "B. TECH" ) );
		students.add( new Student( "Julio Fairley", 22 , "C.B.A." ) );
		students.add( new Student( "Helena Carlow",  24 , "M.B.B.S." ) );
		System.out.println("Nombre d'étudiants : "+ students.size());
		request.setAttribute( "studentsList" , students );
		
		
		
		
		request.getRequestDispatcher( "/WEB-INF/views/" ).forward( request , response );
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
