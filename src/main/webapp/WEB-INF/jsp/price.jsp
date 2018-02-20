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
<title>Price form</title>
</head>
<body>
<form:form modelAttribute="price" class="form-horizontal"
		action="pricetest" method="POST">
		<form:hidden path="id" />
		<div class="form-group">
			<label class="col-md-3 control-label no-padding-right">Item Name:</label>
			<form:input path="iname" class="col-md-3"
				placeholder="Enter itemname" />
		</div>
		<div class="form-group">
			<label class="col-md-3 control-label no-padding-right">Item price:</label>
			<form:input path="iprice" class="col-md-3"
				placeholder="Enter itemprice" />
		</div>
		<div class="form-group">
			<input type="submit" id="submit" class="btn btn-primary"
				value="Create" /> <input class="btn-default btn cancel" type="reset"
				value="Reset" />
		</div>

	</form:form>
</body>
</html>