package com.wj.book.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wj.book.beans.Book;

/**
 * Servlet implementation class LibraryServlet
 */
@WebServlet("")
public class LibraryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Book> books = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibraryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	books = new ArrayList<Book>();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		books.add(new Book("OnePiece", "Eiichirō Oda", 1997));
		books.add(new Book("DBZ", "Akira Toriyama", 1990));
		books.add(new Book("SNK", "Hajime Isayama", 2013));
		
		request.setAttribute("books", books);
		request.getRequestDispatcher("WEB-INF/views/index.jsp").forward(request, response);;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
