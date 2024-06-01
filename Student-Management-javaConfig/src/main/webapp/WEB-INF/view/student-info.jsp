<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Information</title>
<link rel="stylesheet" type="text/css" href="/student-management/resources/css/dashboard-css.css">
<style>
.card {
  /* Add shadows to create the "card" effect */
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2); 
  background-color: #F7C8E0;
  transition: 0.3s;
}

/* On mouse-over, add a deeper shadow */
.card:hover {
  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
}

/* Add some padding inside the card container */
.container {
  padding: 2px 16px;
}

label{
font-size :20px;
}
</style>
</head>

<body>
<%
	if (session.getAttribute("Stname") == null) {
		response.sendRedirect("adminLogin");
	}
	%>

<div style="display: flex;">
  <div style="width: 250px; height: 640px; background-color : #00005C;">
      <img alt="student image" src="/student-management/resources/images/${student.imageName}" height="150px" width="150px" style="padding-top:20px; padding-left:50px"/><br>
      <br><br><br><br><center><a href="/student-management/processStudentLogout">Logout</a></center>
  </div>
  <div style="width: 1100px; height: 640px;"> 
     <div class="card" style="margin-left:320px; margin-right:350px; margin-top:100px">
       <div class="container" style="padding:20px; padding-left:30px">
              <label>ID:             </label>    <label style="padding-left:140px">${student.id}</label><br><br>
              <label>Roll No:        </label>    <label style="padding-left:94px">${student.rollno}</label><br><br>
              <label>Name:           </label>    <label style="padding-left:110px">${student.fname} ${student.lname}</label><br><br>
              <label>DOB:            </label>    <label style="padding-left:116px">${student.dob}</label><br><br>
              <label>Gender:         </label>    <label style="padding-left:100px">${student.gender}</label><br><br>
              <label>Email:          </label>    <label style="padding-left:110px">${student.email}</label><br><br>
              <label>Password:       </label>    <label style="padding-left:80px">${student.password}</label><br><br>
              <label>Mobile Number:  </label>    <label style="padding-left:28px">${student.mobile}</label><br><br>
              <label>Course:         </label>    <label style="padding-left:100px">${student.course}</label><br><br>
              <label>Country:        </label>    <label style="padding-left:90px">${student.country}</label>
         </div>    
     </div>         
  </div> 
</div>
</body>
</html>