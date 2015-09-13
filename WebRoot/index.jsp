<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<h1 align="center" style="color:#000000">欢迎登录</h1>
<form action = "user_login.do"><table align=center>
	<tr><td><h3>用户名：</h3></td><td><input type="text" name="uname"/></td></tr>
    <tr><td><h3>密码：</h3></td><td><input type="password" name="upassword"/></td></tr>
    <tr><td><input type="submit" value="登录"/></td><td><input type="reset" value="重填"/></td></tr>
</table></form>
  </body>
</html>
