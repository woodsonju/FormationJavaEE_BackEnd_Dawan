package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Qcm;
import entities.Question;
import entities.Reponse;
import entities.Utilisateur;

public class QcmDAO {
//	   List<Qcm>  findAllQcm()
//	   Qcm findQcmById(int idQcm)
//	   Question findQuestion(int idQcm, int ordre)
//	   List<Reponse> findReponses(int idQuestion)
//	   Reponse findReponseById(int id)
	public static List<Qcm> findAll(Connection cnx, boolean closeCnx) throws Exception {
		
		List<Qcm> lc = new ArrayList<>();
		String sql = "SELECT idQcm, sujet FROM t_qcms";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ResultSet res = ps.executeQuery();
		while (res.next()) {
			lc.add(new Qcm(res.getLong("idQcm"), res.getString("sujet")));
		}
		
		res.close();
		if (closeCnx)
			cnx.close();
		
		return lc;
	}

	public static Qcm findById(long id, Connection cnx, boolean closeCnx) throws Exception {
		Qcm qcm = null;
		String sql = "SELECT idQcm, sujet FROM t_qcms WHERE idQcm=?";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setLong(1, id);

		ResultSet res = ps.executeQuery();
		if (res.next()) {
			qcm = new Qcm(res.getLong("idQcm"), res.getString("sujet"));
		}
		res.close();
		if (closeCnx)
			cnx.close();
		return qcm;
	}

	
	public static Question findQuestion(long idQcm, int ordre, Connection cnx, boolean closeCnx) throws Exception {
		Question question = null;
		String sql = "SELECT idQuestion, enonce, idQcm, ordre, multiple FROM t_questions WHERE idQcm=?";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setLong(1, idQcm);

		ResultSet res = ps.executeQuery();
		if (res.next()) {
			question = new Question(res.getLong("idQuestion"), res.getString("enonce"), res.getLong("idQcm"), res.getInt("ordre"), res.getInt("multiple"));
		}
		res.close();
		if (closeCnx)
			cnx.close();
		return question;
	}
	
	// List<Reponse> findReponses(int idQuestion)
	public static  List<Reponse> findReponses(long idQuestion, Connection cnx, boolean closeCnx) throws Exception {
		List<Reponse> lr = new ArrayList<>();
		String sql = "SELECT idReponse, idQuestion, texte, correcte FROM t_reponses where idQuestion=?";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setLong(1, idQuestion);
		ResultSet res = ps.executeQuery();
		while (res.next()) {
			lr.add(new Reponse(res.getLong("idReponse"), res.getLong("idQuestion"), res.getString("texte"), res.getBoolean("correcte")));
		}
		
		res.close();
		if (closeCnx)
			cnx.close();
		
		return lr;
	}
	

	//Reponse findReponseById(int id)
	public static Reponse findReponseById(long idReponse, Connection cnx, boolean closeCnx) throws Exception {
		Reponse rep = null;
		String sql = "SELECT idReponse, idQuestion, texte, correcte FROM t_reponses WHERE idReponse=?";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setLong(1, idReponse);

		ResultSet res = ps.executeQuery();
		if (res.next()) {
			rep = new Reponse(res.getLong("idReponse"), res.getLong("idQuestion"), res.getString("texte"), res.getBoolean("correcte"));
		}
		res.close();
		if (closeCnx)
			cnx.close();
		return rep;
	}
}
