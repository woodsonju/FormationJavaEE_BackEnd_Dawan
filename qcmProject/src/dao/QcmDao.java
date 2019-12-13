package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Qcm;
import entities.Question;
import entities.Reponse;

public class QcmDao {

	public static List<Qcm> findAll(Connection cnx, boolean closeCnx) throws Exception {
		List<Qcm> lc = new ArrayList<>();
		String sql = "SELECT idQcm, sujet FROM t_qcms";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ResultSet res = ps.executeQuery();
		while (res.next()) {
			lc.add(new Qcm(res.getLong("idQcm"), 
					res.getString("sujet")));
		}
		res.close();
		if (closeCnx)
			cnx.close();
		return lc;
	}

	public static Qcm findQcm(Long idQcmSel, Connection cnx, boolean closeCnx) throws Exception {
		Qcm qcm = null;
		String sql = "SELECT idQcm, sujet FROM t_qcms WHERE idQcm=?";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setLong(1, idQcmSel);
		ResultSet res = ps.executeQuery();
		if (res.next()) {
			qcm = new Qcm(res.getLong("idQcm"), 
					res.getString("sujet"));
		}
		res.close();
		if (closeCnx)
			cnx.close();
		return qcm;
	}

	public static long countQuestions(Long idQcmSel, Connection cnx, boolean closeCnx) throws Exception {
		long nb = 0;
		String sql = "SELECT COUNT(idQuestion) FROM t_questions WHERE idQcm=?";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setLong(1, idQcmSel);
		ResultSet res = ps.executeQuery();
		if (res.next()) {
			nb = res.getLong("COUNT(idQuestion)");
		}
		res.close();
		if (closeCnx)
			cnx.close();
		return nb;
	}

	public static Question findQuestion(Long idQcmSel, int i, Connection cnx, boolean closeCnx) throws Exception {
		Question qst = null;
		String sql = "SELECT idQuestion, idQcm, enonce, ordre, multiple FROM t_questions WHERE idQcm=? AND ordre=?";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setLong(1, idQcmSel);
		ps.setLong(2, i);
		ResultSet res = ps.executeQuery();
		if (res.next()) {
			qst = new Question(res.getLong("idQuestion"),
									res.getLong("idQcm"), 
									res.getString("enonce"),
									res.getInt("ordre"),
									res.getBoolean("multiple"));
		}
		res.close();
		if (closeCnx)
			cnx.close();
		return qst;
	}

	public static List<Reponse> findReponses(long idQuestion, Connection cnx, boolean closeCnx) throws Exception {
		List<Reponse> lRep = new ArrayList<>();
		String sql = "SELECT idReponse, idQuestion, texte, correcte FROM t_reponses WHERE idQuestion=?";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setLong(1,idQuestion);
		ResultSet res = ps.executeQuery();
		while (res.next()) {
			lRep.add(new Reponse(res.getLong("idReponse"),
								res.getLong("idQuestion"), 
								res.getString("texte"),
								res.getBoolean("correcte")));
		}
		res.close();
		if (closeCnx)
			cnx.close();

		return lRep;
	}
	
	public static Reponse findReponseById(long idRepSel, Connection cnx, boolean closeCnx) throws Exception {
		Reponse rep = null;
		String sql = "SELECT idReponse, idQuestion, texte, correcte FROM t_reponses WHERE idReponse=?";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setLong(1,idRepSel);
		ResultSet res = ps.executeQuery();
		if (res.next()) {
			rep = new Reponse(res.getLong("idReponse"),
								res.getLong("idQuestion"), 
								res.getString("texte"),
								res.getBoolean("correcte"));
		}
		res.close();
		if (closeCnx)
			cnx.close();		
		return rep;
	}


}
