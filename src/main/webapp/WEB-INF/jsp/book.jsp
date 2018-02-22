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
<title>Book form</title>
</head>
<body>
<div class="container">
<form:form modelAttribute="book" class="form-horizontal"
		action="booktest" method="POST">
		<form:hidden path="id" />
		<div class="form-group">
			<label class="col-md-3 control-label no-padding-right">Book Name:</label>
			<form:input path="name" class="col-md-3"
				placeholder="Enter bookname" />
		</div>
		<div class="form-group">
			<label class="col-md-3 control-label no-padding-right">Book Author:</label>
			<form:input path="author" class="col-md-3"
				placeholder="Enter authorname" />
		</div>
		<div class="form-group">
			<label class="col-md-3 control-label no-padding-right">Book publisher:</label>
			<form:input path="publisher" class="col-md-3" placeholder="Enter publishername" />
		</div>

		<div class="form-group">
			<label class="col-md-3 control-label no-padding-right">Book Quantity:</label>
			<form:input path="quantity" class="col-md-3"
				placeholder="Enter quantity" />
		</div>
		<div class="form-group">
			<input type="submit" id="submit" class="btn btn-primary"
				value="Create" /> <input class="btn-default btn cancel" type="reset"
				value="Reset" />
		</div>

	</form:form>
	</div>
	<div class="container">
	<div class="cleafix">
		<div class="col-md-12">
			<h1>Book Details</h1>
			<div class="table-responsive-lg">
				<table class="table table-bordered table-hover">
					<tr class="warning">
						<th>id</th>
						<th>Book name</th>
						<th>Book Author</th>
						<th>Book Publisher</th>
						<th>Quantity</th>	
						<!-- <th>Date</th>
						<th>fileupload</th>
						<th>filedownload</th> -->
						<th>options</th>
					</tr>
					<c:forEach var="list" items="${blist}">
						<tr class="active">
							<td>${list.id }</td>
							<td>${list.name }</td>
							<td>${list.author}</td>
							<td>${list.publisher}</td>
							<td>${list.quantity}</td>
							<%-- <td>${list.mobile}</td> --%>
		
							<%-- <td><c:if test="${not empty list.files}">
			    <c:forTokens items="${list.files}" delims="*" var="mySplit">
			<a class="attachments" target="_blank" href="reportDocuments/${mySplit}"><i class="fa fa-paperclip fa-lg grey" title="${mySplit}"></i></a>
		    </c:forTokens>
		   </c:if> </td> --%>
							<td><a href="deletebook?id=${list.id}"> <i
									class="fa fa-trash"></i>
							</a> <a href="edit?id=${list.id}"> <i class="fa fa-edit"></i></a></td>
						</tr>
					</c:forEach>
					</table>
					</div>
					</div>
					</div>
					</div>
	
</body>
</html>