//package controllers;
//
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.util.List;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import dao.DbConnection;
//import dao.QcmDAO_Moi;
//import entities.Qcm;
//import entities.Question;
//import entities.Reponse;
//
//
//@WebServlet("/qcm")
//public class QcmControllerMoi extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	public QcmControllerMoi() {
//		super();
//	}
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String action = request.getParameter("action");
//		String cible = "index.jsp";
//		try {
//			if(action!=null) {
//				switch (action) {
//				case "choix":
//					//récupérer la liste des qcms
//					Connection cnx = DbConnection.getConnection();
//					List<Qcm> listeQcms = QcmDAO_Moi.findAll(cnx,true);
//					//ajouter dans request
//					request.setAttribute("listeQcms", listeQcms);
//					cible="choix-qcm.jsp";
//					break;
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			request.setAttribute("msg", "Erreur :"+e.getMessage());
//		}
//		request.getRequestDispatcher(cible).forward(request, response);
//	}
//
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		
//		//Si démarrer :
//		//	Récupérer une connexion
//		//Récuperer l'idQcm sélectionné "idQcmSel"
//		//Rechercher le qcm en BDD
//		//Recherche la première question qcm sélectionné
//		//Mettre en session un TestQcm, score=0, numQstenCours, nbQuestions
//		
//		String cible = "choix-qcm.jsp";
//		Connection cnx = null;
//		try {
//			cnx = DbConnection.getConnection();
//			String action = request.getParameter("action");
//			if(action != null) {
//				switch (action) {
//				case "demarrer":
//					long idQcm = Long.parseLong(request.getParameter("idQcmSel"));
//					
//					Question question = QcmDAO_Moi.findQuestion(idQcm, 1, cnx, false);
//					request.setAttribute("question", question);
//
//					Qcm qcm = QcmDAO_Moi.findById(idQcm, cnx, false);
//					request.setAttribute("qcm", qcm);
//					
//					List<Reponse> reponseList = QcmDAO_Moi.findReponses(question.getIdQuestion(), cnx, false);
//					request.setAttribute("reponseList", reponseList);
//	
//					
//					System.out.println(question.getEnonce());
//					System.out.println(reponseList.get(0).getTexte());
//					break;
//
//				default:
//					break;
//				}
//				
////				if(action.contentEquals("demarrer")) {
////					cnx = DbConnection.getConnection();
////					
////					long idQcm = Long.parseLong(request.getParameter("idQcmSel"));
////					
////					Question question = QcmDAO.findQuestion(idQcm, 1, cnx, false);
////					request.setAttribute("question", question);
////
////					Qcm qcm = QcmDAO.findById(idQcm, cnx, false);
////					request.setAttribute("qcm", qcm);
////					
////					List<Reponse> reponseList = QcmDAO.findReponses(question.getIdQuestion(), cnx, false);
////					request.setAttribute("reponseList", reponseList);
////					
////					cible="choix-question.jsp";
////					
////					System.out.println(question.getEnonce());
////					System.out.println(reponseList.get(0).getTexte());
////
////				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		request.getRequestDispatcher(cible).forward(request, response);
//		doGet(request, response);
//	}
//
//}
//
//
//
//
//
//
//
////@WebServlet("/qcms")
////public class QcmController extends HttpServlet {
////	private static final long serialVersionUID = 1L;
////
////
////	public QcmController() {
////	}
////
////
////	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////		Connection cnx;
////		try {
////			cnx = DbConnection.getConnection();
////			List<Qcm> qcmsList = QcmDAO.findAll(cnx, false);
////			request.setAttribute("qcmsList", qcmsList);
////			request.getRequestDispatcher("qcms.jsp").forward(request, response);
////
////			
////			String action = request.getParameter("action");
////			if(action != null) {
////				switch (action) {
////				case "qcmsLists":
////					Long idQcm = Long.parseLong(request.getParameter("id"));
////					Question question = QcmDAO.findQuestion(idQcm, 1, cnx, false);
////					request.setAttribute("question", question);
////					request.getRequestDispatcher("question.jsp").forward(request, response);
////					break;
////
////				default:
////					break;
////				}
////			}
////
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
////	}
////
////
////	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////
////
////		doGet(request, response);
////	}
////
////}

