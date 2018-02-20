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
<title>Employee form</title>
</head>
<body>
<form:form modelAttribute="employee" class="form-horizontal"
		action="employeetest" method="POST">
		<form:hidden path="id" />
		<div class="form-group">
			<label class="col-md-3 control-label no-padding-right">Employee Name:</label>
			<form:input path="name" class="col-md-3"
				placeholder="Enter employeename" />
		</div>
		<div class="form-group">
			<label class="col-md-3 control-label no-padding-right">Employee designation:</label>
			<form:input path="designation" class="col-md-3"
				placeholder="Enter employeedesignation" />
		</div>
		<div class="form-group">
			<label class="col-md-3 control-label no-padding-right">Employee Salary:</label>
			<form:input path="salary" class="col-md-3" placeholder="Enter employeesalary" />
		</div>
		<div class="form-group">
			<input type="submit" id="submit" class="btn btn-primary"
				value="Create" /> <input class="btn-default btn cancel" type="reset"
				value="Reset" />
		</div>

	</form:form>
</body>
</html>