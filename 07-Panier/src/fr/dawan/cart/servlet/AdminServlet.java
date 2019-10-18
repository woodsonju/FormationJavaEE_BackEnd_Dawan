package fr.dawan.cart.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.cart.bean.RoleEnum;
import fr.dawan.cart.bean.User;
import fr.dawan.cart.dao.ConnectionDB;
import fr.dawan.cart.dao.UserDao;


import java.util.HashMap;
import java.util.List;

@WebServlet(name = "AdminServlet", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // todo header.jsp : onbeforeload
        String action = request.getParameter("action");
        switch (action) {
            case "modification":
                Integer idUser = Integer.parseInt(request.getParameter("id"));
                Integer newRole = Integer.parseInt(request.getParameter("role"));
                System.out.println("Vous allez modifier les privilèges de l'utilisateur " + idUser);
                System.out.println("Il deviendra /" + newRole + "/");
                try {
                    UserDao.update(idUser, newRole, ConnectionDB.getConnection(), false);
                    response.sendRedirect( request.getContextPath() );
                } catch(Exception e){

                }

            return;
            default:
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	System.out.println("doGet du AdminServlet");

        /**
         * Initial Parameters
         */
        HashMap<Integer, String> rolesList = new HashMap<>();
        for(RoleEnum role : RoleEnum.values()){
            System.out.println("Ordinal : " + (role.ordinal() + 1) + ", name : " + role.name());
            rolesList.put(role.ordinal() + 1, role.name());
        }

        if(!request.getSession().getAttribute("forname").equals(""))
            request.setAttribute("connecte", "oui");
        else
            request.setAttribute("connecte", "non");
        request.setAttribute("action", "users");
        request.setAttribute("title", UserDao.attributeTitle("Administration User HomePage"));
        request.setAttribute("rolesList", rolesList);
        String action = (String) request.getAttribute("action");

        if(action != null ){
            switch (action){
                case "users" :
                    try {
                        List<User> userList = UserDao.findAll(ConnectionDB.getConnection(), false);
                        request.setAttribute("userList", userList);
                        System.out.println("UserList" + userList);
                        request.setAttribute("title", UserDao.attributeTitle("Administration Use Page"));
                    } catch(Exception e){

                    }
                    break;
                default:
            }
        }


        String action1 = request.getParameter("action1");
        if(action1 != null){
            switch (action1){
                case "deleteUser":
                    Integer id = Integer.parseInt(request.getParameter("id"));
                    try{
                        UserDao.delete(id, ConnectionDB.getConnection(), false);
                    } catch(Exception e){

                    }
                    response.sendRedirect("/07-Panier");
                    return;
                default:
            }
        }



        request.getRequestDispatcher("WEB-INF/views/admin.jsp?action=user").forward(request, response);
    }
}
