package fr.dawan.cart.servlet;

import java.util.HashMap;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import fr.dawan.cart.bean.Cart;
import fr.dawan.cart.bean.RoleEnum;
import fr.dawan.cart.bean.User;
import fr.dawan.cart.dao.ConnectionDB;
import fr.dawan.cart.dao.UserDao;
import fr.dawan.cart.validator.UserValidator;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;


@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {




    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<Integer, String> roles = new HashMap<>();
        for(RoleEnum role : RoleEnum.values()){

            roles.put(role.ordinal() + 1, role.name());
        }
        request.setAttribute("roles", roles);
        Connection connection = null;
        String forename = request.getParameter("forename");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String password1 = request.getParameter("password1");
        String phone = request.getParameter("phone");
        switch( request.getParameter("action") ){
            case "addUser":
            	System.out.println("Je suis dans addUser");
                User user = new User();
                user.setForeName(forename);
                user.setEmail(email);
                user.setPassword(password);
                user.setRole(Integer.parseInt(request.getParameter("role")));


                String userValidator = UserValidator.userValidator(user, password1);

                if(!userValidator.equals("")){
                    request.setAttribute("forename", forename);
                    request.setAttribute("email", email);
                    request.setAttribute("password", password);
                    request.setAttribute("phone", phone);
                    request.setAttribute("requestRole", role);
                    if(userValidator.contains("forename"))
                        request.setAttribute("forenameMessage", "Le champ prénom est obligatoire");
                    if(userValidator.contains("emailNotNull"))
                        request.setAttribute("messageEmail", "Le champ ne peut pas être vide");
                    if(userValidator.contains("invalidEmail"))
                        request.setAttribute("messageEmail", "Format incorrect de l'adresse e-mail");
                    if(userValidator.contains("password"))
                        request.setAttribute("messagePassword", "Le mot de passe est obligatoire");
                    if(userValidator.contains("errorPasswordConfirmation"))
                        request.setAttribute("messagePassword1", "Les deux mots de passe ne correspondent pas");
                    if(userValidator.contains("alreadyExistMail"))
                        request.setAttribute("messageEmail" , "Cet e-mail est déjà enregistré dans la base de données !");
                    request.setAttribute("action", "signUp");
                    request.setAttribute("title", UserDao.attributeTitle("Sign Up"));
                    doGet(request, response);
                    return;
                } else {
                    try {
                        connection = ConnectionDB.getConnection();
                        String rand = UserDao.hash(user.getForeName() + "_" +  user.getEmail());
                        UserDao.sendEmail("hrabesiaka@gmail.com",user.getEmail(), "Votre compte sur Dawan", "<h1>Bienvenu sur DAWAN</h1><p><br /><br />"+ user.getForeName() + ", <br /></p><br />Bienvenu sur le site de Dawan, veuillez cliquer <a href='http://localhost:8080/07-Panier?users/action=activateUser&rand="+rand + "'>ici</a> pour activer votre compte.<p><p>Cordialement,</p><p>L'<b>&eacute;quipe.</b></p>");
                        UserDao.insert(user, connection, false);
                        response.sendRedirect( request.getContextPath() );
                    } catch(Exception e){

                    }
                }
                break;
            case "login":
                userValidator = UserValidator.userValidator(email, password);
                if(!userValidator.equals("")){
                    request.setAttribute("password", password);
                    request.setAttribute("email", email);
                    if(userValidator.contains("emailNotNull"))
                        request.setAttribute("messagePassword", "Le mot de passe est obligatoire");
                    if(userValidator.contains("invalidEmail"))
                        request.setAttribute("messageEmail", "Format incorrect de l'adresse e-mail");
                    if(userValidator.contains("password"))
                        request.setAttribute("messagePassword", "Le mot de passe est obligatoire");
                    if(userValidator.contains("EmailAndPasswordNotCorrespondant")) {
                        request.setAttribute("messagePassword", "Mot de passe incorrect");
                        request.setAttribute("password", "");
                    }
                    doGet(request, response);
                    return;
                }

                try {
                    User client = UserDao.findByEmail(request.getParameter("email"), ConnectionDB.getConnection(), false);
                    if(client.getForeName() != null) {
                        HttpSession session = request.getSession();
                        session.setAttribute("id", client.getId());
                        session.setAttribute("forname", client.getForeName());

                        session.setAttribute("password", client.getPassword());
                        session.setAttribute("date", client.getDate());
                        session.setAttribute("role", client.getRole());
                        session.setAttribute("validation", client.getValidation());
                        session.setAttribute("email", client.getEmail());
                        session.setAttribute("user", client);
                        
                        request.setAttribute("connecte", "oui");
                        
                        System.out.println("Session utilisateur initialisée.");
                        
                        
                    } else {
                        request.setAttribute("messagePassword", "Cet e-mail ne figure pas dans la base de données");
                        doGet(request, response);
                        return;
                    }
                } catch (Exception e){
                    System.out.println("Email non trouvé");
                    e.printStackTrace();
                }

                request.setAttribute("title", UserDao.attributeTitle(""));

                String idProduct = (String) request.getParameter("idProduct");
                
                System.out.println("idProduct = " + idProduct);
                

                if(!"".equals(idProduct)) {
                    request.setAttribute("idProduct", idProduct);
                    response.sendRedirect( request.getContextPath() );
                } else {
                    response.sendRedirect( request.getContextPath() );
                }
                break;
            default:

                break;
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * First Attribute for SignUp Form
         */
    	
    	System.out.println("doGet du UserServlet");

        switch( request.getParameter("action") ) {
        
        
        	case "addBook":
        		request.setAttribute("action", "addBook");
        		break;
        
            case "signUp":
                request.setAttribute("action", "signUp");
                request.setAttribute("title", UserDao.attributeTitle("Sign Up"));
                HashMap<Integer, String> roles = new HashMap<>();
                for(RoleEnum role : RoleEnum.values()){

                    roles.put(role.ordinal() + 1, role.name());
                }
                request.setAttribute("roles", roles);
                break;
            case "login":
                String parameter = request.getParameter("product_id");
                request.setAttribute("idProduct", parameter);
                request.setAttribute("action", "login");
                request.setAttribute("title", UserDao.attributeTitle("Log In"));
                
                System.out.println("Je suis dans login, paramètre : " + parameter);
                
                break;


            case "deconnect":
                request.setAttribute("title", UserDao.attributeTitle(""));
                Cart cart = new Cart();
                cart.empty();
                request.getSession().invalidate();
                response.sendRedirect("/07-Panier");
                return;
                
                
            case "activateUser":
            	String rand = request.getParameter("rand");
            	System.out.println("RAND = " + rand);
            	
            	try {
            	Connection cnx = ConnectionDB.getConnection();
            	List<User> utilisateurs = UserDao.findAll( cnx , false);
                for(User connectingUser : utilisateurs){
                	
                	//UserDao.hash(user.getForeName() + "_" +  user.getEmail());
                	
                    if(UserDao.hash(connectingUser.getForeName() + "_" + connectingUser.getEmail()).equals( rand )){
                        System.out.println(connectingUser.getEmail() + " " + connectingUser.getForeName() + " " + connectingUser.getRole());
                        connectingUser.setValidation(true);
                        //UserDao.(connectingUser);
                        
                        
                        UserDao.update(connectingUser, cnx, true);
                        HttpSession session = request.getSession();
                        session.setAttribute("NOM", connectingUser.getForeName());
                        session.setAttribute("forename", connectingUser.getForeName());
                        session.setAttribute("EMAIL", connectingUser.getEmail());
                        session.setAttribute("TELEPHONE", connectingUser.getPhoneNumber());
                        session.setAttribute("DATEINSCRIPTION", connectingUser.getDate());
                        session.setAttribute("PRIVILEGE", connectingUser.getRole());
                    }
                } 
                } catch(Exception e) {
                	e.printStackTrace();
                }
            	
            	
            	
            	
            	break;
            default:
                break;
        }

        request.getRequestDispatcher("WEB-INF/views/user.jsp").forward(request, response);
    }
}

