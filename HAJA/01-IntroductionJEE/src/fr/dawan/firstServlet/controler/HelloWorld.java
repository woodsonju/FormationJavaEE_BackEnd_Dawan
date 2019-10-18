package fr.dawan.firstServlet.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.firstServlet.beans.Student;

/**
 * Servlet implementation class HelloWorld
 */
//@WebServlet(name = "HelloServlet", urlPatterns = "")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response
			) throws ServletException, IOException {
		
		request.setAttribute( "myName" , "Billy MACHIN" );
		List<Student> students = new ArrayList();
		students.add( new Student( "Roxy Willard", 22, "B.D.S." ) );
		students.add( new Student( "Todd Lanz", 22 , "B.T." ) );
		students.add( new Student( "Varlene Lade", 21 , "B. TECH" ) );
		students.add( new Student( "Julio Fairley", 22 , "C.B.A." ) );
		students.add( new Student( "Helena Carlow",  24 , "M.B.B.S." ) );
		request.setAttribute( "studentsList" , students );	
		
		request
			.getRequestDispatcher( "/WEB-INF/jspFiles/" )
			.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
