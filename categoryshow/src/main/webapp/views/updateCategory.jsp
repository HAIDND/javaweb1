<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="update" method="post">
		<label>ID:</label>
		<input type="text" name="cateId" value="${cate.cateId}" readonly = "readonly">
		<label>Nhap category name: </label> 
		<input type="text" name="cateName" value="${cate.cateName}">
			 <label>Nhap link images:</label>
			  <input type="text" name="images" value="${cate.img}"> 
			<label>Nhap status: </label> <input type="text" name="status" value="${cate.status}">

		<input type="submit" value="Update category">


	</form>


</body>
</html>