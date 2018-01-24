package company.fpt.bookstore.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

import company.fpt.bookstore.beans.*;
import company.fpt.bookstore.utils.*;

@WebServlet(urlPatterns = { "/commentList" })
public class CommentListServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 
	    public CommentListServlet() {
	        super();
	    }
	 
	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        Connection conn = MyUtils.getStoredConnection(request);
	 
	        String errorString = null;
	        List<Comment> list = null;
	        try {
	            list = DBUtils.queryComment(conn);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	        }
	        request.setAttribute("errorString", errorString);
	        request.setAttribute("commentList", list);
	         
	        RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/WEB-INF/views/commentListView.jsp");
	        dispatcher.forward(request, response);
	    }
	 
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	    }
	 

}
