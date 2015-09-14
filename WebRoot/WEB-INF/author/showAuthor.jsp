<%@ page language="java" import="java.util.*,com.whitewalk.entity.Author" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'error.jsp' starting page</title>
    
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
    <table	width="900px">
    	<tr>
    		<td colspan="3" >作者id</td>
    		<td colspan="3" >用户id</td>
    		<td colspan="3" >真名</td>
    		<td colspan="3" >笔名</td>
    		<td colspan="3" >邮箱</td>
    		<td colspan="3" >身份证号</td>
    		<td colspan="3" >Tel</td>
    		<td  colspan="3" align="" >操作</td>
    		<td><a href="showPage.action">添加</a></td>
    	
    
    	</tr>
    	<%
    	List<Author> list =(ArrayList<Author>)request.getAttribute("list");
    	if(list!=null){
    		for(Author a:list){
    	%>
    	<tr>
    	<td colspan="3" ><%=a.getId()%></td>
    	<td colspan="3" ><%=a.getUserId()%></td>
    	<td colspan="3" ><%=a.getRealname()%></td>
    	<td colspan="3" ><%=a.getPenName()%></td>
    	<td colspan="3" ><%=a.getMail()%></td>
    	<td colspan="3" ><%=a.getIdCard()%></td>
    	<td colspan="3" ><%=a.getTel()%></td>
    	<td><a href="<%=path%>/authorPage/deleteAuthor.action?authorId=<%=a.getId()%>" onclick="javascript:return confirm('确定删除？');">删除</a></td>
    	<td><a href="<%=path%>/authorPage/findAuthorbyid.action?authorId=<%=a.getId()%>">修改</a></td>
    	</tr>
    	<%}
    	}
    	else{
			%>
			list为空</br>
			<%
		}
    	%>
    </table>
  </body>
</html>
