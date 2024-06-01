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
HttpSession session1 = request.getSession();
session1.removeAttribute("Stname");
session1.invalidate(); // it will remove all the data in that session
response.sendRedirect("showLogin");
%>
</body>
</html>