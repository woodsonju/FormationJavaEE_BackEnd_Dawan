package fr.dawan.cart.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.text.Collator;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.dawan.cart.bean.Library;
import fr.dawan.cart.bean.RoleEnum;
import fr.dawan.cart.bean.User;
import fr.dawan.cart.dao.ConnectionDB;
import fr.dawan.cart.dao.LibraryDao;
import fr.dawan.cart.dao.UserDao;


@WebServlet("")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger LOGGER = LogManager.getLogger(HomeServlet.class.getName());
	
    public HomeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("mon premier log");
		LOGGER.info("je suis dans HomeController.java");
		
		boolean titled = false;
		/**
         * Initial Parameters
         */
        HashMap<Integer, String> rolesList = new HashMap<>();
        for(RoleEnum role : RoleEnum.values()){
            LOGGER.info("Ordinal : " + (role.ordinal() + 1) + ", name : " + role.name());
            rolesList.put(role.ordinal() + 1, role.name());
        }

        if(request.getSession().getAttribute("forname") != null)
            request.setAttribute("connecte", "oui");
        else
            request.setAttribute("connecte", "non");
        
        
        
        
        
        if( request.getParameter("action") == null ) {
        	request.setAttribute("action", "users");
        	LOGGER.info("doGet de HomeServlet");
        	
        	
        	Connection cnx = null;
        	
        	try {
        		cnx = ConnectionDB.getConnection();
        	

            long count = LibraryDao.count(cnx, false);


            int page = 1;
            int length = 3;

            try {
                page = Integer.parseInt(request.getParameter("page"));
                length = Integer.parseInt(request.getParameter("length"));
            } catch (Exception e) {

            }

            try {

                boolean suivExist = (page * length) < LibraryDao.count(cnx, false);
                request.setAttribute("suivExist", suivExist);

                request.setAttribute("page", page);
                request.setAttribute("length", length);

                int start = (page - 1) * length;

                // TODO recharger dynamiquement les ressources
                //List<Library> listeLibraries = LibraryDao.findAll(cnx, false);

                /**
                 * Actualisation dynamique des ressources (images)
                 */

                /*
                for(Library livre : listeLibraries){
                    String imagePath = "/description/" + livre.getImage();


                    Drawable drawable = null ;
                    try {
                        // Recuperation de l'URL a partir de sa representation sous forme de String.
                        URL URL = new URL ( imagePath );
                        // Ouverture de l'inputStream associe a cette URL pour sa lecture.
                        InputStream is = (InputStream) URL .getContent();
                        // Construction du Drawable à partir de ce flux entrant.
                        drawable = Drawable. createFromStream ( is , "src" );
                    } catch (IOException e ) {
                        System.out.println("Erreur de chargement de l'image");
                    }

                }
                */
                List<Library> listeLibraries = LibraryDao.findAll(start, length, cnx, false);
                
                
                
                
                
                
                
                List<Library> listeLivres1 = LibraryDao.findAll(cnx, false);
                
                
                /*
                 System.out.println("LISTE DE TOUS LES LIVRES");
                for(Library livre : listeLivres1) {
                	System.out.println(livre.getTitre() + "-" + livre.getAuteur());
                }
                 */


                for(Library library : listeLivres1){
                    library.setTitre(LibraryDao.reduce(library.getTitre(), 25));
                    if(!library.isStar()) {
                            library.setSynopsis(LibraryDao.reduce(library.getSynopsis(), 200));
                    } else {
                        library.setSynopsis(LibraryDao.reduce(library.getSynopsis(), 500));
                    }
                }


                String product = request.getParameter("product");
                if(product != null){
                    System.out.println("Je suis dans LibraryServlet.java");

                    Library library = LibraryDao.findById(Integer.parseInt(product), ConnectionDB.getConnection(), false);

                    System.out.println("Le livre : " + library);
                    request.setAttribute("library", library);



                    request.setAttribute("title", UserDao.attributeTitle(library.getTitre()));
                    titled = true;

                }




                request.setAttribute("completeList", listeLivres1);
                request.setAttribute("liste", listeLibraries);
                request.setAttribute("page", request.getAttribute("page"));
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("msg", "Erreur : " + e.getMessage());
            }
        	
        	} catch(Exception e) {
        		
        	}
        	
        	
        	
        	
        	
        	
        	
        	
        	
        } else {
        	
        	try{
        		Integer id = null;
        		String titre = "";
        		String auteur = "";
        		Double prix = 0.0;
                Connection cnx = ConnectionDB.getConnection();
                String plus = request.getParameter("plus");
                if(request.getParameter("id") != null) id = Integer.parseInt(request.getParameter("id"));
                if(request.getParameter("titre") != null) titre = (String) request.getParameter("titre");
                if(request.getParameter("auteur") != null) auteur = (String) request.getParameter("auteur");
                if(request.getParameter("prix") != null) prix = Double.parseDouble(request.getParameter("prix"));
                
                
                
                System.out.println("=========================> plus = " + plus);
                
                
                switch (plus){
                    case "modifier":
                        Library library = new Library();
                        library.setTitre(titre);
                        library.setAuteur(auteur);
                        library.setPrix(prix);
                        LibraryDao.update(library, id, cnx, true);
                        response.sendRedirect(request.getContextPath()  + "/?action=addBook&page=" + request.getAttribute("page"));
                        return;
                    case "supprimer":
                        LibraryDao.delete(id, cnx, true);
                        response.sendRedirect(request.getContextPath()  + "?action=addBook&page=" + request.getAttribute("page"));
                        return;
                    case "voir":
                        break;
                    default:

                }

            } catch (Exception e){

            }
        	
        	
        	
        	switch( request.getParameter("action") ) {
        	case "addBook": 
        		request.setAttribute("action", "addBook");
        		
        		
        		System.out.println("doGet du LibraryServlet");
            	
            	request.setAttribute( "action" , "addBook");
            	
                titled = false;
                try {

                    HttpSession session = request.getSession();
                    if(session.getAttribute("role") != null) {
                        request.setAttribute("connecte", "oui");
                        request.setAttribute("role", session.getAttribute("role"));
                    }


                    Connection cnx = ConnectionDB.getConnection();

                    long count = LibraryDao.count(cnx, false);


                    int page = 1;
                    int length = 3;

                    try {
                        page = Integer.parseInt(request.getParameter("page"));
                        length = Integer.parseInt(request.getParameter("length"));
                    } catch (Exception e) {

                    }

                    try {

                        boolean suivExist = (page * length) < LibraryDao.count(cnx, false);
                        request.setAttribute("suivExist", suivExist);

                        request.setAttribute("page", page);
                        request.setAttribute("length", length);

                        int start = (page - 1) * length;

                        // TODO recharger dynamiquement les ressources
                        //List<Library> listeLibraries = LibraryDao.findAll(cnx, false);

                        /**
                         * Actualisation dynamique des ressources (images)
                         */

                        /*
                        for(Library livre : listeLibraries){
                            String imagePath = "/description/" + livre.getImage();


                            Drawable drawable = null ;
                            try {
                                // Recuperation de l'URL a partir de sa representation sous forme de String.
                                URL URL = new URL ( imagePath );
                                // Ouverture de l'inputStream associe a cette URL pour sa lecture.
                                InputStream is = (InputStream) URL .getContent();
                                // Construction du Drawable à partir de ce flux entrant.
                                drawable = Drawable. createFromStream ( is , "src" );
                            } catch (IOException e ) {
                                System.out.println("Erreur de chargement de l'image");
                            }

                        }
                        */
                        List<Library> listeLibraries = LibraryDao.findAll(start, length, cnx, false);
                        
                        
                        
                        
                        
                        
                        
                        List<Library> listeLivres1 = LibraryDao.findAll(cnx, false);
                        
                        
                        /*
                         System.out.println("LISTE DE TOUS LES LIVRES");
                        for(Library livre : listeLivres1) {
                        	System.out.println(livre.getTitre() + "-" + livre.getAuteur());
                        }
                         */


                        for(Library library : listeLivres1){
                            library.setTitre(LibraryDao.reduce(library.getTitre(), 25));
                            if(!library.isStar()) {
                                    library.setSynopsis(LibraryDao.reduce(library.getSynopsis(), 200));
                            } else {
                                library.setSynopsis(LibraryDao.reduce(library.getSynopsis(), 500));
                            }
                        }


                        String product = request.getParameter("product");
                        if(product != null){
                            System.out.println("Je suis dans LibraryServlet.java");

                            Library library = LibraryDao.findById(Integer.parseInt(product), ConnectionDB.getConnection(), false);

                            System.out.println("Le livre : " + library);
                            request.setAttribute("library", library);



                            request.setAttribute("title", UserDao.attributeTitle(library.getTitre()));
                            titled = true;

                        }




                        request.setAttribute("completeList", listeLivres1);
                        request.setAttribute("liste", listeLibraries);
                        request.setAttribute("page", request.getAttribute("page"));
                    } catch (Exception e) {
                        e.printStackTrace();
                        request.setAttribute("msg", "Erreur : " + e.getMessage());
                    }




                    String action = "";
                    if (request.getParameter("action") != null && !request.getParameter("action").equals("")) {
                        action = (String) request.getParameter("action");
                    }
                    Date now = new java.util.Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String strDate = sdf.format(now);

                    request.setAttribute("now", strDate);
                    request.setAttribute("action", action);

                    response.setHeader("content-language", "en");


                    if(!titled) request.setAttribute("title", UserDao.attributeTitle(""));



                    request.setAttribute("prenom", "Haja");



                    ArrayList<String> listeGenres = new ArrayList<>();
                    ArrayList<String> listeLangues = new ArrayList<>();
                    String[] langues = {"Arabe", "Français", "Anglais", "Japonais", "Chinois", "Espagnol", "Allemand"};
                    String[] genres = {"Romance contemporaine", "Manga", "Érotisme", "Shõnen", "Amour", "Seinen",
                            "Shojo", "Shojo", "Littérature jeunesse", "Humour", "Magie", "Fantastique", "Romance",
                            "Littérature sentimentale", "Manga",  "Comédie", "Policier", "Roman historique"
                    };
                    for (String genre : genres) {
                        if(!listeGenres.contains(genre)) listeGenres.add(genre);
                    }
                    for (String langue : langues){
                        if(!listeLangues.contains(langue)) listeLangues.add(langue);
                    }
                    Locale locale = new Locale("fr", "FR");
                    Collections.sort(listeGenres, Collator.getInstance(locale));
                    Collections.sort(listeLangues, Collator.getInstance(locale));
                    request.setAttribute("genres", listeGenres);
                    request.setAttribute("requestLangue", listeLangues);
                }catch(Exception e){

                }


                try{
                    Connection cnx = ConnectionDB.getConnection();
                    String plus = request.getParameter("plus");
                    Integer id = Integer.parseInt(request.getParameter("id"));
                    String titre = (String) request.getParameter("titre");
                    String auteur = (String) request.getParameter("auteur");
                    Double prix = Double.parseDouble(request.getParameter("prix"));
                    switch (plus){
                        case "modifier":
                            Library library = new Library();
                            library.setTitre(titre);
                            library.setAuteur(auteur);
                            library.setPrix(prix);
                            LibraryDao.update(library, id, cnx, true);
                            response.sendRedirect("/addBook?page=" + request.getAttribute("page"));
                            return;
                        case "supprimer":
                            LibraryDao.delete(id, cnx, true);
                            response.sendRedirect("/addBook?page=" + request.getAttribute("page"));
                            return;
                        case "voir":
                            break;
                        default:

                    }

                } catch (Exception e){

                }

                System.out.println("Attribution de titre ");
                if(!titled) request.setAttribute("title", UserDao.attributeTitle(""));
        		
        		
        		
        		
        	}
        }
        
        
        
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
                    response.sendRedirect("/");
                    return;
                default:
            }
        }
		
		request.getRequestDispatcher("WEB-INF/views/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
