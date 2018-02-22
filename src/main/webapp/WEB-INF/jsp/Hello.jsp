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
<title>Sample form</title>
</head>
<body>
<div class="container">
	<form:form modelAttribute="hello" class="form-horizontal" action="test" method="POST">
		<%-- <form:hidden path="id" /> --%>
		<div class="form-group">
			<label class="col-md-3 control-label no-padding-right">UserName:</label>
			<form:input path="username" class="col-md-3" placeholder="Enter Username" />
		</div>
		<div class="form-group">
			<label class="col-md-3 control-label no-padding-right">Password:</label>
			<form:input path="password" class="col-md-3" placeholder="Enter password" />
		</div>
		<div class="form-group">
			<input type="submit" id="submit" class="btn btn-primary" value="Submit" />
			<input class="btn-default btn cancel" type="reset" value="Reset" /> 
		</div>
		</form:form>
	</div>		
</body>
</html>