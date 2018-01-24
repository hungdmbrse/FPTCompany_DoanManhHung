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
 
@WebServlet(urlPatterns = { "/editComment" })
public class EditCommentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
 
    public EditCommentServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String code = (String) request.getParameter("id");
 
//        Book book = null;
        Comment comment = null;
 
        String errorString = null;
 
        try {
            comment = DBUtils.findComment(conn, code);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
        if (errorString != null && comment == null) {
            response.sendRedirect(request.getServletPath() + "/commentList");
            return;
        }
 
        request.setAttribute("errorString", errorString);
        request.setAttribute("comment", comment);
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/editCommentView.jsp");
        dispatcher.forward(request, response);
 
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        
        int id =  Integer.parseInt(request.getParameter("id"));
        String name = (String) request.getParameter("name");
        int bookID = Integer.parseInt(request.getParameter("book_id"));

        
        Comment comt = new Comment();
        comt.setId(id);
        comt.setName(name);
        comt.setBook_id(bookID);
 
        String errorString = null;
 
        try {
            DBUtils.updateComment(conn, comt);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("comment", comt);
 
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/editCommentView.jsp");
            dispatcher.forward(request, response);
        }
        else {
            response.sendRedirect(request.getContextPath() + "/bookList");
        }
    }
 
}