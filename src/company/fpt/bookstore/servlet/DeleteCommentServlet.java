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
 
import company.fpt.bookstore.utils.*;
 
@WebServlet(urlPatterns = { "/deleteComment" })
public class DeleteCommentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public DeleteCommentServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        
        int code = Integer.parseInt(request.getParameter("id"));
 
        try {
            DBUtils.deleteComment(conn, code);
        } catch (SQLException e) {
            e.printStackTrace();
        } 
         
            response.sendRedirect(request.getContextPath() + "/bookList");
 
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
}