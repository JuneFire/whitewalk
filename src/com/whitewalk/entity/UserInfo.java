package com.whitewalk.entity;

public class UserInfo {
	
	/**
	 * 男性性别
	 */
	public final static int MAN=1;
	/**
	 * 女性性别
	 */
	public final static int WOMEN=0;
	
	/**
	 * 默认鬼币数：0
	 */
	public final static int DEFAULTGHOSTB =0;
	
	
	
	
	/**
	 * 用户编号
	 * 主键
	 */
	private int userId;
	
	/**
	 * 用户名，登录凭证
	 */
	private String userName;
	
	/**
	 * 密码
	 */
	private String userPwd;
	
	
	/**
	 * 用户类别
	 */
	private UserType userType;
	
	/**
	 * 鬼币
	 */
	private int userGhostB =DEFAULTGHOSTB;
	
	
	/**
	 * 用户生日
	 */
	private String userBirthday=null;
	
	/**
	 * 用户性别
	 */
	private int userSex;
	
	
	/**
	 * 邮箱
	 */
	private String userMail =null;

	//get...set
	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
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


	public UserType getUserType() {
		return userType;
	}


	public void setUserType(UserType userType) {
		this.userType = userType;
	}


	public int getUserGhostB() {
		return userGhostB;
	}


	public void setUserGhostB(int userGhostB) {
		this.userGhostB = userGhostB;
	}


	public String getUserBirthday() {
		return userBirthday;
	}


	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}


	public int getUserSex() {
		return userSex;
	}


	public void setUserSex(int userSex) {
		this.userSex = userSex;
	}


	public String getUserMail() {
		return userMail;
	}


	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	
	
	
	
	
}
