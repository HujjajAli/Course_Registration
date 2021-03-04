<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<head>
<meta charset="ISO-8859-1">
<title>Student Course Registration - Sign Up</title>

<!-- JQuery Library -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<!-- JQuery Validtor -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.validate.js"></script>
<!-- Bootstrap JavaScript Library -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<!-- Bootstrap CSS Library -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

<style type="text/css">
	.input-error{
		color:red;
	}
</style>

</head>
<body>
	<div class="col-md-4">
	</div>
	
	<div class="col-md-4" style="margin-top:80px">
		<form:form action="${pageContext.request.contextPath}/home/registerStudent" modelAttribute="student" id="studentForm" class="panel panel-info form-horizontal">
			<div class="panel-heading" style="font-size:20px;text-align:center;">STUDENT REGISTRATION AREA</div>
			<div class="panel-body">
				<div class="form-group row">
					<label class="control-label col-md-4">Name</label>
					<div class="col-md-8">
						<form:input path="std_name" type="text" class="form-control" placeholder="Enter Student Name"/>
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-md-4">Father Name</label>
					<div class="col-md-8">
						<form:input path="father_name" type="text" class="form-control" placeholder="Enter Father Name"/>
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-md-4">Gender</label>
					<div class="col-md-8">
						<form:select path="gender" class="form-control">
							<option value="">Select Gender</option>
							<option value="MALE">MALE</option>
							<option value="FEMALE">FEMALE</option>
						</form:select>
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-md-4">Mobile#</label>
					<div class="col-md-8">
						<form:input path="contact" type="text" class="form-control" placeholder="Enter Contact #"/>
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-md-4">Email</label>
					<div class="col-md-8">
						<form:input path="username" id="username" type="email" class="form-control" placeholder="Enter Username"/>
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-md-4">Password</label>
					<div class="col-md-8">
						<form:input path="password" type="password" id="pass" class="form-control"	placeholder="Enter Password" />
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-md-4">Con Password</label>
					<div class="col-md-8">
						<input name="con_password"  type="password"   class="form-control"	placeholder="Enter Confirm Password" />
						<span></span>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<input type="submit" id="register" value="REGISTER" class="btn btn-success btn-block">
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