package company.fpt.bookstore.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import company.fpt.bookstore.beans.*;

 
public class DBUtils {
 
    public static List<Book> queryProduct(Connection conn) throws SQLException {
        String sql = "Select a.id, a.name, a.publisher, a.page from book a ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        List<Book> list = new ArrayList<Book>();
        while (rs.next()) {
        	int id = rs.getInt("id");
        	String name = rs.getString("name");
        	String publisher = rs.getString("publisher");
        	int page = rs.getInt("page");
        	Book book = new Book();
        	book.setId(id);
        	book.setName(name);
        	book.setPublisher(publisher);
        	book.setPage(page);
            list.add(book);
        }
        return list;
    }
    
    public static List<Comment> queryComment(Connection conn, String idBook) throws SQLException {
        String sql = "Select a.id, a.name, a.book_id from comment a where a.book_id = ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, idBook);
        
        ResultSet rs = pstm.executeQuery();
        List<Comment> list = new ArrayList<Comment>();
        while (rs.next()) {
        	int id = rs.getInt("id");
        	String name = rs.getString("name");
        	int book_id = rs.getInt("book_id");
        	
        	Comment comment = new Comment();
        	comment.setId(id);
        	comment.setName(name);
        	comment.setBook_id(book_id);
            list.add(comment);
        }
        return list;
    }
 
    
    public static Book findBook(Connection conn, String id) throws SQLException {
        String sql = "Select a.id, a.name, a.publisher, a.page from book a where a.id=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, id);
 
        ResultSet rs = pstm.executeQuery();
 
        while (rs.next()) {
        	int idTemp = rs.getInt("id");
        	String name = rs.getString("name");
        	String publisher = rs.getString("publisher");
        	int page = rs.getInt("page");
        	
            Book book = new Book();
            book.setId(idTemp);
            book.setName(name);
            book.setPublisher(publisher);
            book.setPage(page);
            return book;
        }
        return null;
    }
    
    public static Comment findComment(Connection conn, String id) throws SQLException {
        String sql = "Select a.id, a.name, a.book_id from comment a where a.id=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, id);
 
        ResultSet rs = pstm.executeQuery();
 
        while (rs.next()) {
        	int idCm = rs.getInt("id");
        	String name = rs.getString("name");
        	int bookId = rs.getInt("book_id");
        	
        	
        	Comment comm = new Comment();
        	comm.setId(idCm);
        	comm.setName(name);
        	comm.setBook_id(bookId);
            return comm;
        }
        return null;
    }
 
    
    public static void updateBook(Connection conn, Book book) throws SQLException {
        String sql = "Update book set name =?, publisher =?, page=? where id=? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        pstm.setString(1, book.getName());
        pstm.setString(2, book.getPublisher());
        pstm.setInt(3, book.getPage());
        pstm.setInt(4, book.getId());
 
        pstm.executeUpdate();
    }
    
    public static void updateComment(Connection conn, Comment commt) throws SQLException {
        String sql = "Update comment set name =? where id=? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        pstm.setString(1, commt.getName());
        pstm.setInt(2, commt.getId());
        
        pstm.executeUpdate();
    }
    public static void insertBook(Connection conn, Book book) throws SQLException {
        String sql = "Insert into book(id, name, publisher, page) values (?,?,?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, book.getId());
        pstm.setString(2, book.getName());
        pstm.setString(3, book.getPublisher());
        pstm.setFloat(4, book.getPage());
 
        pstm.executeUpdate();
    }
    
    public static void insertComment(Connection conn, Comment commt) throws SQLException {
        String sql = "Insert into comment(id, name, book_id) values (?,?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, commt.getId());
        pstm.setString(2, commt.getName());
        pstm.setInt(3, commt.getBook_id());
 
        pstm.executeUpdate();
    }
    public static void deleteComment(Connection conn, int code) throws SQLException {
        String sql = "Delete From comment where id= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setInt(1, code);
 
        pstm.executeUpdate();
    }
    
    public static void deleteBook(Connection conn, String code) throws SQLException {
        String sql = "Delete From book where id= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, code);
 
        pstm.executeUpdate();
    }
    
    
 
}