package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DbConnection;
import dao.UtilisateurDao;
import entities.Utilisateur;


@WebServlet("/users")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserController() {
		super();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null) {
			switch (action) {
			case "login":
				// traitement
				// redirection
				request.getRequestDispatcher("login.jsp").forward(request, response);
				break;
			case "logout":
				request.getSession().invalidate();
				request.getRequestDispatcher("index.jsp").forward(request, response);
				break;
			case "supprimer" :
				Connection cnx = null;
				try {
					cnx = DbConnection.getConnection();
					Long id = Long.parseLong(request.getParameter("id"));
					UtilisateurDao.delete(id, cnx, false);
					loadUtilisateurs(cnx, false, request, response);
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("msg", "Erreur :" + e.getMessage());
				}		
				String cible = "admin/espace-admin.jsp";
				request.getRequestDispatcher(cible).forward(request, response);
				break;
			case "modifier" :
				try {
					Long id = Long.parseLong(request.getParameter("id"));
					cnx = DbConnection.getConnection();
					Utilisateur user = UtilisateurDao.findById(id, cnx, false);
					request.setAttribute("user", user);
					loadUtilisateurs(cnx, false, request, response);
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("msg", "Erreur :" + e.getMessage());
				}
				
				cible = "admin/espace-admin.jsp";
				request.getRequestDispatcher(cible).forward(request, response);
				break;
			}
			
			
		} else {
			try {
				Connection cnx = DbConnection.getConnection();
				loadUtilisateurs(cnx, false, request, response);
				String cible = "admin/espace-admin.jsp";
				request.getRequestDispatcher(cible).forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		Connection cnx = null;
		String cible = "";
		try {
			cnx = DbConnection.getConnection();
			String action = request.getParameter("action");
			if(action != null) {
				if(action.contentEquals("sauvegarder")) {

					cnx = DbConnection.getConnection();
					//Récupérer les informations
					String nom = request.getParameter("nom");
					
					Long id = 0L;
					
					try {
						id = Long.parseLong(request.getParameter("id"));
					} catch (Exception e) {
						
					}
					//Créer un utilisateur
					Utilisateur user = new Utilisateur(id, nom, email, pwd);
					
					if(id == 0) // Insérer en bdd
						UtilisateurDao.insert(user, cnx, false);
					else	//Modification		
						UtilisateurDao.update(user, cnx, false);
					
					//rediriger vers la liste
					loadUtilisateurs(cnx, false, request, response);
					request.getRequestDispatcher("admin/espace-admin.jsp").forward(request, response);
				} 
			} else {

				// vérifier la présence de l'utilisateur en BDD

				Utilisateur u = UtilisateurDao.findByEmail(email, cnx, false);
				if (u == null || !u.getPwd().contentEquals(pwd)) {
					request.setAttribute("msg", "Authentification incorrecte !");
					cible = "login.jsp";
				} else {
					request.getSession().setAttribute("userConnected", true);
					request.getSession().setAttribute("userName", u.getNom());
				}

				loadUtilisateurs(cnx, false, request, response);
				cible = "admin/espace-admin.jsp";
				request.getRequestDispatcher(cible).forward(request, response);
			}
		} catch (Exception e) {
			if (cnx != null)
				try {
					cnx.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			request.setAttribute("msg", "Erreur :" + e.getMessage());
		}
		
	}

	// méthode pour charger la liste des utilisateurs
	public void loadUtilisateurs(Connection cnx, boolean closeCnx, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		int page = 1;
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
		}
		int nbMaxByPage = 5;
		try {
			nbMaxByPage = Integer.parseInt(request.getParameter("max"));
		} catch (Exception e) {
		}

		int start = (page - 1) * nbMaxByPage;
		List<Utilisateur> lst = UtilisateurDao.findAll(start, nbMaxByPage, cnx, closeCnx);
		request.setAttribute("usersList", lst);
		request.setAttribute("page", page);
		request.setAttribute("max", nbMaxByPage);

		boolean suivExist = (page * nbMaxByPage) < UtilisateurDao.count(cnx, true);
		request.setAttribute("suivExist", suivExist);

	}



}
