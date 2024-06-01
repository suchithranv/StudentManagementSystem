<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/student-management/resources/css/import-css.css">
<title>import user</title>
</head>
<body>
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
  <div style="width: 1100px; height: 640px; margin-left:8px;">
  <div align="center">
  <img src="/student-management/resources/images/college.jpg" width=1000px height=400px/>
  <h1 style="font-family: sans-serif;">Import the excel data to database</h1>
  <form method="POST" action="importExcel" enctype="multipart/form-data">
    <input type="file" name="excelFile" /><br><br><br>
    <input type="submit" value="Import" />
  </form> 
  
  </div>
  

  </div>
  
</body>
</html>