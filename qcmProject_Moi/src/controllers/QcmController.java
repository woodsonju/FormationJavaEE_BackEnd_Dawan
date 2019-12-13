package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DbConnection;
import dao.QcmDAO;
import dao.UtilisateurDao;
import entities.Qcm;
import entities.Question;
import entities.Utilisateur;


@WebServlet("/qcms")
public class QcmController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public QcmController() {
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection cnx;
		try {
			cnx = DbConnection.getConnection();
			List<Qcm> qcmsList = QcmDAO.findAll(cnx, false);
			request.setAttribute("qcmsList", qcmsList);
			request.getRequestDispatcher("qcms.jsp").forward(request, response);

			
			String action = request.getParameter("action");
			if(action != null) {
				switch (action) {
				case "qcmsLists":
					Long idQcm = Long.parseLong(request.getParameter("id"));
					Question question = QcmDAO.findQuestion(idQcm, 1, cnx, false);
					request.setAttribute("question", question);
					request.getRequestDispatcher("qcms.jsp").forward(request, response);
					break;

				default:
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		doGet(request, response);
	}

}

