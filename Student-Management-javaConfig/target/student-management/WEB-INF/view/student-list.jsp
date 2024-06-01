<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/student-management/resources/css/student-css.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript" src="/student-management/resources/Jquery Validation/Jquery.js"></script>
<script type="text/javascript" src="/student-management/resources/Jquery Validation/jquery-validation-1.19.5/dist/jquery.validate.min.js"></script>
<script type="text/javascript" src="/student-management/resources/Jquery Validation/jquery-validation-1.19.5/dist/additional-methods.min.js"></script>

<meta charset="UTF-8">
<title>student list</title>

<style>
a:hover, a:active {
	text-decoration: blink;
}

.error {
	color: red;
}
</style>


<script type="text/javascript">
$(document).ready(function() {
	   $("#form1").validate({

		 //target name attibute
		   rules: {
			   to:{
			    	 required:true,
		             email:true	  	 
			     }
		      },	      
		   messages: {	
			   to:{
			    	 required:"Email is mandatory",
		             email:"Invalid email id"	  	 
			     }
			}   
	});
});
</script>


</head>


<body>
	<%
	if (session.getAttribute("Sname") == null) {
		response.sendRedirect("adminLogin");
	}
	%>


<div style="display: flex;">
  <div style="width: 250px; height: 640px; background-color: #00005C;">
	 <img alt="student image" src="/student-management/resources/images/29.png" height="150px" width="150px" 
	   style="padding-top: 20px; padding-left: 50px" /><br>
	  <center><a href="/student-management/showStudent" style="margin-top:40px" class="a">Show StudentList</a></center>
	  <center><a href="/student-management/showImport" class="a">Import Users</a></center>
	  <center><a href="/student-management/showDashboard" class="a">Dashboard</a></center>
	  <center><a href="/student-management/addStudent" class="a">Add Student</a></center>
	  <center><a href="/student-management/processLogout" class="a">Logout</a></center>	
	</div>
	<div style="width: 1100px; height: 640px; margin-left:8px">
	 
               <form id="my-form" action="" method="post" style="padding-left:20px;">
               <button type="submit"  name="submitButton" value="delete" id="submit-1">Delete</button>
               <button type="submit" name="submitButton" value="edit" id="submit-2">Edit</button>
               <a href="/student-management/exportPdf" style="margin-left: 700px"><i class="fa fa-file-pdf-o" style="font-size:20px;color:red"></i></a>
			   <a href="/student-management/exportExcel" style="margin-left: 30px"><i class="fa fa-file-excel-o" style="font-size:20px;color:green"></i></a>
			   <a style="margin-left: 30px" onclick="toggleForm()"><i class="fa fa-envelope" style="font-size:20px;color:blue"></i></a>
				<table class="styled-table" style="margin-top:10px">
					<thead>
						<th><input type="checkbox" id="checkbox-header"></th>
						<td>Roll No</td>
						<td>First Name</td>
						<td>Last Name</td>
						<td>DOB</td>
						<td>Gender</td>
						<td>Email</td>
						<td>Password</td>
						<td>Mobile</td>
						<td>Course</td>
						<td>Country</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<c:forEach var="st" items="${students}">
								<!-- We will have student data using model attribute : students -->
								<td><input type="checkbox" name="ids" value="${st.id}" class="checkbox-item"></td>
								<td>${st.rollno}</td>
								<td>${st.fname}</td>
								<td>${st.lname}</td>
								<td>${st.dob}</td>
								<td>${st.gender}</td>
								<td>${st.email}</td>
								<td>${st.password}</td>
								<td>${st.mobile}</td>
								<td>${st.course}</td>
								<td>${st.country}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				</form>
				
				
		</div>
</div>
		
<script>
  var submitButton1 = document.getElementById("submit-1");
  var submitButton2 = document.getElementById("submit-2");
  var form = document.getElementById("my-form");

  submitButton1.addEventListener("click", function() {
    // Perform action 1
    form.action = "deleteSelection";
  });

  submitButton2.addEventListener("click", function() {
    // Perform action 2
     form.enctype="multipart/form-data";
    form.action = "updateStudent";
  });
</script>


<script>
  var checkboxHeader = document.getElementById("checkbox-header");
  var checkboxItems = document.getElementsByClassName("checkbox-item");

  checkboxHeader.addEventListener("change", function() {
    for (var i = 0; i < checkboxItems.length; i++) {
      checkboxItems[i].checked = checkboxHeader.checked;
    }
  });

  for (var i = 0; i < checkboxItems.length; i++) {
    checkboxItems[i].addEventListener("change", function() {
      var allChecked = true;
      for (var j = 0; j < checkboxItems.length; j++) {
        if (!checkboxItems[j].checked) {
          allChecked = false;
          break;
        }
      }
      checkboxHeader.checked = allChecked;
    });
  }
</script>


<div class="form-popup" id="popForm">
  <form action="sendEmail" class="form-container" id="form1" method="post">
    <h3 align="center" style="font-family: sans-serif;">Send PDF</h3>
    <label for="to"><b style="padding-left:2px;">Send to:</b></label><br>
    <input type="text" placeholder="Enter Email" name="to" id="to" required>
    <button type="submit" class="btn" style="margin-top:20px;" >Send</button>
  </form>
</div>

<script>
function toggleForm() {
  var form = document.getElementById('popForm');
  if (form.style.display === 'none') {
    form.style.display = 'block';
  } else {
    form.style.display = 'none';
  }
  
}
</script>


</body>
</html>