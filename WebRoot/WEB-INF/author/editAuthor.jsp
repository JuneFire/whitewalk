<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'editAuthor.jsp' starting page</title>
    
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
   <form action="updateAuthor" method="post">
  	id:&nbsp&nbsp<input type="text" name="author.id" value="${author.id}" readonly="true"> <br>
  	UserId:<input type="text" name="author.userId" value="${author.userId}"> <br>
 	mail:&nbsp<input type="text" name="author.mail" value="${author.mail}"><br>
 	realName:<input type="text" name="author.realname" value="${author.realname}">	<br>
 	penName: <input type="text" name="author.penName" value="${author.penName}">	<br>
 	idCard:<input type="text" name="author.idCard" value="${author.idCard}">	<br>
 	Tel:&nbsp&nbsp<input type="text" name="author.tel" value="${author.tel}">	<br>
  <input type="submit" value="提交">  <s:reset value="返回" onclick="location='showAuthor'"/>

  </form>
  </body>
</html>
