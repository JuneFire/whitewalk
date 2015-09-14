package com.whitewalk.action;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.whitewalk.entity.UserInfo;
import com.whitewalk.service.UserInfoService;
import com.whitewalk.service.UserMessageService;
import com.whitewalk.util.CglibProxy;

public class UserInfoAction extends ActionSupport {
	
	
	private UserInfoService userInfoService = (UserInfoService) new CglibProxy().getProxy(UserInfoService.class);
	
	private UserInfo userInfo = new UserInfo();
	
	
	private String result;
	private String userName;
	private String userPwd;
	
	
	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	

	public String showPage() {
		String result = "success";
		return result;
	}

	public String register() {
		String result = "";
		List<UserInfo> list = userInfoService.findUserInfoByUserName(userInfo.getUserName());
		if (list.size()!=0) {
			for (UserInfo userInfo : list) {
				System.out.println(userInfo.getUserName());
			}
			result = "error";
		} else {
			if (userInfo.getUserName() != null && userInfo.getUserPwd()!=null) {
				result = "success";
				userInfoService.saveUserInfo(userInfo);
			} else {
				result = "input";
			}
		}
		return result;

	}
	//检查用户名是否存在
	public String checkUserNameIsExist(){
		
		List<UserInfo> list = userInfoService.findUserInfoByUserName(userName);
		if(list.size()!=0){
			result = "false";
		}else if(list.size()==0){
			result = "true";
		}
		
		return Action.SUCCESS;

	}
	
	public String checkPassword(){
		UserInfo userInfoLogin = null;
		UserInfo userInfoCheck = new UserInfo();
		userInfoCheck.setUserName(userName);
		userInfoCheck.setUserPwd(userPwd);
		
		userInfoLogin = userInfoService.login(userInfoCheck);
		if(userInfoLogin!=null){
			result = "true";
		}else{
			result = "false";
		}
		return Action.SUCCESS;
		
	}
	
	public String doLogin(){
		String result = "";
		UserInfo userInfoLogin = null;
		userInfoLogin = userInfoService.login(userInfo);
		if(userInfoLogin!=null){
			ActionContext actionContext = ActionContext.getContext();
			actionContext.getSession().put("userInfo", userInfoLogin);
			
		
			result = "success";
		}else{
			
			result = "error";
		}
		return result;
	}
	
	public String userloginOut(){
		
		System.out.println("开始执行登出方法....");
		ActionContext.getContext().getSession().remove("userInfo");
		
		return SUCCESS;
	}
	
}
