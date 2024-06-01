<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.HashMap"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page import="java.util.*"%>
<%@page import="fusioncharts.FusionCharts" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/student-management/resources/css/dashboard-css.css">
<script type="text/javascript" src="https://cdn.fusioncharts.com/fusioncharts/latest/fusioncharts.js"></script>
<script type="text/javascript" src="https://cdn.fusioncharts.com/fusioncharts/latest/themes/fusioncharts.theme.fusion.js"></script>
<script type="text/javascript" src="https://cdn.fusioncharts.com/fusioncharts/latest/fusioncharts.charts.js"></script>
<link rel="stylesheet" href="https://cdn.fusioncharts.com/fusioncharts/latest/fusioncharts.css">
<script type="text/javascript" src="https://cdn.fusioncharts.com/fusioncharts/latest/themes/fusioncharts.theme.umber.js"></script>
<script type="text/javascript" src="https://cdn.fusioncharts.com/fusioncharts/latest/themes/fusioncharts.theme.candy.js"></script>
<script type="text/javascript" src="https://cdn.fusioncharts.com/fusioncharts/latest/themes/fusioncharts.theme.ocean.js"></script>
<script type="text/javascript" src="https://cdn.fusioncharts.com/fusioncharts/latest/themes/fusioncharts.theme.zune.js"></script>
<script type="text/javascript" src="https://cdn.fusioncharts.com/fusioncharts/latest/themes/fusioncharts.theme.carbon.js"></script>
<script type="text/javascript" src="https://cdn.fusioncharts.com/fusioncharts/latest/themes/fusioncharts.theme.palette.js"></script>


<title>Student Management</title>

</head>
<body>




<div style="display: flex;">
  <div style="width: 250px; height: 640px; background-color : #00005C;">
      <img alt="student image" src="/student-management/resources/images/29.png" height="150px" width="150px" style="padding-top:20px; padding-left:50px"/><br>
      <center><a href="/student-management/showStudent" style="margin-top:40px">Show Student List</a></center> 
      <center><a href="/student-management/showImport">Import Users</a></center>
      <center><a href="/student-management/showDashboard">Dashboard</a></center>
      <center><a href="/student-management/addStudent">Add Student</a></center>
      <center><a href="/student-management/processLogout">Logout</a></center>
  </div>
  <div style="width: 1100px; height: 640px; margin-left:8px" align="center">
  
  <div style="float: left; padding-left:50px;">
   <div id="chart"><c:out value="${chartData1}" escapeXml="false" /></div>  
   <div id="chart1" style="padding-top:20px"><c:out value="${chartData2}" escapeXml="false"/></div>
  </div> 
  <div style="float: right; padding-right:50px;">
   <div id="chart2"><c:out value="${chartData3}" escapeXml="false" /></div>
   <div id="chart3" style="padding-top:20px"><c:out value="${chartData4}" escapeXml="false" /></div>
  </div>
  

  
  
</div>

 </div>
</body>
</html>