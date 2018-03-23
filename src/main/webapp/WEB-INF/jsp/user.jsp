<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

	<div class="clearfix"></div>
	<ol class="breadcrumb">
		<!-- <li><a href="login">Login</a></li> -->
		<li>User Master</li>
	</ol>
	<div class="clearfix"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-12" style="background-color: white !important; padding-top: 15PX;">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4>Users List</h4>
						<div class="options">
							<a href="javascript:;" class="panel-collapse"><i class="fa fa-chevron-down"></i></a>
						</div>
					</div>
					<div class="panel-body collapse in">
					<input type="checkbox" class="form-check-input" onclick="inactiveData();" id="inActive"> <label class="form-check-label">Show Inactive List</label>
						<div class="table-responsive" id="tableId">
							<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered datatables" id="example">
							<thead><tr><th>User ID</th><th>FullName</th><th>Gender</th><th>Mobile</th><th>Address</th><th>Email</th><th>Username</th><th>Password</th><th>Confirm password</th><th></th></tr></thead>
								<tbody></tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
<!-- 		<a class="btn btn-info btn-lg"  onclick="PopupFillingStation();">Add Gas</a><br><br> -->
		<div class="row" id="moveTo">
			<div class="col-md-12 col-sm-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4>Add User</h4>
					</div>
					</div>
					<form:form class="form-horizontal" commandName="userpage" role="form" id="fillingregistration-form" action="userpage" method="post">
					<div class="panel-body">
						<div class="row">
                    		<div class="col-md-6">
                    			<div class="form-group">
                    				<form:hidden path="id"/>
									<label for="focusedinput" class="col-md-6 control-label">FullName <span class="impColor">*</span></label>
									<div class="col-md-5">
										<form:input path="fullname" class="form-control validate" placeholder="Enter fullName"/>	
										<span class="hasError" id="stationnameError"></span>
								    </div>
								    <label for="focusedinput" class="col-md-6 control-label">Gender<span class="impColor">*</span></label>
								    <div class="col-md-5">
			 							<form:radiobutton path = "gender" value = "M" />Male
             							<form:radiobutton path = "gender" value = "F" />Female	
										<span class="hasError" id="stationnameError"></span>
								    </div>
								    <label for="focusedinput" class="col-md-6 control-label">Mobile <span class="impColor">*</span></label>
									<div class="col-md-5">
										<form:input path="mobile" class="form-control validate" placeholder="Enter mobileno"/>	
										<span class="hasError" id="stationnameError"></span>
								    </div>
								    <label for="focusedinput" class="col-md-6 control-label">Address <span class="impColor">*</span></label>
									<div class="col-md-5">
										<form:textarea path="address" class="form-control validate" placeholder="Enter address"/>	
										<span class="hasError" id="stationnameError"></span>
								    </div>
                    			</div>
                    		</div>
                    		<div class="col-md-6">
                    			<div class="form-group">
									<label for="focusedinput" class="col-md-6 control-label">Email <span class="impColor">*</span></label>
									<div class="col-md-5">
										<form:input path="email" class="form-control validate" placeholder="Enter emailid"/>	
										<span class="hasError" id="stationnameError"></span>
								    </div>
								    <label for="focusedinput" class="col-md-6 control-label">Username <span class="impColor">*</span></label>
									<div class="col-md-5">
										<form:input path="username" class="form-control validate" placeholder="Enter username"/>	
										<span class="hasError" id="stationnameError"></span>
								    </div>
								    <label for="focusedinput" class="col-md-6 control-label">Password <span class="impColor">*</span></label>
									<div class="col-md-5">
										<form:password path="password" class="form-control validate" placeholder="Enter password"/>	
										<span class="hasError" id="stationnameError"></span>
								    </div>
								    <label for="focusedinput" class="col-md-6 control-label">Confirm Password <span class="impColor">*</span></label>
									<div class="col-md-5">
										<form:password path="confirmpassword" class="form-control validate" placeholder="Retype password"/>	
										<span class="hasError" id="stationnameError"></span>
								    </div>
                    			</div>
                    		</div>
                    	</div>
                    		
<!-- Modal Starts here-->
<!-- Modal Ends here-->

					</div>
					<div class="panel-footer">
				      	<div class="row">
				      		<div class="col-sm-12">
				      			<div class="btn-toolbar text-center">
					      			<input type="submit" id="submit1" value="Submit" class="btn-primary btn"/>
					      			<input type="reset" value="Reset" class="btn-danger btn cancel"/>
				      			</div>
				      		</div>
				      	</div>
			      	</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
			<!-- container -->


</body>
<script type="text/javascript">

