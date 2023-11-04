<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border= "1" style= "width:700px">
    <thead>
        <th>ID</th>
        <th>name</th>
        <th>Icon</th>
        <th>status</th>
        <th>Action</th>
    </thead>
    <tbody>
    <c:forEach var="i" items ="${list}">    
         <tr>
              <td>${i.cateId}</td>
              <td> ${i.cateName}</td>             
              <td> ${i.img}</td>
              <td> ${i.status}</td>
              <td><a href="update?id= ${i.cateId}">Update</a> || Delete</td>
              
         </tr>
    </c:forEach>
    </tbody> 
</table>
 
 <br>

 <br>

 <br>
 
 <br>
</body>
</html>