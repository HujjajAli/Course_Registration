<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Student Course Registration - Insert New Book</title>
<!-- JQuery Library -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<!-- JQuery Validtor -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.validate.js"></script>
<!-- Bootstrap JavaScript Library -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<!-- Bootstrap CSS Library -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

</head>

<body>
	<c:if test="${session_msg_value == 'Show'}">
		<div class="row text-center">
			<div class="alert ${alert_css} alert-dismissible fade in">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<p><strong>${login_area_msg_1}</strong> ${login_area_msg_2}</p>
			</div>
		</div>
	</c:if>
	
	<div class="col-md-4">
	</div>
	
	<div class="col-md-4" style="margin-top:140px">
		<form:form action="${pageContext.request.contextPath}/home/processLogin" modelAttribute="student" id="loginForm" class="panel panel-info form-horizontal">
			<div class="panel-heading" style="font-size:20px;text-align:center;">LOGIN AREA</div>
			<div class="panel-body">
				<div class="form-group row">
					<label class="control-label col-md-4">Email</label>
					<div class="col-md-8">
						<form:input path="username" id="login_username" type="email" class="form-control" placeholder="Enter Username"/>
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-md-4">Password</label>
					<div class="col-md-8">
						<form:input path="password" id="login_password" type="password" class="form-control" placeholder="Enter Password" />
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<button class="btn btn-success btn-block">Sign In</button>
					</div>
					<div class="col-md-6">
						<a href="${pageContext.request.contextPath}/home/registration" class="btn btn-info btn-block">Sign Up</a>
					</div>
				</div>
			</div>
		</form:form>
	</div>
	<div class="col-md-4">
	</div>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/myapp.js"></script>
</body>
</html>