/* var listUsers1 = ${allUsers1};
if (listUsers1 != "") {
	displayTable(listUsers1);
}
function displayTable(listUsers) {
	$('#tableId').html('');
	var tableHead = '<table id="example" class="table table-striped table-bordered datatables">'
			+ '<thead><tr><th>User ID</th><th>FullName</th><th>Gender</th><th>Mobile</th><th>Address</th><th>Email</th><th>Username</th><th>Password</th><th>Confirm password</th><th style="text-align: center;">Options</th></tr></thead><tbody></tbody></table>';
	$('#tableId').html(tableHead);
	serviceUnitArray = {};
	$.each(listUsers,function(i, userObj) {
		if(userObj.status == "1"){
			var deleterow = "<a class='deactivate' onclick='deleteorg("+ userObj.id+ ",0)'><i class='fa fa-eye'></i></a>"
		}else{  
			var deleterow = "<a class='activate' onclick='deleteorg("+ userObj.id+ ",1)'><i class='fa fa-eye-slash'></i></a>"
		}
		var edit = "<a class='edit editIt' onclick='editOrganization("	+ userObj.id+ ")'><i class='fa fa-edit'></i></a>"
		serviceUnitArray[userObj.id] = userObj;
		var tblRow = "<tr>"
			+ "<td title='"+userObj.fullname+"'>"+ userObj.fullname + "</td>"
			+ "<td title='"+userObj.gender+"'>"+ userObj.gender + "</td>"
			+"<td title='"+userObj.mobile+"'>"+ userObj.mobile + "</td>"
			+"<td title='"+userObj.address+"'>"+ userObj.address + "</td>"
			+"<td title='"+userObj.email+"'>"+ userObj.email + "</td>"
			+"<td title='"+userObj.username+"'>"+ userObj.username + "</td>"
			+"<td title='"+userObj.password+"'>"+ userObj.password + "</td>"
			+"<td title='"+userObj.confirmpassword+"'>"+ userObj.confirmpassword + "</td>"
			+ "<td style='text-align: center;white-space: nowrap;'>" + edit + "&nbsp;&nbsp;" + deleterow + "</td>" 
			+ "</tr>";
		$(tblRow).appendTo("#tableId table tbody");
	});
	if(isClick=='Yes') $('.datatables').dataTable();
	
}


function editUser(id) {
	$("#id").val(serviceUnitArray[id].id);
	$("#fullname").val(serviceUnitArray[id].fullname);
	$("#gender").val(serviceUnitArray[id].gender);
	$("#mobile").val(serviceUnitArray[id].mobile);
	$("#address").val(serviceUnitArray[id].address);
	$("#email").val(serviceUnitArray[id].email);
	$("#username").val(serviceUnitArray[id].username);
	$("#password").val(serviceUnitArray[id].password);
	$("#confirmpassword").val(serviceUnitArray[id].confirmpassword);
	$("#submit1").val("Update");
	$(window).scrollTop($('#moveTo').offset().top);
}

function deleteuser(id,status){
	var checkstr=null;
	if(status == 0){
		 checkstr = confirm('Are you sure you want to Deactivate?');
	}else{
		 checkstr = confirm('Are you sure you want to Activate?');
	}
	if(checkstr == true){
		var formData = new FormData();
	    formData.append('id', id);
	    formData.append('status', status);
		$.fn.makeMultipartRequest('POST', 'deleteAbBranch', false, formData, false, 'text', function(data){
			var jsonobj = $.parseJSON(data);
			var alldata = jsonobj.allUsers1;
			displayTable(alldata);
			toolTips();
			$('#inActive').prop('checked', false);
		});
	}
}

function validate(id, errorMessage)
{
	var styleBlock = '.placeholder-style.placeholder-style::-moz-placeholder {color: #cc0000;} .placeholder-style::-webkit-input-placeholder {color: #cc0000;}';
	if($('#'+id).val() ==  null || $('#'+id).val() == ""  || $('#'+id).val()=="undefined" ) {
		$('style').append(styleBlock);
		$('#'+id).css('border-color','#cc0000');
		$('#'+id).css('color','#cc0000');
		$('#'+id).attr('placeholder',errorMessage);
		$('#'+id).addClass('placeholder-style your-class');
//			$('#'+id).css('color','#cc0000');
//			$('#'+id+'Error').text(errorMessage);
	}else{
		$('#'+id).css('border-color','');
		$('#'+id).removeClass('placeholder-style your-class');
//			$('#'+id).css('color','');
//			$('#'+id+'Error').text("");
	}
	
}

function inactiveData() {
	var status="0";
	if($('#inActive').is(":checked") == true){
		status="0";
	}else{
		status="1";
	}
		var formData = new FormData();
		formData.append('status', status);
		
		$.fn.makeMultipartRequest('POST', 'inActiveAbBranch', false,
				formData, false, 'text', function(data) {
			var jsonobj = $.parseJSON(data);
			var alldata = jsonobj.allUsers1;
			displayTable(alldata);
			console.log(jsonobj.allUsers1);
				});
		
} */
$("#pageName").text("User Master");
$(".user").addClass("active"); 
</script>