<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
String name = request.getParameter("username");
String pass = request.getParameter("password"); 
 %>
 <% 
 if(name.equals("Suchithra") && pass.equals("12345")) 
	{
		//Whenever a user login we will set data into session
			HttpSession session1 = request.getSession();
			session1.setAttribute("Sname", name);
			response.sendRedirect("showDashboard");
	}
	else
	{
		response.sendRedirect("showLogin");
	}
%>  
</body>
</html>