package fr.dawan.database.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.dawan.database.beans.Student;
import fr.dawan.database.dao.ConnectionDB;
import fr.dawan.database.dao.StudentDao;
/**
 * Servlet implementation class HomeController
 */
@WebServlet("/")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public HomeController() {
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection cnx;
        try {
                cnx = ConnectionDB.getConnection();
                
                // Nombre total d'enregistrements
                long count = StudentDao.count(cnx, false);
                
                // le paramètre éventuellement transmis dans l'URL
                int page = 1;
                
                // nombre d'étudiants à afficher pour une page donnée
                int length = 3;
                
                
                if( request.getParameter( "page" ) != null ) {
                        page = Integer.parseInt(request.getParameter( "page" ));
                }
                
                if( request.getParameter( "length" ) != null ) {
                        length = Integer.parseInt(request.getParameter( "length" ));
                }
                
                int start = (page - 1) * length;
                
                boolean suivExist = (page * length) < count ;
                request.setAttribute("suivExist", suivExist);
                
                request.setAttribute( "page", page);
                request.setAttribute( "length", length);
                
                List<Student> students = StudentDao.findAll(start, length, cnx, false);
                
                request.setAttribute("studentsList", students);

        } catch (Exception e) {
                e.printStackTrace();
        } 

        request.getRequestDispatcher("WEB-INF/home/").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		if(action != null) {
			switch (action) {
			case "add":
				if(request.getParameter("name") != null
				&& request.getParameter("age") != null
				&& request.getParameter("faculty") != null
						) {
					Student student = new Student(
							request.getParameter("name"),
							Long.parseLong(request.getParameter("age")),
							request.getParameter("faculty"));

					try {
						Connection cnx = ConnectionDB.getConnection();

						StudentDao.insert(student, cnx, false);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				break;

			case "modify":
				try {
					Connection cnx = ConnectionDB.getConnection();
					Long id =Long.parseLong(request.getParameter("id"));
					Student student = StudentDao.findById(id, cnx, true);
					request.setAttribute("modificationId", request.getParameter("id"));					
					request.setAttribute("name", student.getName());
					request.setAttribute("age", student.getAge());
					request.setAttribute("faculty", student.getFaculty());	
					
					String name = request.getParameter("name");
					Long age = Long.parseLong(request.getParameter("age"));
					String faculty = request.getParameter("faculty");
					
					Student s = new Student(name, age, faculty);
					StudentDao.update(s, cnx, true);

					//request.setAttribute("student", student);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}

				break;

			case "delete":
				try {
					Connection cnx = ConnectionDB.getConnection();
					Long id =Long.parseLong(request.getParameter("id"));
					StudentDao.delete(id, cnx, false);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
//				List<Student> studentList = StudentDao.findAll(cnx, willBeClosed)
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


			case "find": 
			    if (request.getParameter("name") != null) {
					try {
						Connection cnx = ConnectionDB.getConnection();
						String findName = request.getParameter("name");
						List<Student> studentList = StudentDao.findByName(findName, cnx, true);
						request.setAttribute("studentList", studentList);
						System.out.println("*******Taille de la liste*******");
					} catch (Exception e) {
						e.printStackTrace();
					}
					
			    } else {
			    	
			    }
				break;

			}
		}





		/*
		 * Long id = Long.parseLong(request.getParameter("id"));
			//Le controleur va chercher dans la base de données le produit qu'on veut editer
			Produit p = metier.getProduit(id);

			//Le controleur stock p dans le l'objet request
			request.setAttribute("produit", p);

			request.getRequestDispatcher("editProduit.jsp").forward(request, response);

		 */

		doGet(request, response);
	}
}