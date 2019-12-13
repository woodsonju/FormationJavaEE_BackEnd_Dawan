//import java.sql.Connection;
//import java.util.List;
//
//import dao.DbConnection;
//import dao.QcmDAO_Moi;
//import entities.Qcm;
//import entities.Question;
//import entities.Reponse;
//
//public class TestApp {
//
//	public static void main(String[] args) {
//
//		try {
//			Connection cnx = DbConnection.getConnection();
//
//			System.out.println("*******************List des QCM************************************");
//			List<Qcm> list = QcmDAO_Moi.findAll(cnx, false);
//			for(Qcm q: list)
//				System.out.println(q.getSujet());
//
//			System.out.println("\n*******************Trouver un QCM*********************************");
//			Qcm unQCM = QcmDAO_Moi.findById(1, cnx, false);
//			System.out.println(unQCM.getSujet());
//
//			System.out.println("\n*******************Trouver une Question****************************");
//			Question question = QcmDAO_Moi.findQuestion(1, 1, cnx, false);
//			System.out.println(question.getEnonce());
//
//			System.out.println("\n*******************Liste des réponses *****************************");
//			List<Reponse> lr = QcmDAO_Moi.findReponses(1, cnx, false);
//			for(Reponse r : lr)
//				System.out.println(r);
//
//
//			System.out.println("\n*******************Trouver un QCM*********************************");
//			Reponse reponse = QcmDAO_Moi.findReponseById(1, cnx, true);
//			System.out.println(reponse);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//
//}
