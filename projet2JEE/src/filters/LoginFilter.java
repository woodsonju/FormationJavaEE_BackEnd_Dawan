package filters;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, urlPatterns = { "/admin/*" })
public class LoginFilter implements Filter {

  
    public LoginFilter() {
    }

	public void destroy() {
	}

	/**
	 * On applique ici filter dans le cas où quelqu'un veut se connecter directement avec la page jsp (url ci-dessous)
	 * ex : Avec l'url http://localhost:8080/projet2JEE/admin/espace-admin.jsp
	 * Ici, avec le filter quand il  essaye de se connecter en tant qu'admin il est rédirigé vers la page login.jsp
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		//On vérifie que l'utilisateur s'est bien connecté correctement, en rentrant son login et son mot de passe, et non frauduleusement.
		Object obj = req.getSession().getAttribute("userConnected");
		if(obj==null) {
			//user non connecté
			request.setAttribute("msg", "Vous devez vous authentifier");
			// /login.jsp car on veut revenir à la racine(http://localhost:8080/projet2JEE/login) 
			// Sinon on reste  sur http://localhost:8080/projet2JEE/admin/login et génère un boucle infini
			request.getRequestDispatcher("/login.jsp").forward(request, response); 
		} else {
			chain.doFilter(request, response);
		}
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}
