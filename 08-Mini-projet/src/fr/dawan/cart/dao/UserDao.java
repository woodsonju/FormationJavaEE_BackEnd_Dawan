package fr.dawan.cart.dao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import fr.dawan.cart.bean.User;

public class UserDao {
	private static String bytesToHex(byte[] hash) {
		
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
 
    private static String hashPassword(String password){
        String hexHashedPassword = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] psw = messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
            hexHashedPassword = bytesToHex(psw);
        }catch(Exception e){
 
        }
        return hexHashedPassword;
    }
 
    public static String attributeTitle(String pageTitle ){
        String result = pageTitle;
        Properties p = new Properties();
        try {
            p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("resources/application.properties"));
            String dawanTitle = p.getProperty("title");
            if(!"".equals(pageTitle))
                result = LibraryDao.reduce(pageTitle, 20) + " - " + dawanTitle;
            else
                result = dawanTitle;
        } catch(Exception e){
 
        }
        return result;
    }
 
    public static Boolean pswAndLoginMatche(String email, String typedPassword, Connection cnx, boolean willConnectionClosed) throws Exception {
        Boolean result = true;
        PreparedStatement stmt = cnx.prepareStatement(
                "SELECT * FROM utilisateur WHERE email = ?");
        stmt.setString(1, email);
        ResultSet resultSet = stmt.executeQuery();
        while (resultSet.next()) {
            String oldPassword = resultSet.getString("mdpMD5");
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] psw1 = messageDigest.digest(typedPassword.getBytes(StandardCharsets.UTF_8));
            String oldHexHashedPassword1 = bytesToHex(psw1);
            if(!oldPassword.equals(oldHexHashedPassword1)) {
                result = false;
            }
        }
        return result;
    }
 
    public static List<User> findAll(Connection connection, boolean willBeClosed) throws Exception {
        List<User> list = new ArrayList<>();
        String mySql = "SELECT * FROM utilisateur";
 
        PreparedStatement stmt = connection.prepareStatement(mySql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            User u = new User();
            u.setId(rs.getInt("id"));
            u.setForeName(rs.getString("prenom"));
            u.setEmail(rs.getString("email"));
            u.setDate(rs.getDate("date"));
            u.setRole(rs.getInt("role"));
            u.setPassword(rs.getString("mdpMD5"));
            u.setValidation(rs.getBoolean("validation"));
            list.add(u);
 
 
        }
        rs.close();
        if (willBeClosed)
            connection.close();
 
        return list;
    }
 
    public static User findByEmail(String email, Connection cnx, boolean closeCnx) throws Exception {
        User u = new User();
        PreparedStatement stmt = cnx.prepareStatement(
                "SELECT * FROM utilisateur WHERE email = ?");
        stmt.setString(1, email);
        ResultSet rs = stmt.executeQuery();
 
 
        if (rs.next()) {
            u.setId(rs.getInt("id"));
            u.setForeName(rs.getString("prenom"));
            u.setEmail(rs.getString("email"));
            u.setDate(rs.getDate("date"));
            u.setRole(rs.getInt("role"));
            u.setPassword(rs.getString("mdpMD5"));
            u.setValidation(rs.getBoolean("validation"));
 
        }
        rs.close();
        if (closeCnx)
            cnx.close();
 
        return u;
    }
 
    public static Boolean doesEmailExist(String email, Connection cnx, boolean willConnectionClosed) throws Exception {
        Boolean result = false;
        int nb = 0;
        PreparedStatement stmt = cnx.prepareStatement(
                "SELECT * FROM utilisateur WHERE email = ?");
        stmt.setString(1, email);
        ResultSet rs = stmt.executeQuery();
 
        if (rs.next()) {
            nb = rs.getInt(1);
        }
        if(nb > 0) result = true;
        if (willConnectionClosed)
            cnx.close();
        return result;
    }
 
    public static int insert(User user, Connection cnx, boolean willConnectionClosed) throws Exception {
        System.setProperty("file.encoding", "UTF-8");
        String password = user.getPassword();
        Date now = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(now);
        password = hashPassword(password);
        PreparedStatement stmt = cnx.prepareStatement(
                "INSERT INTO `utilisateur` (`prenom`,`mdpMD5`,`email`,`date`,`role`, `validation`) VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, user.getForeName().trim());
        stmt.setString(2, password);
        stmt.setString(3, user.getEmail().trim());
        stmt.setString(4, date);
        stmt.setInt(5, user.getRole());
        stmt.setBoolean(6, false);
        int resultSet = stmt.executeUpdate();
        if (willConnectionClosed)
            cnx.close();
        return resultSet;
    }
 
 
    public static int delete(Integer id, Connection connection, Boolean willBeClosed) throws Exception {
        PreparedStatement ps = connection.prepareStatement("DELETE FROM utilisateur WHERE id=?");
        ps.setInt(1, id);
        int resultSet = ps.executeUpdate();
        if (willBeClosed)
            connection.close();
        return resultSet;
    }
 
    public static int update(Integer id, Integer role, Connection connection, Boolean willBeClosed) throws Exception {
        PreparedStatement ps = connection.prepareStatement("UPDATE utilisateur SET role=? WHERE id=?");
        ps.setInt(1, role);
        ps.setInt(2, id);
        int resultSet = ps.executeUpdate();
 
        if (willBeClosed)
            connection.close();
        return resultSet;
    }
    
    
    
    public static int update(User user, Connection connection, Boolean willBeClosed) throws Exception {
        PreparedStatement ps = connection.prepareStatement("UPDATE utilisateur SET validation=? WHERE id=?");
        ps.setBoolean(1, true );
        ps.setInt(2, user.getId());
        int resultSet = ps.executeUpdate();
 
        if (willBeClosed)
            connection.close();
        return resultSet;
    }
    
    
 
    public static String hash(String word){
        String hash = "";
        for(int i = word.length()-1 ; i>=0 ; i--){
            hash += Integer.toString((byte)((int) word.charAt(i) / 16 * 10 + (int) word.charAt(i) % 16));
        }
        return hash;
    }
 
    
    public static void sendEmail(String from, String to, String subject, String htmlContent) throws  Exception {
 
        final String username = "hrabesiaka@jehann.fr";
        final String password = "unMotDePasse";
        String host = "smtp.orange.fr";
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "465 ");
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {return new PasswordAuthentication(username, password);}
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setContent( htmlContent,"text/html");
         
            
            /**
             * Encodage UTF-8 du corps du message.
             */
            message.setHeader("Content-Type", "text/html; charset=UTF-8");
            
            session.setDebug(true);
            Transport.send(message);
        } catch (Exception e) {
            System.out.println("Problème");
            e.printStackTrace();
        }
    
       }
}
