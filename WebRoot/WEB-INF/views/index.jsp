<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<meta charset="UTF-8">
    <base href="<%=basePath%>">
    
  	<link rel="stylesheet" href="styles/css/vendor/bootstrap.css">
    <link rel="stylesheet" href="styles/css/flat-ui.css"> 
    <link rel="stylesheet" href="styles/css/doc.css"> 
    
    <link rel="stylesheet" type="text/css" href="styles/css/index.css">
	<link rel="stylesheet" type="text/css" href="styles/css/buttons.css">
    
    <script src="styles/js/jquery.min.js"></script>
    <script src="styles/js/laytpl.js"></script>
    <title>首页</title>
    
	<style>
        .navbar-icon {
            float: right;
        }

        .navbar-new {
            margin-right: 20px;
        }
    </style>

  </head>
  
  <body>
  	<!-- 定义html模板 -->
  	<script id="template" type="text/html"> 
					<li  class="section">
						<a href="read/book?bookid={{d.bookId}}">
						<img src="bookImages/{{d.bookImageUrl}}"/>
						<span class="title">{{d.title}}</span>
						</a>
						<div class="bookhide">
							<span style="margin-left:15px;margin-top:-6px;">评分:{{d.grade}}</span>
							<span style="float: right;margin-right:10px;margin-top:-6px;">点击量:{{d.hits}}</span>
							<a href="read/book?bookid={{d.bookId}}" class="button button-small-caps button-primary">阅读</a>
						</div>
						
					</li>
	</script>
  
  
  	<!-- 首部 -->
  	<%@include file="head.jsp"%>
  
  
  
  
   	<div class="bookcontent">
		<hr/>
		<div class="left">
			<div class="nav-tap">
				<div class="item" style="background-color:#d1ea78;margin-left:5px">
					<a href="javascript:showHits();">人气榜</a></div>
				
				<div class="item" style="background-color:#ffda60">
					<a href="javascript:showGrade();">好评榜</a>
	
				</div>
			</div>
			
			
			<div id="hitscontent" class="nav-content hits">
				<s:iterator value="listHits" id="book" status="l">
				<div class="items">
					<em><s:property value="#l.count"/>.      书名:</em>
					<a onclick="showmessage(this)" href="javascript:;" title="<s:property value="title"/>" class="title" hidefocus="hidefocus" target="_blank"><s:property value="title"/></a>
					<p class="u-author" title="<s:property value="author"/>"> 
						作者:<span ><s:property value="author"/></span>
					</p>
				</div>
				<div class="items" style="display:none;font-size:10px;padding:2px;">
					<s:property value="synopsis"/>
					......<a href="read/book?bookid=<s:property value="bookId"/>" style="float:right">查看更多</a>
				</div>
				</s:iterator>
				
			</div>
			<div id="gradecontent" class="nav-content grade" style="display:none">
				<s:iterator value="listGrade" id="book" status="l">
				<div class="items">
					<em><s:property value="#l.count"/>.      书名:</em>
					<a onclick="showmessage(this)" href="javascript:;" title="<s:property value="title"/>" class="title" hidefocus="hidefocus" target="_blank"><s:property value="title"/></a>
					<p class="u-author">
						作者:<span title="<s:property value="title"/>"><s:property value="author"/></span>
					</p>
					
				</div>
				<div class="items" style="display:none;font-size:10px;">
					<s:property value="synopsis"/>
					.....<a href="read/book?bookid=<s:property value="bookId"/>" style="float:right">查看更多</a>
				</div>
				</s:iterator>
				
			</div>

		</div>
		<div class="right">
				<div class="rightcontenthead">
					<span>精品推荐</span>
					<a id ="rfeshdata" class="refeshdata" title="换一批" href="javascript:getNextPage();" data-totalpage="${totalPage}" data-currentpage="${currentPageNum}">换一批<img src="styles/images/refresh.png" /></a>
				</div>
				
				<div id="bookcontent" class="content">
					
					<s:iterator value="listBooks" id="book">
					<li  class="section">
						<a href="read/book?bookid=<s:property value="bookId"/>">
						<img src="bookImages/<s:property value="bookImageUrl"/>"/>
						<span class="title"><s:property value="title"/></span>
						</a>
						<div class="bookhide">
							<span style="margin-left:15px;margin-top:-6px;">评分:<s:property value="grade"/></span>
							<span style="float: right;margin-right:10px;margin-top:-6px;">点击量:<s:property value="hits"/></span>
							<a href="read/book?bookid=<s:property value="bookId"/>" class="button button-small-caps button-primary">阅读</a>
						</div>
						
					</li>
					</s:iterator>
				</div>
				

		</div>
	</div>
   
   <script>
   //显示点击榜
   function showHits(){
	 
	   $("#gradecontent").hide();
	   $("#hitscontent").show();
	   
   }
   //显示好评榜
   function showGrade(){
	   
	   $("#hitscontent").hide();
	   $("#gradecontent").show();
   }
   //显示图书的简介
   function showmessage(obj){
		//获取点击元素的所有同胞元素
		
	  	$(obj).parent().next().slideToggle("2000");
   }
   function getNextPage(){
	   
	   $("#bookcontent").hide();
	   var json=getData();
	   
	   var data=eval(json);
	  
	   //加载模板
	   var gettpl=document.getElementById("template").innerHTML;
	   //清除数据
	   $("#bookcontent").empty();
	   
	   $.each(data, function (index, item) {  
	       
			laytpl(gettpl).render(data[index],function(html){
				//将包含数据的html内容添加至页面中
			
			    $("#bookcontent").append(html);
			});
		 });
	   $("#bookcontent").fadeIn();
	  
   }
   function getData(){
	   var bookData="";
	   var totalpage=parseInt($("#rfeshdata").attr("data-totalpage"));
	   var currentpage=parseInt($("#rfeshdata").attr("data-currentpage"));
	   
	   $.ajax({
			async : false,// 异步或同步
			type : "POST",// http方法
			url : "/whitewalk/getNextPage",// 请求地址
			
			data :{
				totalPage : totalpage,
				currentPageNum:currentpage
			},
			dataType : "json",// 返回的解析格式
			error : function(data) {
				alert("请求失败");
			},
			success : function(data) {
				
				
				
				$("#rfeshdata").attr("data-currentpage",data.currentPageNum);
				bookData=data.list;
				
		}
		});
	   return bookData;
	   
   }
   
   
   </script>
   
   
    <script src="styles/js/flat-ui.js"></script>
	<script src="styles/js/assets/prettify.js"></script>
	<script src="styles/js/assets/application.js"></script>
</html>
   
  </body>
</html>
