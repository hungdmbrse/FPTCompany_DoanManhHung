<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Commet List</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>Comment List</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
       		
          <th>ID</th>
          <th>Comment</th>
          <th>ID Book</th>
       </tr>
       <c:forEach items="${commentList}" var="comment" >
          <tr>
             <td>${comment.id}</td>
             <td>${comment.name}</td>
             <td>${comment.book_id}</td>
             <td>
                <a href="editComment?id=${comment.id}">Edit</a>
             </td>
             <td>
                <a href="deleteComment?id=${comment.id}">Delete</a>
             </td>
          </tr>
       </c:forEach>
    </table>
 
    <a href="createComment" >Create Comment</a>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>