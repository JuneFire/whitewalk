<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML >
<html>
<head>
<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="Leone Wang">
	<title>幽灵阅读</title>
	<!-- Bootstrap core CSS -->
	<!-- <link href="../assets/flat-ui/css/bootstrap-responsive.css" rel="stylesheet"> -->
	<link rel="stylesheet" href="styles/css/bootstrap.css">
	<link rel="stylesheet" href="styles/css/flat-ui.css">
	<link rel="stylesheet" href="styles/css/demo.css">
	<link rel="shortcut icon" href="styles/images/favicon.ico">
	<style type="text/css">
		body {
			background: #1ABC9C;
			padding-top: 40px;
			padding-bottom: 40px;
		}
	</style>

</head>

<body>
	<div id="error" class="alert alert-danger alert-dismissible" role="alert">
		<p align="center" class="gs-text-sm"><span class="fui-cross-circle"></span>&nbsp;&nbsp;&nbsp;<small id="error-message">{message}</small></p>
	</div>

	<div class="container">
		<div class="login">
			<div class="login-screen">
				<div class="login-icon hidden-sm hidden-xs">
					<a href="homepage/index"><img src="styles/images/Pocket.png" alt="Welcome to GotoStuff" /></a>
					<h4>
						Welcome to <small>White Walk</small>
					</h4>
				</div>
				<form role="form" action="doLogin" onsubmit="return checkSignin();">
					<div class="login-icon-hidden hidden-md hidden-lg">
						<a href="homepage/index"><img src="styles/images/Pocket.png" alt="Welcome to GotoStuff" /></a>
						<h4>Welcome to White Walk</h4>
					</div>
					<div class="login-form">
						<div class="form-group">
						<input type="text" class="form-control login-field" value="" placeholder="Enter your username" id="login-name" name="userInfo.userName" /> <label
							class="login-field-icon fui-user" for="login-name"></label>
						</div>
						<div class="form-group">
							<input type="password" class="form-control login-field" value="" placeholder="Password" id="login-pass" name="userInfo.userPwd" /> <label
							class="login-field-icon fui-lock" for="login-pass"></label>
						</div>
						<input type="submit" class="btn btn-primary btn-lg btn-block" value="Sign in" />
						<div class="row">
							<a class="login-link col-xs-6" href="#">Lost your password?</a> <a class="login-link col-xs-6" href="register">Sign up</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- /container -->
	<!-- Le javascript
	================================================== -->
	<script src="styles/js/jquery.min.js"></script>
	<script src="styles/js/flat-ui.min.js"></script>
	<script src="styles/js/application.js"></script>
	<script src="styles/js/formCheck.js"></script>
</body>

</html>
