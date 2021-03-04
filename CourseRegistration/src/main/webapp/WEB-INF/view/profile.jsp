<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ page import="com.vBizSystems.dto.Student" %>    
<% 
 if(session.getAttribute("student") != null){
   Student student = (Student)session.getAttribute("student"); 
   request.setAttribute("std", student);
 }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Course Registration - Assign Book</title>
<!-- JQuery Library -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<!-- Bootstrap JavaScript Library -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<!-- Bootstrap CSS Library -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
</head>
<body>
	<nav class="navbar navbar-inverse"><!-- Other Styeles default-->
		<div class="container-fluid">
			<div class="navbar-header">
				<a href="#" class="navbar-brand">COURSE REGISTRATION SYSTEM</a>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="index.html">Home</a></li>
				<li class="dropdown"><a href="menu.html" class="dropdown-toggle" data-toggle="dropdown">${std.std_name} <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a>Profile</a></li>
						<li><a href="${pageContext.request.contextPath}/student/logout">Logout</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
	
	<div class="container-fluid">
		<div class="col-md-3">
			<ul class="navbar navbar-default nav" style="height:100vh">
				<li><a href="#"><span class="glyphicon glyphicon-dashboard"></span>  Dashboard</a></li>
				<li><a href="${pageContext.request.contextPath}/student/list_courses"><span class="glyphicon glyphicon-plus"></span>  View Courses</a></li>
			</ul>
		</div>
		
		<div class="col-md-9">
			<c:choose>
				<c:when test="${page_view == 'list-courses'}">
					<jsp:include page="coursesByStudent.jsp"></jsp:include>
				</c:when>
				<c:otherwise>
					<table class="table table-hover">
						<tr>
							<td>Student Name</td>
							<td>${std.std_name}</td>
						</tr>
						<tr>
							<td>Father Name</td>
							<td>${std.father_name}</td>
						</tr>
						<tr>
							<td>Gender</td>
							<td>${std.gender}</td>
						</tr>
						<tr>
							<td>Contact Number</td>
							<td>${std.contact}</td>
						</tr>
						<tr>
							<td>Email</td>
							<td>${std.username}</td>
						</tr>
					</table>
				</c:otherwise>
			</c:choose>
			
		</div>
		
	</div>
	
</body>
</html>