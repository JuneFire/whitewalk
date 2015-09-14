//注册验证
function checkSignup() {

	var signup_name = $("#signup-name");
	var passwd = $("#signup-pass");
	var check_pass = $("#signup-passsecond");

	var passwd_str = /^\w{6,15}/;

	var password = passwd_str.test(passwd.val());

	if (signup_name.val().length < 3) {
		addErrorMessage(signup_name, "Wrong user name!");
		return false;
	}

	if (signup_name.val().length > 20) {
		addErrorMessage(signup_name, "Wrong user name!");
		return false;
	}
	
	if (!checkUserNameIsExist(signup_name.val())) {
		addErrorMessage(signup_name, "The username has been registered！");
		return false;
	}

	if (!password) {
		addErrorMessage(passwd, "Weak password! ");
		return false;
	}

	if (check_pass.val()!=passwd.val()) {
		addErrorMessage(check_pass, "Password is not the same!");
		return false;
	}
}
function checkUserNameIsExist(userName) {
	var isExist = false;// 重名存在

	$.ajax({
		async : false,// 异步或同步
		type : "POST",// http方法
		url : "/whitewalk/checkUserNameIsExist",// 请求地址
		data : {// 请求数据:用户名
			userName : userName
		},
		dataType : "json",// 返回的解析格式
		error : function(data) {
			alert("请求失败");
		},
		success : function(data, status) {
			if (data == "true")
				isExist = true;
		}
	});
	return isExist;
}

function checkPassword(userName, userPwd) {
	var isExist = false;// 不匹配

	$.ajax({
		async : false,// 异步或同步
		type : "POST",// http方法
		url : "/whitewalk/checkPassword",// 请求地址
		data : {// 请求数据:用户名
			userName : userName,
			userPwd : userPwd
		},
		dataType : "json",// 返回的解析格式
		error : function(data) {
			alert("请求失败");
		},
		success : function(data, status) {
			if (data == "true")
				isExist = true;
		}
	});
	return isExist;

}

// 登录验证
function checkSignin() {
	var login_name = $("#login-name");
	var login_pass = $("#login-pass");

	if (login_name.val().length < 3) {
		addErrorMessage(login_name, "Wrong user name!");
		return false;
	} else {
		removeErrorMessage(login_name);

		if (checkUserNameIsExist(login_name.val())) {
			addErrorMessage(login_name, "UserName is not exist!");
			return false;
		} else {
			removeErrorMessage(login_name);
			if (login_pass.val().length < 6) {
				addErrorMessage(login_pass, "Is that your account?");
				return false;
			} else {

				removeErrorMessage(login_pass);
				if (!checkPassword(login_name.val(), login_pass.val())) {
					addErrorMessage(login_pass, "Password is not true!");
					return false;
				}

			}
		}
	}
}

function fadeIn(message) {
	$("#error-message").html(message);
	$("#error").addClass('show');
	setTimeout("$('#error').fadeOut(500)", 1000);
	setTimeout("$('#error').removeClass('show')", 1500);
}

function addErrorMessage(node, message) {
	node.focus();
	node.addClass('error-message');
	node.next().addClass('error-message');
	fadeIn(message);
}

function removeErrorMessage(node) {
	node.removeClass('error-message');
	node.next().removeClass('error-message');
}
/*
 * //检查邮箱是否存在 function checkEmailIsExist(userName) { var isExist = false;
 * $.ajax({ async : false,// 异步或同步 type : "POST",// http方法 url :
 * "/gotostuff/register/checkEmailIsExist",// 请求地址 data : {// 请求数据:用户名 userName :
 * userName }, dataType : "json",// 返回的解析格式 error : function(data) {
 * alert("请求失败"); }, success : function(data) { if (data == "true") isExist =
 * true; } }); return isExist; }
 */
// 检查昵称是否存在
