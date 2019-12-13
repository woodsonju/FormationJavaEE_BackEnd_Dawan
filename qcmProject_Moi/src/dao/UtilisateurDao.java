package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Utilisateur;

public class UtilisateurDao {

	public static List<Utilisateur> findAll(int start, int nb, Connection cnx, boolean closeCnx) throws Exception {
		List<Utilisateur> lc = new ArrayList<>();
		String sql = "SELECT id, nom, email,pwd FROM t_utilisateurs LIMIT ?,?";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setInt(1, start);
		ps.setInt(2, nb);
		ResultSet res = ps.executeQuery();
		while (res.next()) {
			lc.add(new Utilisateur(res.getLong("id"), res.getString("nom"), res.getString("email"),
					res.getString("pwd")));
		}
		res.close();
		if (closeCnx)
			cnx.close();
		return lc;
	}

	public static Utilisateur findById(long id, Connection cnx, boolean closeCnx) throws Exception {
		Utilisateur u = null;
		String sql = "SELECT id, nom, email,pwd FROM t_utilisateurs WHERE id=?";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setLong(1, id);

		ResultSet res = ps.executeQuery();
		if (res.next()) {
			u = new Utilisateur(res.getLong("id"), res.getString("nom"), res.getString("email"),
					res.getString("pwd"));
		}
		res.close();
		if (closeCnx)
			cnx.close();
		return u;
	}


	public static Utilisateur findByEmail(String email, Connection cnx, boolean closeCnx) throws Exception {
		Utilisateur u = null;
		String sql = "SELECT id, nom, email,pwd FROM t_utilisateurs WHERE email=?";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setString(1,email);

		ResultSet res = ps.executeQuery();
		if (res.next()) {
			u = new Utilisateur(res.getLong("id"), 
					res.getString("nom"), 
					res.getString("email"),
					res.getString("pwd"));
		}
		res.close();
		if (closeCnx)
			cnx.close();
		return u;
	}

	public static int insert(Utilisateur u, Connection cnx, boolean closeCnx) throws Exception {
		String sql = "INSERT INTO t_utilisateurs(nom, email,pwd) VALUES(?,?,?)";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setString(1,u.getNom());
		ps.setString(2,u.getEmail());
		ps.setString(3,u.getPwd());

		int res = ps.executeUpdate();
		if (closeCnx)
			cnx.close();
		return res;
	}

	public static int update(Utilisateur u, Connection cnx, boolean closeCnx) throws Exception {
		String sql = "UPDATE t_utilisateurs SET nom=?, email=?,pwd=? WHERE id=?";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setString(1,u.getNom());
		ps.setString(2,u.getEmail());
		ps.setString(3,u.getPwd());
		ps.setLong(4, u.getId());

		int res = ps.executeUpdate();
		if (closeCnx)
			cnx.close();
		return res;
	}

	public static int delete(long id, Connection cnx, boolean closeCnx) throws Exception {
		String sql = "DELETE FROM t_utilisateurs WHERE id=?";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setLong(1, id);

		int res = ps.executeUpdate();
		if (closeCnx)
			cnx.close();
		return res;
	}

	public static long count(Connection cnx, boolean closeCnx) throws Exception {
		long nb = 0;
		String sql = "SELECT COUNT(id) FROM t_utilisateurs";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ResultSet res = ps.executeQuery();
		if (res.next()) {
			nb = res.getLong(1);
		}
		res.close();
		if (closeCnx)
			cnx.close();
		return nb;
	}
}



