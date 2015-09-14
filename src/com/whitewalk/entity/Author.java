package com.whitewalk.entity;
/**
 * 作者
* @Title: Author.java 
* @package: com.whitewalk.entity 
* @description: 
* @time: 2015年8月28日 上午10:22:17 
* @version : V1.0
 */
public class Author {
	
	/**
	 * 编号
	 */
	private int id;
	
	/**
	 * 用户编号
	 */
	private int userId;
	
	
	/**
	 * 笔名
	 */
	private String penName;
	
	
	/**
	 * 邮箱
	 */
	private String mail;
	
	
	/**
	 * 真实姓名
	 */
	private String realname;
	
	
	/**
	 * 身份证号
	 */
	private String idCard;
	
	
	/**
	 * 电话号码
	 */
	private String tel;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getPenName() {
		return penName;
	}


	public void setPenName(String penName) {
		this.penName = penName;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getRealname() {
		return realname;
	}


	public void setRealname(String realname) {
		this.realname = realname;
	}


	public String getIdCard() {
		return idCard;
	}


	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
	
}
