<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table class="table table-hover">
		<tr>
			<th>ID</th>
			<th>Course Name</th>
			<th>Course Teacher</th>
			<th>Description</th>
		</tr>
		<c:forEach items="${courses}" var="c">
			<tr>
				<td>${c.id}</td>
				<td>${c.courseName}</td>
				<td>${c.teacher.teacherName}</td>
				<td>${c.description}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>