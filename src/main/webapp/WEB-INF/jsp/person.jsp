<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>Person form</title>
</head>
<body>
<div class="container">
<h1>Person Master</h1>
<form:form modelAttribute="person" class="form-horizontal" action="persontest" method="POST">
		<form:hidden path="id" />
		<div class="form-group">
			<label class="col-md-3 control-label no-padding-right">Person First name:</label>
			<form:input path="fname" class="col-md-3"
				placeholder="Enter fname" />
		</div>
		<div class="form-group">
			<label class="col-md-3 control-label no-padding-right">Person Last name:</label>
			<form:input path="lname" class="col-md-3"
				placeholder="Enter lname" />
		</div>
		<div class="form-group">
			<label class="col-md-3 control-label no-padding-right">Person Address:</label>
			<form:input path="address" class="col-md-3"
				placeholder="Enter address" />
		</div>
		<div class="form-group">
			<label class="col-md-3 control-label no-padding-right">Person City:</label>
			<form:input path="city" class="col-md-3" placeholder="Enter city" />
		</div>
		<div class="form-group">
			<input type="submit" id="submit" class="btn btn-primary"
				value="Create" /> <input class="btn-default btn cancel" type="reset"
				value="Reset" />
		</div>

	</form:form>
	</div>

</body>
</html>