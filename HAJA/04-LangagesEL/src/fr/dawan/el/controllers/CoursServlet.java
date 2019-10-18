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

/**
 * Servlet implementation class CoursServlet
 */
@WebServlet("/cours")
public class CoursServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoursServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute( "exemple" , "Michel" );
		
		List<Student> students = new ArrayList();
		students.add( new Student( "Roxy Willard", 22, "B.D.S." ) );
		students.add( new Student( "Todd Lanz", 22 , "B.T." ) );
		students.add( new Student( "Varlene Lade", 21 , "B. TECH" ) );
		students.add( new Student( "Julio Fairley", 22 , "C.B.A." ) );
		students.add( new Student( "Helena Carlow",  24 , "M.B.B.S." ) );
		request.setAttribute( "studentsList" , students );	
		
		request.setAttribute("tata", 12.45d); // un double
		request.setAttribute("unNombre", 0);
		
		request.setAttribute( "laDate" , "dim");

		
		
		if( request.getParameter("action_a_faire") != null  ) {
			if( request.getParameter( "nombre" ) != null) {
				int nombre = Integer.parseInt( request.getParameter( "nombre" ) );
				request.setAttribute("fact", factoriel(nombre));
				request.setAttribute("nombre", request.getParameter( "nombre" ));
			}
		}
		
		
		request.getRequestDispatcher("WEB-INF/views/cours.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	public long factoriel(int x) {
		long P = 1L;
		// Boucle FOR (mais pas FOREACH)
		for(int i=1 ; i<=x ; i++) {
			P *= i; // équivalent de P = P * i
		}
		return P;
	}

}
