<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'authorReg.jsp' starting page</title>
    
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
   <form action="authorPage/authorReg" method="post">
  	 id:&nbsp&nbsp<input type="text" name="author.id"> <br>
  	 UserId:<input type="text" name="author.userId"> <br>
 	 mail:&nbsp<input type="text" name="author.mail">	<br>
 	 realName:<input type="text" name="author.realname">	<br>
 	 penName: <input type="text" name="author.penName">	<br>
 	 idCard: <input type="text" name="author.idCard">	<br>
 	 Tel:&nbsp&nbsp<input type="text" name="author.tel">	<br>
  <input type="submit" value="提交">
  </form>
  </body>
</html>
