package fr.dawan.cart.dao;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import fr.dawan.cart.bean.Library;


public class LibraryDao {

    public int sum(int a, int b){
        return a + b;
    }

    public static String reduce(String text, Integer maxCharactersNumber){

        String result;
        if(text.length() < maxCharactersNumber) {
            result = text;
        }else {
            result = text.substring(0, maxCharactersNumber) + "...";
        }
        return result;
    }

    public static long count(Connection cnx, boolean closeCnx) throws Exception {
        long nb = 0;
        String sql = "SELECT COUNT(id) FROM livre";
        PreparedStatement st = cnx.prepareStatement(sql);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            nb = rs.getInt(1);
        }
        rs.close();

        if (closeCnx)
            cnx.close();

        return nb;
    }


    public static Library findById(int id, Connection cnx, boolean closeCnx) throws Exception {
        Library library = new Library();
        String sql = "SELECT * FROM livre WHERE id=?";
        PreparedStatement st = cnx.prepareStatement(sql);
        st.setInt(1, id);
        ResultSet resultSet = st.executeQuery();

        if (resultSet.next()) {
            library.setAuteur(resultSet.getString("auteur"));
            library.setTitre(resultSet.getString("titre"));
            library.setIsbn(resultSet.getString("isbn"));
            library.setAnneeSortie(resultSet.getString("annee"));
            library.setDisponible(resultSet.getBoolean("disponible"));
            library.setSynopsis(resultSet.getString("synopsis"));
            library.setDateAchat(resultSet.getDate("dateAchat"));
            library.setDomaine(resultSet.getString("genre"));
            library.setDescription(resultSet.getString("description"));
            library.setPrix(resultSet.getDouble("prix"));
            library.setLangue(resultSet.getString("langue"));
            library.setId(resultSet.getInt("id"));
            library.setStar(resultSet.getBoolean("star"));
        }
        resultSet.close();

        if (closeCnx)
            cnx.close();

        return library;
    }


    public static List<Library> findAll(int start, int length, Connection connection, Boolean willBeClosed) throws Exception {
        List<Library> listeLibraries = new ArrayList<>();
        try{
            String mySql = "SELECT * FROM livre LIMIT ?, ?";
            PreparedStatement stmt = connection.prepareStatement(mySql);
            stmt.setInt(1, start);
            stmt.setInt(2, length);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Library library = new Library();
                library.setAuteur(resultSet.getString("auteur"));
                library.setTitre(resultSet.getString("titre"));
                library.setIsbn(resultSet.getString("isbn"));
                library.setAnneeSortie(resultSet.getString("annee"));
                library.setDisponible(resultSet.getBoolean("disponible"));
                library.setSynopsis(resultSet.getString("synopsis"));
                library.setDateAchat(resultSet.getDate("dateAchat"));
                library.setDomaine(resultSet.getString("genre"));
                library.setDescription(resultSet.getString("description"));
                library.setPrix(resultSet.getDouble("prix"));
                library.setLangue(resultSet.getString("langue"));
                library.setId(resultSet.getInt("id"));
                library.setStar(resultSet.getBoolean("star"));
                listeLibraries.add(library);
            }

        } catch(Exception e){

        }
        if (willBeClosed)
            connection.close();
        return listeLibraries;
    }


    public static List<Library> findAll(Connection connection, Boolean willBeClosed) throws Exception {
        List<Library> listeLibraries = new ArrayList<>();
        try{
            String mySql = "SELECT * FROM livre";
            PreparedStatement stmt = connection.prepareStatement(mySql);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Library library = new Library();
                library.setAuteur(resultSet.getString("auteur"));
                library.setTitre(resultSet.getString("titre"));
                library.setIsbn(resultSet.getString("isbn"));
                library.setAnneeSortie(resultSet.getString("annee"));
                library.setDisponible(resultSet.getBoolean("disponible"));
                library.setSynopsis(resultSet.getString("synopsis"));
                library.setDateAchat(resultSet.getDate("dateAchat"));
                library.setDomaine(resultSet.getString("genre"));
                library.setDescription(resultSet.getString("description"));
                library.setPrix(resultSet.getDouble("prix"));
                library.setLangue(resultSet.getString("langue"));
                library.setId(resultSet.getInt("id"));
                listeLibraries.add(library);
                library.setStar(resultSet.getBoolean("star"));
            }

        } catch(Exception e){

        }
        if (willBeClosed)
            connection.close();
        return listeLibraries;
    }




    public static int insert(Library library, String fileName, Connection cnx, boolean closeCnx) throws Exception {
        System.setProperty( "file.encoding", "UTF-8" );
        int lastInsertId = -1;
        PreparedStatement ps = cnx.prepareStatement(
                "INSERT INTO livre(titre,auteur,langue,isbn,annee,dateAchat,genre,synopsis,disponible,prix) VALUES(?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, library.getTitre().trim());
        ps.setString(2, library.getAuteur().trim());
        ps.setString(3, library.getLangue().trim());
        ps.setString(4, library.getIsbn().trim());
        ps.setString(5, library.getAnneeSortie());
        ps.setDate(6, new java.sql.Date(library.getDateAchat().getTime()));
        ps.setString(7, library.getDomaine());
        ps.setString(8, library.getSynopsis().trim().trim());
        ps.setBoolean(9, true);
        ps.setDouble(10, library.getPrix());
        int resultInsert = ps.executeUpdate();
        if (resultInsert != 0) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                library.setId(rs.getInt(1));
                lastInsertId = library.getId();
                ps = cnx.prepareStatement("UPDATE livre SET description = ? WHERE ID = ?");
                ps.setString(1, fileName);
                ps.setInt(2,lastInsertId);
                int imageInsert = ps.executeUpdate();
            }

        } else {
            System.out.println("Problème d'insertion");
        }

        if (closeCnx)
            cnx.close();

        return lastInsertId;
    }


    public static void makeAStar(Library library, Connection connection, boolean willBeClosed) throws Exception {
        int resultSet = 0, id = library.getId();
        PreparedStatement stmt = connection.prepareStatement(
                "UPDATE livre SET star = ? ;");
        stmt.setBoolean(1, false);
        stmt.executeUpdate(); // TODO quelles sont les différences réelles entre executeUpdate, executeQuery, execute, etc.


        PreparedStatement stmt1 = connection.prepareStatement(
                "UPDATE livre SET star = ? WHERE id = ?");
        stmt1.setBoolean(1, true);
        stmt1.setInt(2, id);
        stmt1.executeUpdate();

        if (willBeClosed)
            connection.close();
    }

    public static int update(Library library, Integer id, Connection connection, Boolean willBeClosed) throws Exception {
        PreparedStatement ps = connection.prepareStatement("UPDATE livre SET titre=?, auteur=?, prix=? WHERE id=?");
        ps.setString(1, library.getTitre().trim());
        ps.setString(2, library.getAuteur().trim());
        ps.setDouble(3, library.getPrix());
        ps.setInt(4, id);
        int resultSet = ps.executeUpdate();

        if (willBeClosed)
            connection.close();
        return resultSet;
    }




    public static int delete(Integer id, Connection connection, Boolean willBeClosed) throws Exception {
        PreparedStatement ps = connection.prepareStatement("DELETE FROM livre WHERE id=?");
        ps.setInt(1, id);
        int resultSet = ps.executeUpdate();
        if (willBeClosed)
            connection.close();
        return resultSet;
    }
}
