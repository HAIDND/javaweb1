<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action= "add"  method="post">
		<label>Nhap category id: </label>
		<input type= "text" name="cateId" >
		<label>Nhap category name: </label>
		<input type= "text" name="cateName" >
		<label>Nhap link images:</label>
		<input type="text" name="images" >
		<label>Nhap  status: </label>
		<input type= "text" name="status" >
		
		<input type="submit" value="Add category">
	
	
	</form>

</body>
</html>