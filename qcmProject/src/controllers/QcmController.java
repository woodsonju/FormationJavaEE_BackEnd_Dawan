package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DbConnection;
import dao.QcmDao;
import entities.Qcm;
import entities.Question;
import entities.Reponse;
import entities.TestQCM;

/**
 * Servlet implementation class QcmController
 */
@WebServlet("/qcm")
public class QcmController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QcmController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String cible = "index.jsp";
		try {
			if(action!=null) {
				switch (action) {
				case "choix":
					//récupérer la liste des qcms
					Connection cnx = DbConnection.getConnection();
					List<Qcm> listeQcms = QcmDao.findAll(cnx,true);
					//ajouter dans request
					request.setAttribute("listeQcms", listeQcms);
					cible="choix-qcm.jsp";
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erreur :"+e.getMessage());
		}
		request.getRequestDispatcher(cible).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cible = "deroulement.jsp";
		try {
			Connection cnx = DbConnection.getConnection();	
			String action = request.getParameter("action");
			HttpSession session = request.getSession();
			if(action!=null) {
				switch (action) {
				case "demarrer":
					Long idQcmSel = Long.parseLong(request.getParameter("idQcmSel"));
					Qcm qcm = QcmDao.findQcm(idQcmSel,cnx, false);
					long nbQuestions = QcmDao.countQuestions(idQcmSel, cnx,false);
					TestQCM test = new TestQCM(0, new Date(), 0, idQcmSel, 0);
					session.setAttribute("numQst", 1);
					session.setAttribute("nbQuestions", nbQuestions);
					session.setAttribute("test", test);
					session.setAttribute("sujetQcm", qcm.getSujet());
					session.setAttribute("idQcm", qcm.getIdQcm());
					afficherQuestion(idQcmSel, 1, request, response, cnx);
					break;
				case "suivant":				
					boolean multiple = (Boolean)session.getAttribute("multiple");
					test = (TestQCM)session.getAttribute("test");
					if(multiple) {
						String[] reps = request.getParameterValues("repSel");
						for(String s : reps)
						{
							long idR = Long.parseLong(s);
							Reponse r = QcmDao.findReponseById(idR, cnx, false);
							if(r.isCorrecte()) 
								test.setScore(test.getScore()+1);
							else
								test.setScore(test.getScore()-1);
							session.setAttribute("test", test);

						}
					}else {
						long idRepSel = Long.parseLong(request.getParameter("repSel"));
						Reponse r = QcmDao.findReponseById(idRepSel, cnx, false);
						if(r.isCorrecte()) {
							test.setScore(test.getScore()+1);
							session.setAttribute("test", test);
						}
					}

					//Récupérer la question en cours et savoir si elle est multiple ou pas
					//Si multiple request.getParameterValues("repSel")
					//Sinon request.getParameter("repSel")
					//Vérifier si rép correte en bdd => score++
					//Vérifier s'il reste des questions > question suivante
					//Sinon vérifier le score dans une page
					nbQuestions = (Long) session.getAttribute("nbQuestions");
					long idQcm = (Long) session.getAttribute("idQcm");
					int numQst = (Integer)session.getAttribute("numQst");
					if(numQst<nbQuestions) {
						numQst++;
						session.setAttribute("numQst", numQst);
						afficherQuestion(idQcm, numQst, request, response, cnx);
					}else {
						cible = "resultat.jsp";
					}

					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erreur :"+e.getMessage());
		}
		request.getRequestDispatcher(cible).forward(request, response);
		//si demarrer :
		//		récupérer une connexion
		// récupérer l'idQcm sélectionné "idQcmSel"
		//rechercher le qcm en BDD
		//rechercher la première question qcm sélectionné
		//		mettre en session un TestQcm, score=0, numQstenCours,
		//								nbQuestions


	}

	private void afficherQuestion(Long idQcmSel, int i, HttpServletRequest request, HttpServletResponse response,
			Connection cnx) throws Exception {
		Question qst = QcmDao.findQuestion(idQcmSel, i, cnx, false);
		request.getSession().setAttribute("multiple", qst.isMultiple());
		List<Reponse> lRep = QcmDao.findReponses(qst.getIdQuestion(), cnx,true);
		request.setAttribute("qst", qst);
		request.setAttribute("lRep", lRep);

	}








}
