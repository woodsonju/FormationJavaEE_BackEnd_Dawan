package fr.dawan.cart.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.cart.bean.User;
import fr.dawan.cart.dao.ConnectionDB;
import fr.dawan.cart.dao.UserDao;


@WebFilter("/admin")
public class UserFilter implements Filter {


    public UserFilter() {
    }

	
//	public void destroy() {
//	}

	
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    		throws ServletException, IOException {
    	HttpServletRequest req = (HttpServletRequest) request;
    	HttpServletResponse res = (HttpServletResponse) response;
    	// définition de la session dont le nom est email
    	String email = (String) req.getSession().getAttribute("email");
    	User user = null;
    	try {
    		user = UserDao.findByEmail(email, ConnectionDB.getConnection(), false);
    		if (user.getId() == 0) { // Si l'utilisateur n'est pas connecté
    			System.out.println("Je suis redirigé par le filter vers la page de connexion");
    			res.sendRedirect("user?action=login");
    		} else if (user.getRole() == 3) { // Si l'utilisateur est administrateur
    			chain.doFilter(request, response); //on le laisse passer
    		} else {
    			// sinon on ne laisse pas passer
    			res.sendError(403);
    		}

    	} catch (Exception e) {
    		e.printStackTrace();
    	}

    }

	
//	public void init(FilterConfig fConfig) throws ServletException {
//	}

}
