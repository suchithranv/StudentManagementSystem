<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="/student-management/resources/css/dashboard-style.css">
<title>Student Management</title>
</head>
<body>
	<div style="display: flex;">
		<div style="width: 250px; height: 640px; background-color: #B5F1CC;">
			<img alt="student image"
				src="/student-management/resources/images/29.png" height="150px"
				width="150px" style="padding-top: 20px; padding-left: 50px" /><br>
			<center>
				<a href="/student-management/showStudent">Show Student List</a>
			</center>
			<center>
				<a href="/student-management/showImport">Import Users</a>
			</center>
			<center>
				<a href="/student-management/showDashboard">Dashboard</a>
			</center>
			<center>
				<a href="/student-management/addStudent">Add Student</a>
			</center>
			<center>
				<a href="/student-management/processLogout">Logout</a>
			</center>
		</div>
		<div style="width: 1100px; height: 640px; margin-left: 8px; padding-left: 20px; background-color: #FCC2FC">
			
			<h3> Form data </h3>
			<p> File name :  ${file.originalFilename} </p>
			<p> File type :  ${file.contentType} </p>
			<p> File      :  ${file} </p>
			<p> File Path :  ${imagePath} </p>
			<img alt="student image" src="/student-management/resources/images/${file.originalFilename}" height="300" width="300" style="padding-top: 20px; padding-left: 50px" /><br>
		</div>
        
		
	</div>
</body>
</html>


<%-- <form:form action="processImage" modelAttribute="files"  method="post">
		    <div>
	        <label  for ="id" style="padding-right:24px">Image Id : </label>
	        <form:input type="text" id="id" path ="file_id"  />
	        </div>
			<div>
	        <label for ="data"   style="padding-right:24px">Select Image : </label>
	        <form:input type="file" id="data"  path ="file_data"  />
	        </div> 
	       <input type="submit" value="Upload" style="margin-top:20px;"/>		
		 </form:form>
		  --%>