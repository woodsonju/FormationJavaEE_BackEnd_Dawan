package fr.dawan.cart.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.cart.bean.User;
import fr.dawan.cart.dao.ConnectionDB;
import fr.dawan.cart.dao.UserDao;

import java.io.IOException;

//on intercepte ici toutes les urls ayant /admin/*
@WebFilter(filterName = "UserFilter", urlPatterns = "/admin/*")
public class UserFilter implements Filter {
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String email = (String) req.getSession().getAttribute("email");
		User user = null;
		try {
			user = UserDao.findByEmail(email, ConnectionDB.getConnection(), false);
			if (user.getId() == 0) {
				System.out.println("Je suis redirigé par le filter vers la page de connexion");
				res.sendRedirect("user?action=login");
			} else if (user.getRole() == 3) { // || user.getRole() == 2
				chain.doFilter(request, response); //on le laisse passer
			} else {
				res.sendError(403);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void init(FilterConfig config) throws ServletException {

	}
}