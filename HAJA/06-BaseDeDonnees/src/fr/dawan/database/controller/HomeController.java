package fr.dawan.database.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.database.beans.Student;
import fr.dawan.database.dao.ConnectionDB;
import fr.dawan.database.dao.StudentDao;

@WebServlet("/")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Test de connexion à la base de données
		try {
	        Connection cnx1 = ConnectionDB.getConnection();
	        long count = StudentDao.count(cnx1, false);
	        
	        int page = 1;
	        int length = 3;
	        
	        if( request.getParameter("page") != null) page = Integer.parseInt( request.getParameter("page") );
	        if( request.getParameter("length") != null)  length = Integer.parseInt( request.getParameter("length") );
	        
	        
	        boolean suivExist = (page * length) < count ;
	        
	        
	        request.setAttribute("suivExist", suivExist);

	        request.setAttribute("page", page);
	        request.setAttribute("length", length);

	        int start = (page - 1) * length;
	        
	        
	        List<Student> studentList = StudentDao.findAll(start, length, cnx1, true);
	        
	        request.setAttribute("studentList", studentList);
	        
			} catch (Exception e ) {
				e.printStackTrace();
			}

		request.getRequestDispatcher("WEB-INF/home/").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		if (request.getParameter("action") != null) {
			
			System.out.println(request.getParameter("action") + " non vide");
			
			
			switch (request.getParameter("action")) {
			case "find":
				if (request.getParameter("name") != null) {
					try {
						Connection cnx = ConnectionDB.getConnection() ;
						String name = request.getParameter("name");
						Student std = StudentDao.findByName(name, cnx, true);
						request.setAttribute("std", std);
					} catch (Exception e) {
						request.setAttribute("notFoundError", request.getParameter("name") );
					}

				} else {
					// Chaîne vide
				}
				break;
			case "add":
				
				
				if( 
					request.getParameter( "name" ) != null && 
					request.getParameter( "age" ) != null && 
					request.getParameter( "faculty" ) != null) {
					
					Student student = new Student();
					
					student.setName(request.getParameter( "name" ));
					student.setAge(Long.parseLong(request.getParameter( "age" )));
					student.setFaculty(request.getParameter("faculty"));
					try {
					StudentDao.insert(student, ConnectionDB.getConnection(), true);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				} else {
					request.setAttribute( "error" , "données manquantes" );
				}
				break;
			
			
			
			case "modify":
				try {
				Student student = StudentDao.findById(
						Long.parseLong(request.getParameter("id")), 
						ConnectionDB.getConnection() , 
						false
				);
				
				request.setAttribute("modificationId", request.getParameter("id") );
				request.setAttribute("name", student.getName() );
				request.setAttribute( "age" , student.getAge() );
				request.setAttribute( "faculty" , student.getFaculty() );
			
				} catch(Exception e) {
					e.printStackTrace();
				}
				break;
			
			case "delete":
				System.out.println("ID à supprimer : " + request.getParameter( "id" ));
				try {
					StudentDao.delete( Long.parseLong(request.getParameter( "id" )), ConnectionDB.getConnection(), true);
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				
				break;

			case "update":
				
				try {
					Student student = StudentDao.findById(
						Long.parseLong(request.getParameter("id")), 
						ConnectionDB.getConnection(), 
						false
					);
					
					
					
					student.setName( request.getParameter( "name" ) );
					
					student.setFaculty( request.getParameter( "faculty" ));
					student.setAge( Long.parseLong( request.getParameter( "age" ) ));
					student.setId(Long.parseLong(request.getParameter("id")));
					
					StudentDao.update(student, ConnectionDB.getConnection(), true);
					
					
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				break;
				
				
			}
			
			

		}

		doGet(request, response);
	}

}
