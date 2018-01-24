package company.fpt.bookstore.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 


import company.fpt.bookstore.beans.*;
import company.fpt.bookstore.utils.*;
 
@WebServlet(urlPatterns = { "/createBook" })
public class CreateBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public CreateBookServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/createBookView.jsp");
        dispatcher.forward(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        int id = Integer.parseInt(request.getParameter("id"));
        String name = (String) request.getParameter("name");
        String publisher = (String) request.getParameter("publisher");
        int page = Integer.parseInt(request.getParameter("page"));
        
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setPublisher(publisher);
        book.setPage(page);
        
        String errorString = null;
 
 
        if (errorString == null) {
            try {
                DBUtils.insertBook(conn, book);
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
        }
 
        request.setAttribute("errorString", errorString);
        request.setAttribute("book", book);
 
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/createBookView.jsp");
            dispatcher.forward(request, response);
        }
        else {
            response.sendRedirect(request.getContextPath() + "/bookList");
        }
    }
 
}