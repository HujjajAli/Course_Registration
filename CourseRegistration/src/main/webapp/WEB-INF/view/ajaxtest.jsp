<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajax Name Test Hello</title>

<!-- JQuery Library -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<!-- Bootstrap JavaScript Library -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<!-- Bootstrap CSS Library -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

<script type="text/javascript">

	$(document).ready(function(event){
		$("#name").keyup(function(e){
			var ent_name = $("#name").val();
			console.log("Name     : "+ent_name);
			console.log("Location : "+window.location);
			$.ajax({
				type   : "GET",
				url    : window.location+"/ajaxresponse",
				data   : "std="+ent_name,
				success: function(result){
					$("#std_out").html(result);
				},
				error  : function(){
					alert("Error Occurred");
				}
			});
		});
	});
</script>

</head>
<body>
	<table border="1">
		
		<tr>
			<form>
				<td><input type="text" name="std" id="name"></td>
				<!--  <td><input type="submit" name="std"></td> -->
			</form>
		</tr>
		<tr>
			<td>Server Says! <p id="std_out"></p></td>
		</tr>
		
	</table>
</body>
</html>