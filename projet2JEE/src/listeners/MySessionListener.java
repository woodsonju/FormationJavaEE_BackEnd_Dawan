package listeners;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class MySessionListener implements HttpSessionListener {
	
    public MySessionListener() {
    }


    public void sessionCreated(HttpSessionEvent se)  {
    	ServletContext app = se.getSession().getServletContext();
    	int nb = 1;
    	//Dans le cas où il y a déjà des visiteurs on les récupèrent
    	//On utilise getAtribute car on récupère un objet
    	Object obj = app.getAttribute("nbVisiteurs");  
    	if(obj != null)
    			nb = ((Integer)obj) +1;
    	app.setAttribute("nbVisiteurs", nb);
    }
    

	
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	ServletContext app = se.getSession().getServletContext();
    	Object obj = app.getAttribute("nbVisiteurs");
    	int nb = ((Integer)obj) - 1;
    	app.setAttribute("nbVisiteurs", nb);
    }
	
}
