<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<form:form modelAttribute="student" class="form-horizontal"
		action="studenttest" method="POST">
		<form:hidden path="id" />
		<div class="form-group">
			<label class="col-md-3 control-label no-padding-right">FirstName:</label>
			<form:input path="firstname" class="col-md-3"
				placeholder="Enter firstname" />
		</div>
		<div class="form-group">
			<label class="col-md-3 control-label no-padding-right">LastName:</label>
			<form:input path="lastname" class="col-md-3"
				placeholder="Enter lastname" />
		</div>
		<div class="form-group">
			<label class="col-md-3 control-label no-padding-right">Course:</label>
			<form:input path="course" class="col-md-3" placeholder="Enter course" />
		</div>

		<div class="form-group">
			<label class="col-md-3 control-label no-padding-right">MobileNo:</label>
			<form:input path="mobile" class="col-md-3"
				placeholder="Enter mobileno" />
		</div>
		<div class="form-group">
			<input type="submit" id="submit" class="btn btn-primary"
				value="Create" /> <input class="btn-default btn cancel" type="reset"
				value="Reset" />
		</div>

	</form:form>

</body>
</html>