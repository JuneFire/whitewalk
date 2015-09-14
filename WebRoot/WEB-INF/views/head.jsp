<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<nav id="navbar" class="navbar navbar-inverse navbar-embossed navbar-fixed-top" role="navigation"
        >
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