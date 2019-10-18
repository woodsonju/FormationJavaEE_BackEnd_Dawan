package fr.dawan.taglib.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.dawan.taglib.beans.Student;

/**
 * Servlet implementation class LesTagsLibs
 */
@WebServlet("/")
public class LesTagsLibs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LesTagsLibs() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> students = new ArrayList();
		Student student1 = new Student( "Helena Carlow",  24 , "M.B.B.S." );
		request.setAttribute( "studentsList" , students );
		HttpSession session = request.getSession();
        session.setAttribute("name", student1.getName() );
        session.setAttribute( "age", student1.getAge() );
        session.setAttribute("university", student1.getFaculty() );
		request.getRequestDispatcher( "WEB-INF/home/" ).forward( request , response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		for( int counter = 0 ; counter < 10 ; counter++) {
			String name = "field" + counter;
			String value = request.getParameter( name );
			System.out.println( "Cookie " + name + " = " + value );
			response.addCookie(new Cookie( name, value));
		}
		doGet(request, response);
	}

}
