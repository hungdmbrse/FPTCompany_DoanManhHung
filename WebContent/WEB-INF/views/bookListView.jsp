<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Book List</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>Book List</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
       		
          <th>ID</th>
          <th>Name</th>
          <th>Publisher</th>
          <th>page</th>
          <th>Edit</th>
          <th>Delete</th>
          <th>Comment</th>
       </tr>
       <c:forEach items="${bookList}" var="book" >
          <tr>
             <td>${book.id}</td>
             <td>${book.name}</td>
             <td>${book.publisher}</td>
             <td>${book.page}</td>
             <td>
                <a href="editBook?id=${book.id}">Edit</a>
             </td>
             <td>
                <a href="deleteBook?id=${book.id}">Delete</a>
             </td>
             <td>
                <a href="commentList?id=${book.id}">View</a>
             </td>
          </tr>
       </c:forEach>
    </table>
 	<h4>Sorry for the inconvenient _ _! but if you want create a new book. Please insert an id that the larger then perivous</h4>
    <a href="createBook" >Create Book</a>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>