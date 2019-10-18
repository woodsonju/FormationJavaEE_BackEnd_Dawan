package fr.dawan.cart.listeners;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MySessionListener
 *
 */
//@WebListener
public class MySessionListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public MySessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  {
    	
    	 ServletContext application = se.getSession().getServletContext();
         
        
         System.out.println("ici");
         
         int nbVisitors = 1;
         if(application.getAttribute("nbVisitors")!=null) {
        	 nbVisitors = ((Integer)application.getAttribute("nbVisitors"))+1;
         }
         application.setAttribute("nbVisitors", nbVisitors);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  {
    	
    	System.out.println();System.out.println();System.out.println();System.out.println("session destroyed");System.out.println();System.out.println();System.out.println();
    	
    	ServletContext application = se.getSession().getServletContext();
        if(application.getAttribute("nbVisitors")!=null) {
       	 int nbVisitors = ((Integer)application.getAttribute("nbVisitors"))-1;
       	 application.setAttribute("nbVisitors", nbVisitors);
       	 
       	System.out.println("nombre de visiteurs : " + application.getAttribute("nbVisitors"));
       	 
        }
    }
	
}
