package fr.dawan.cart.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import fr.dawan.cart.bean.Cart;
import fr.dawan.cart.bean.Library;
import fr.dawan.cart.dao.CartDao;
import fr.dawan.cart.dao.ConnectionDB;
import fr.dawan.cart.dao.LibraryDao;
import fr.dawan.cart.dao.UserDao;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

@WebServlet(name = "CartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {

    private CartDao cartDao = new CartDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "connect":

                    if(!"".equals(request.getParameter("product_id"))) {
                        Cookie cookie = new Cookie("transmis", "ok");
                        response.addCookie(cookie);
                        request.setAttribute("idProduct", request.getParameter("product_id"));
                        
                        System.out.println("Recirection 1");
                        
                        response.sendRedirect("user?action=login&referer=addCard&product_id=" + request.getParameter("product_id"));
                        
                        
                    }
                    else {
                    	
                    	System.out.println("Recirection 2");
                    	
                        response.sendRedirect("user?action=login");
                    }
              break;


             case "add":
                    try{
                        Integer productId = Integer.parseInt(request.getParameter("product_id"));
                        Integer quantity = Integer.parseInt(request.getParameter( "quantity" ));
                        cartDao.addCart(request, productId, quantity, new java.util.Date(), ConnectionDB.getConnection(), false);
                    } catch (Exception e){
                    	e.getMessage();
                    }
                 request.setAttribute("title", UserDao.attributeTitle("" ));
                 
                 System.out.println("chemin : " + request.getContextPath());
                 
                 //response.sendRedirect("/07-Panier/");
                 response.sendRedirect( request.getContextPath() );
                 break;
            default:
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action != null){
            switch (action){
                case "removeCartCookie":
                    HttpSession session = request.getSession();
                    HashMap<Library, Integer> actualCartSession = (HashMap) session.getAttribute("cart");
                    try {
                        Cart.cartContent = actualCartSession;
                        request.getSession().setAttribute("cart", null);
                        request.getSession().setAttribute("amount", null);
                        request.getSession().setAttribute("panier", null);
                        request.setAttribute("title", UserDao.attributeTitle("Gestion des bibliothèques" ));
                        response.sendRedirect("/");
                    } catch(Exception e){

                    }
                    return;
                default:
            }
        }

        String update = request.getParameter("update");
        if(update != null){
            Integer id = 0, quantity = 0;
            quantity = Integer.parseInt(request.getParameter("quantity"));
            id = Integer.parseInt(request.getParameter("id"));
            HttpSession session = request.getSession();
            HashMap<Library, Integer> actualCartSession = (HashMap) session.getAttribute("cart");
                    try {
                        Library library = LibraryDao.findById(id, ConnectionDB.getConnection(), false);
                        Cart.cartContent = actualCartSession;

                        switch (update) {
                            case "modify":
                                System.out.println("Librairie"  + actualCartSession.get(library));
                                Cart.cartContent.put(library, quantity);
                                actualCartSession.put(library, quantity);
                                break;
                            case "delete":
                                Cart.cartContent.remove(library);
                                actualCartSession.remove(library);
                                break;

                            default:
                        }

                        Integer cookieSize= Cart.cartContent.size();
                        Double total = 0.0;
                        HashMap<Library, Integer> map = actualCartSession;
                        Set cles = map.keySet();
                        double price ;
                        Iterator it = cles.iterator();
                        while (it.hasNext()){
                            Object key = it.next();
                            Integer value = map.get(key);
                            Library library1 = (Library) key;
                            price = library1.getPrix();
                            double montant = (double) value;
                            total += (montant * price);
                        }

                        request.getSession().setAttribute("amount",total);
                        request.getSession().setAttribute("cart", actualCartSession);
                        request.getSession().setAttribute("panier", cookieSize);

                        if(cookieSize != 0) {
                            response.sendRedirect("cart?action=viewCart");


                            request.setAttribute("title", UserDao.attributeTitle("Votre panier sur DAWAN"));

                        } else {
                            request.setAttribute("title", UserDao.attributeTitle("" ));
                            
                            
                            
                            System.out.println("chemin : " + request.getContextPath());
                            
                            request.getRequestDispatcher("/").forward(request, response);
                        }
                        return;

                    } catch (Exception e){
                        System.out.println("Problème");
                        e.printStackTrace();
                    }

            System.out.println("Quantité : " + quantity + ", produit : " + id);
        }

        request.setAttribute("title", UserDao.attributeTitle("Votre panier sur DAWAN" ));
        request.setAttribute("action", "cart");
        HttpSession session = request.getSession();
        if(session.getAttribute("role") != null) {
            request.setAttribute("connecte", "oui");
            request.setAttribute("role", session.getAttribute("role"));
        }


        request.getRequestDispatcher("WEB-INF/views/cart.jsp").forward(request, response);
    }
}
