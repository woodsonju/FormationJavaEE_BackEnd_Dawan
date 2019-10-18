package fr.dawan.cart.servlet;



import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import fr.dawan.cart.bean.Library;
import fr.dawan.cart.dao.ConnectionDB;
import fr.dawan.cart.dao.LibraryDao;
import fr.dawan.cart.dao.UserDao;
import fr.dawan.cart.tool.StringFunctions;
import fr.dawan.cart.validator.BookValidator;

import java.io.*;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.Collator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet("/addBook")
@MultipartConfig
public class LibraryServlet extends HttpServlet {

    public LibraryServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	

    	// todo dans body.jsp : le menu suppression
        String action = request.getParameter("action");
        
        if(action != null ) {
        	if(action.equals("star")){
        		System.out.println("Je suis une star");
        		Integer id = Integer.parseInt(request.getParameter("id"));
        		System.out.println("id du livre à mettre en star : " + id);
        		try {
        			Connection connection = ConnectionDB.getConnection();
        			Library library = LibraryDao.findById(id, connection, false);
        			System.out.println("Livre à modifier : " + library.getTitre());
        			LibraryDao.makeAStar(library, connection, false);

        		} catch (Exception e){

        		}
        		request.setAttribute("title", UserDao.attributeTitle(""));
        		response.sendRedirect("/");
        		return;
        	}
        }


        request.setCharacterEncoding("utf-8");
        String description = request.getParameter("description");
        int lastInsertId = 0;
        String titre = request.getParameter("titre");
        Double prix = Double.parseDouble( request.getParameter("prix") );
        String auteur = request.getParameter("auteur");
        String annee = request.getParameter("annee");
        String langue = request.getParameter("langue");
        String isbn = request.getParameter("isbn");
        String dateAchat = request.getParameter("date_achat").replace("-", "/");
        Date dateDateAchat = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        try {
            dateDateAchat = sdf.parse(dateAchat);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String genre = request.getParameter("genre");
        String synopsis = request.getParameter("synopsis");

        boolean isDisponible = false;
        if(request.getParameter("disponibilite") != null) {
            if (request.getParameter("disponibilite").equals("on"))
                isDisponible = true;
        }
        
        Part filePart = request.getPart("file");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        Library newBook = new Library();
        newBook.setPrix(prix);
        newBook.setAnneeSortie(annee);
        newBook.setTitre(StringFunctions.ucFirst(titre));
        newBook.setAuteur(StringFunctions.ucFirst(auteur));
        newBook.setLangue(langue);

        newBook.setIsbn(isbn);
        newBook.setDateAchat(dateDateAchat);
        newBook.setDomaine(genre);
        newBook.setSynopsis(StringFunctions.ucFirst(synopsis));
        newBook.setDisponible(isDisponible);

        String validator = BookValidator.newBookValidator(newBook);

        if(!validator.equals("")){
        	
        	
        	ArrayList<String> listeGenres = new ArrayList<>();
            ArrayList<String> listeLangues = new ArrayList<>();
            String[] langues = {"Arabe", "Français", "Anglais", "Japonais", "Chinois", "Espagnol", "Allemand"};
            String[] genres = {"Romance contemporaine", "Manga", "Érotisme", "Shõnen", "Amour", "Seinen",
                    "Shojo", "Shojo", "Littérature jeunesse", "Humour", "Magie", "Fantastique", "Romance",
                    "Littérature sentimentale", "Manga",  "Comédie", "Policier", "Roman historique"
            };
            for (String genre1 : genres) {
                if(!listeGenres.contains(genre1)) listeGenres.add(genre1);
            }
            for (String langue1 : langues){
                if(!listeLangues.contains(langue1)) listeLangues.add(langue1);
            }
            Locale locale = new Locale("fr", "FR");
            Collections.sort(listeGenres, Collator.getInstance(locale));
            Collections.sort(listeLangues, Collator.getInstance(locale));
            request.setAttribute("genres", listeGenres);
            request.setAttribute("requestLangue", listeLangues);
        	
        	
            if(validator.contains("titre"))
                request.setAttribute("msgTitre", "Le titre du livre ne peut pas être vide.");
            if(validator.contains("auteur"))
                request.setAttribute("msgAuteur", "Le champ auteur est obligatoire");
            if(validator.contains("disponible"))
                request.setAttribute("msgDisponible", "Library indisponible !");
            if(validator.contains("prix"))
                request.setAttribute("msgPrix", "Le prix du produit est obligatoire");

            request.setAttribute("titre", titre);
            request.setAttribute("auteur", auteur);
            request.setAttribute("synopsis", synopsis);
            request.setAttribute("annee", annee);
            request.setAttribute("langue", langue);
            request.setAttribute("request_genre", genre);
            request.setAttribute("isbn", isbn);
            request.setAttribute("description", description);
            request.setAttribute("prix", prix);

            SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd");
            String strDate1 = simpleDateFormat.format(dateDateAchat);
            request.setAttribute("request_dateAchat", strDate1);

            doGet(request, response);
            return;
        }

        Connection cnx = null;
        try {
            cnx = ConnectionDB.getConnection();
            lastInsertId = LibraryDao.insert(newBook, fileName,  cnx, true);
        }catch(ClassNotFoundException e){
            System.out.println("classNotFoundException");
        }catch(SQLException e){
            System.out.println("Erreur : SQLException");
            e.printStackTrace();
        }catch(Exception e){
            System.out.println("Exception");
        }

        if(!"".equals(fileName)) {
           // String path = "c:/j2e/web/descriptions";
            
            
            
            
           
        	String path = request.getServletContext().getRealPath(".")+"/images/descriptions";
           System.out.println("==========> contextPath : " + request.getContextPath());
           System.out.println("=========> contextPath 2 : " + request.getServletContext().getRealPath("."));
           
           path = request.getContextPath()+"/images/descriptions";
            
            
            OutputStream out = null;
            InputStream filecontent = null;
            final PrintWriter writer = response.getWriter();

            try {
            	String fullPath = path + File.separator
                        + "id_" + lastInsertId + "_" + fileName;
                out = new FileOutputStream(new File(fullPath));

                filecontent = filePart.getInputStream();

                int read = 0;
                final byte[] bytes = new byte[1024];

                while ((read = filecontent.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                System.out.println("New file " + fileName + " created at " + fullPath);
                response.sendRedirect(request.getContextPath() + "?action=addBook&page=" + request.getAttribute("page"));
                return;


            } catch (FileNotFoundException fne) {

            } finally {
                if (out != null) {
                    out.close();
                }
                if (filecontent != null) {
                    filecontent.close();
                }
                if (writer != null) {
                    writer.close();
                }
            }
        }
        
        if( request.getAttribute( "page" ) == null ) {
        	request.setAttribute( "page" , "1" );
        }
        System.out.println("Je suis ici 3");
        response.sendRedirect( request.getContextPath() + "?action=addBook&page=" + request.getAttribute("page"));
    }


    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }


    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/addBook.jsp").forward(request, response);
    }
}
