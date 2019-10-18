package fr.dawan.cart.dao;

import javax.servlet.http.HttpServletRequest;

import fr.dawan.cart.bean.Cart;
import fr.dawan.cart.bean.Library;

import java.sql.Connection;
import java.util.Date;

public class CartDao {
    static Cart cart = new Cart();
    public static void addCart(HttpServletRequest request, Integer product_id, Integer quantity, Date today, Connection connection, Boolean willBuClosed)  throws  Exception {
    	
    	System.out.println("Méthode d'ajout de la session panier");
    	
        Library library = LibraryDao.findById( product_id , connection, false );
        cart.insert(request, library, quantity);
        request.getSession().setAttribute("panier", (int) cart.cartContents("number"));
        request.getSession().setAttribute("amount", (double) cart.cartContents("price"));
    }
}
