package fr.dawan.cart.bean;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Cart implements Serializable {


    public static HashMap<Library, Integer> cartContent;


    public Cart() {
        this.cartContent = new HashMap<Library, Integer>();
    }

    public void insert(HttpServletRequest request, Library library, int quantity) {
        if(cartContent.get(library) != null) {
            quantity += cartContent.get(library).intValue();
            cartContent.remove(library);
        }
        cartContent.put(library, quantity);
        System.out.println("Modification de la session");
        request.getSession().setAttribute("cart", cartContent);

    }

    public void empty() {
        cartContent.clear();
    }

    public double cartContents(String action) {
        double total = 0;
        Iterator<Map.Entry<Library, Integer>> il = this.cartContent.entrySet().iterator();
        while (il.hasNext()) {
            Map.Entry<Library, Integer> entry = il.next();
            switch (action){
                case "price" :
                    total += entry.getKey().getPrix() * entry.getValue();
                    break;
                case "number":
                    total += entry.getValue();
                    break;
                default:
                    total = 0;
            }
        }
        return total;
    }
}

