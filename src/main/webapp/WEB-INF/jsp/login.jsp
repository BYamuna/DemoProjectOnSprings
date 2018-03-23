<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
</head>
<script>
window.setTimeout(function() {
    $(".msgcss").fadeTo(500, 0).slideUp(500, function(){
        $(this).remove(); 
    });
}, 5000);
</script>
<body>
<div class="container">
<c:if test="${not empty msg}">
		<div class="msgcss row">
			<div class="col-sm-4 col-sm-offset-4">
				<div class="form-group">
					<div class="alert alert-${cssMsg} fadeIn animated">${msg}</div>
				</div>
			</div>
		</div>
	</c:if></div>
<div class="container">
<h1>Login Master</h1>
	<form:form modelAttribute="login" class="form-horizontal" action="loginpage"  method="POST">
	<form:hidden path="id" />
	<div class="form-group">
			<label class="col-md-3 control-label no-padding-right">User name:</label>
			<form:input path="username" class="col-md-3" placeholder="Enter username" />
	</div>
	<div class="form-group">
			<label class="col-md-3 control-label no-padding-right">Password:</label>
			<form:password path="password" class="col-md-3" placeholder="Enter password" />
	</div>
	<div class="form-group">
			<input type="submit" id="create" class="btn btn-primary" value="Login"/> 
			<input type="reset" id="reset" class="btn btn-default"  value="Reset"/>
		</div> 
	</form:form>
	</div>				
</body>
</html>