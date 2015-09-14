<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>


<base href="<%=basePath%>">

<title>幽灵阅读 | white walker</title>
<link rel="stylesheet" href="styles/css/vendor/bootstrap.css">
<link rel="stylesheet" href="styles/css/flat-ui.css">
<link rel="stylesheet" href="styles/css/doc.css">


</head>

<body>
	<div id="error" class="alert alert-danger alert-dismissible" role="alert">
		<p align="center" class="gs-text-sm">&nbsp;&nbsp;&nbsp;<small id="error-message">{message}</small></p>
	</div>
	<div id="container" class="container" style="overflow:scroll;">
		<nav id="navbar" class="navbar navbar-inverse navbar-embossed navbar-fixed-top" role="navigation"
       style="top: -108px;">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                </button>
                <a class="navbar-brand" href="index.html">幽灵阅读</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <form class="navbar-form navbar-left" action="javascript:;" role="search">
                    <div class="form-group">
                        <div class="input-group">
                            <input class="form-control" id="navbar-input" type="search" placeholder="搜索作品 / 电子书 / 作者 / 专栏 / 出版社" style="width: 400px; font-size: 13px;"> <span
                                class="input-group-btn">
								<button type="submit" class="btn">
                                    <span class="fui-search"></span>
                                </button>
							</span>
                        </div>
                    </div>
                </form>
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="javascript:;" title="注册用户数"><span class="fui fui-user"></span><b class="author-num"><s:property value="#session.userCount"/></b></a>
                    </li>
                    <li>
                        <a href="javascript:;" title="原创作品数量"><span class="fui fui-document"></span><b class="book-num"><s:property value="#session.bookCount"/></b></a>
                    </li>
                    <li>
                        <a href="javascript:;" title="签约作者数"><span class="fui glyphicon glyphicon-edit"></span><b class="column-num"><s:property value="#session.authorCount"/></b></a>
                    </li>
                </ul>
            </div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">原创作品</a></li>
                    <li><a href="javascript:;">电子图书</a></li>
                    <li><a href="javascript:;">专栏<span class="navbar-unread"></span></a></li>
                    <li><a href="javascript:;">连载</a></li>
                    <li><a href="javascript:;">免费</a></li>
                    <li><a href="javascript:;">学生计划</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                	 <c:if test="${!empty userInfo}">
                    <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><img
                            src="styles/images/character/green.jpg" height="20"
                            width="20" class="img-circle hidden-xs"> ${userInfo.userName} <b class="caret"></b><span
                            class="navbar-unread"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="userinfo/userId=${userInfo.userId}"><span class="navbar-icon fui-user"
                                                  aria-hidden="true"></span>个人资料</a></li>
                            <li><a href="userinfo/userId=${userInfo.userId}"><span class="navbar-icon fui-document"
                                                  aria-hidden="true"></span>我的书签
                                                  <c:if test="${markCount!=0}">              
                                   				<span class="badge">${markCount}</span>
             				                      </c:if>
                                                  
                                                  </a></li>
                            <li><a href="userinfo/userId=${userInfo.userId}"><span class="navbar-icon fui-bookmark"
                                                  aria-hidden="true"></span>我的收藏
                                                   <c:if test="${collectionCount!=0}">              
                                   				<span class="badge">${collectionCount}</span>
             				                      </c:if>
                                                  
                                                  </a></li>
                            <li><a href="userinfo/userId=${userInfo.userId}#"><span class="navbar-icon fui-chat"
                                                  aria-hidden="true"></span>消息中心
                                   <c:if test="${messageCount!=0}">              
                                   <span class="badge">${messageCount}</span>
                                   </c:if>
                                    
                                   </a></li>
                            <li class="divider"></li>
                            <li><a href="loginout"><span class="navbar-icon fui-power"
                                                  aria-hidden="true"></span>账号登出</a></li>
                        </ul>
                    </li>
                    </c:if>
                    <c:if test="${empty userInfo}">
						<li style="margin-top:10px"><button onclick="turnSigin()" class="btn btn-primary btn-sm btn-sign gs-text-md" style="margin-right:20px">Sign in</button><button onclick="turnSingup()" class="btn btn-success btn-sm btn-sign gs-text-md">Sign up</button></li>
						</c:if>
                    <li><a href="#" class="dropdown-toggle" data-toggle="dropdown"><span
                            class="visible-xs">Settings<span class="fui-gear"></span></span><span
                            class="visible-sm visible-md visible-lg"><span class="fui-gear"></span></span></a>
                        <ul class="dropdown-menu">
                            <li id="li-dark"><a href="#" id="dark"><span class="fui-eye" aria-hidden="true"></span> Dark</a>
                            </li>
                            <li><a href="#"><span class="fui-question-circle" aria-hidden="true"></span> FAQ</a></li>
                        </ul>
                    </li>
                   <li><a id="pin-triggle" class="pin-triggle-show" href="javascript:;"><span
							class="glyphicon glyphicon-pushpin" aria-hidden="true"></span></a></li>
                </ul>
            </div>
        </div>
        <!-- /.navbar-collapse -->
    </nav>
    <!-- /navbar -->
    <script>
    function turnSigin(){
    	window.location.href="/whitewalk/login";
    }
    function turnSingup(){
    	window.location.href="/whitewalk/register";
    }
    
    </script>
		
		
		<!-- /.navbar-collapse --> </nav>
		<!-- /navbar -->

		<!-- Main page content-->
		<div id="paper" class="content">
			<div class="hd">
				<h3><s:property value="book.title"/></h3>
				<hr>
			</div>

			<div class="bd">
				<h3 id=""><s:property value="book.title"/></h3>
				<span>
				
					
					<s:iterator value="list" id="bookSectionView">
						<h3 id="${bookSectionView.title}">${bookSectionView.title}</h3>
						${bookSectionView.content}
					</s:iterator>
				</span>
					
			</div>

			<div class="ft">199</div>

			<aside class="aside-controls">
			<div class="buttons">
				<ul>
					<li class="controls-item"><a><span
							class="fui-list-bulleted"></span></a></li>
					<li class="controls-item"><a><span class="fui-bookmark"></span></a></li>
					<li class="controls-item"><a><span class="fui-document"></span></a></li>
				</ul>
			</div>
			</aside>

			<div class="page-favorite">
				<a href="javascript:;" style="cursor:pointer"><span class="glyphicon glyphicon-bookmark"></span></a>
			</div>
		</div>
		<!-- main page content -->

		<!-- Toc panel-->
		<div class="panels-container">
			<section class="toc control-panel content-panel"
				style="display: none;">
			<div class="hd">
				<h3>目录</h3>
			</div>

			<div class="bd">
				<ul>
					
					
					<c:forEach var="section" items="${sectionList}">
							<li><a href="javascript:;"onclick="scrollTo(this)" class="toc-item">${section.sectionTitle}</a><span class="num">${section.startPageNum}</span></li>
					</c:forEach>
					
				
				</ul>
			</div>
			</section>
		</div>
		<!-- toc panel-->
		<script>
			function scrollTo(obj){
			 var id=$(obj).html();
			 $('.panels-container .toc').fadeOut();
			 location.hash="#"+id;
			}
	
		</script>
		<!-- Bookmark panel-->
		<div class="panels-container">
			<section class="bookmark control-panel content-panel"
				style="display: none;">
			<div class="hd">
				<h3>书签</h3>
			</div>

			<div class="bd">
				<ul>
					<li>
						<h3>设计巨匠——乔纳森·艾维（Jonathan Ive ）</h3>

						<div>
							<a href="#">
								<ul class="bm-detail">
									<li><span
										class="bm-progress glyphicon glyphicon-bookmark color-green"></span>
										<span class="bm-progress">54%</span><span class="date">2015-08-29
											15:20</span></li>
									<li><p class="info">...2010年《财富》杂志将其评选为『世界上最聪明的设计师』</p></li>
								</ul>
							</a>
						</div>
					</li>
					<li>
						<h3>敬畏之心</h3>

						<div>
							<a href="#">
								<ul class="bm-detail">
									<li><span
										class="bm-progress glyphicon glyphicon-bookmark color-green"></span>
										<span class="bm-progress">68%</span><span class="date">2015-08-29
											21:39</span></li>
									<li><p class="info">古诗有云，“冯唐易老，李广难封”，冯唐当然是他的笔名</p></li>
								</ul>
							</a>
						</div>
					</li>
				</ul>
			</div>
			</section>
		</div>
		<!-- bookmark panel-->

		<!-- Document panel-->
		<div class="panels-container">
			<section class="document control-panel content-panel"
				style="display: none;"> </section>
		</div>
		<!-- document panel-->
	</div>

	<!-- Read detail-->
	<div class="page-detail">
		<div class="page-subsequent">
			<span>本章剩余 </span>6 <span>页</span>
		</div>
		<div class="page-portal">
			<div class="page-info">
				<span class="curr-num">595</span> <span class="slash">/</span> <span
					class="total-num">764</span> <span class="progress-num">0.00%</span>
				<a href="javascript:;" class="page-form-switch"><span
					class="fui-triangle-up-small"></span></a>
			</div>
			<div class="page-jump" style="display: none">
				<form class="page-form form-group">
					<button type="submit" class="btn btn-sm btn-primary page-submit">
						<span class="fui-check"></span>
					</button>
					<input type="text" value="595" class="form-control page-input">
				</form>
				<span class="page-custom-text">当前页</span>
			</div>
		</div>
	</div>
	<!-- read detail -->

	<!-- Read tools -->
	<div class="reading-tools">
		<aside class="aside">
		<ul class="panels">
			<li class="seq fn-back">
			<a  href="javascript:turnBack();" class="glyphicon glyphicon-arrow-left"></a></li>
			<li class="fn-share"><a href="javascript:share(<s:property value="book.bookId"/>)"
				class="glyphicon glyphicon-share"></a></li>
			<li class="fn-print"><a href="javascript:print(<s:property value="book.bookId"/>)"
				class="glyphicon glyphicon-print"></a></li>
			<li class="seq fn-rating"><a href="javascript:grade(<s:property value="book.bookId"/>)" class="fui-star-2"></a></li>
			<li class="seq fn-favor">
			<a href="javascript:addCollection(<s:property value="book.bookId"/>)" class="glyphicon glyphicon-heart"></a></li>
			<li class="seq fn-comment"><a href="javscript:;"
				class="glyphicon glyphicon-edit"></a></li>
			<li class="seq fn-search"><a href="javascript:;"
				class="glyphicon glyphicon-search"></a></li>
			<li class="fn-helper"><a href="#" class="">指南</a></li>
		</ul>
		</aside>
	</div>
	<!-- read tools -->
	
	<!-- Read progress-->
	<progress id="reading-progress" max="100" class="pos-bottom" value="0.0"></progress>
<!-- /footer -->
<script>
	function turnBack(){
		if(confirm("确认返回?")){
			window.location.href="/whitewalk/homepage/index";
		}
		else {
			
		}
	}
	function addCollection(bookid){
		
		fadeIn("收藏成功");
	}
	
	function share(bookid){
		
		fadeIn("分享成功");
	}
	function grade(bookid){
		
		fadeIn("感谢您的评论");
	}
	function print(bookid){
		
		document.execCommand("print");
		
		
	}
	
	
	
	
	//提示效果
	function fadeIn(message) {
		$("#error-message").html(message);
		$("#error").addClass('show');
		setTimeout("$('#error').fadeOut(500)", 1000);
		setTimeout("$('#error').removeClass('show')", 1500);
	}

	
</script>

	
</body>


<script src="styles/js/vendor/jquery.min.js"></script>
<script src="styles/js/flat-ui.js"></script>
<script src="styles/js/assets/prettify.js"></script>
<script src="styles/js/assets/application.js"></script>
<script src="styles/js/doc.js"></script>
	
</body>
</html>
