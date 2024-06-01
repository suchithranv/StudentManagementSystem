<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="/student-management/resources/css/login-css.css">
</head>
<body style="background-color: #FFCEFE">
<div class="login-page" style="float: left; padding-left:200px">
  <div class="form">
    <form action="processLogin" method="post">
      <h3 style="font-family:Roboto,sans-serif;" align="center">Admin Login</h3>
      <input type="text" placeholder="username" name="username"/>
      <input type="password" placeholder="password" name="password" />
      <input type="submit" value="Login" />
    </form>
    </div>
</div>
<div class="login-page" style="float: right; padding-right:200px">
  <div class="form">
    <form action="processStudentLogin" method="post">
      <h3 style="font-family:Roboto,sans-serif;" align="center">Student Login</h3>
      <label style="color:red">${error}</label>
      <input type="text" placeholder="username" name="email"/>
      <input type="password" placeholder="password" name="password" />
      <input type="submit" value="Login" />
    </form>
    </div>
</div>
</body>
</html>





