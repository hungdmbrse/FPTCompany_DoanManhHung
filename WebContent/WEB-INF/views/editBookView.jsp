<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Edit Book</title>
   </head>
   <body>
 
      <jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu.jsp"></jsp:include>
 
      <h3>Edit Book</h3>
 
      <p style="color: red;">${errorString}</p>
 
      <c:if test="${not empty book}">
         <form method="POST" action="${pageContext.request.contextPath}/editBook">
            <input type="hidden" name="id" value="${book.id}" />
            <table border="0">
           	   <tr>
                  <td>ID</td>
                  <td style="color:red;">${book.id}</td>
               </tr>
               <tr>
                  <td>Name</td>
                  <td><input type="text" name="name" value="${book.name}" /></td>
               </tr>
               <tr>
                  <td>Publisher</td>
                  <td><input type="text" name="publisher" value="${book.publisher}" /></td>
               </tr>
               <tr>
                  <td>Page</td>
                  <td><input type="text" name="page" value="${book.page}" /></td>
               </tr>
               <tr>
                  <td colspan = "2">
                      <input type="submit" value="Submit" />
                      <a href="${pageContext.request.contextPath}/bookList">Cancel</a>
                  </td>
               </tr>
            </table>
         </form>
      </c:if>
 
      <jsp:include page="_footer.jsp"></jsp:include>
 
   </body>
</html>