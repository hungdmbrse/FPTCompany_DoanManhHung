<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Edit Comment</title>
   </head>
   <body>
 
      <jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu.jsp"></jsp:include>
 
      <h3>Edit Comment</h3>
 
      <p style="color: red;">${errorString}</p>
 
      <c:if test="${not empty comment}">
         <form method="POST" action="${pageContext.request.contextPath}/editComment">
            <input type="hidden" name="id" value="${comment.id}" />
            <input type="hidden" name="book_id" value="${comment.book_id}" />
            <table border="0">
           	   <tr>
                  <td>ID</td>
                  <td style="color:red;">${comment.id}</td>
               </tr>
               <tr>
                  <td>Comment</td>
                  <td><input type="text" name="name" value="${comment.name}" /></td>
               </tr>
               <tr>
                  <td>Book_ID</td>
                  <td style="color:red;">${comment.book_id}</td>
               </tr>
               <tr>
                  <td colspan = "2">
                      <input type="submit" value="Submit" />
                      <a href="${pageContext.request.contextPath}/commentList">Cancel</a>
                  </td>
               </tr>
            </table>
         </form>
      </c:if>
 
      <jsp:include page="_footer.jsp"></jsp:include>
 
   </body>
</html>