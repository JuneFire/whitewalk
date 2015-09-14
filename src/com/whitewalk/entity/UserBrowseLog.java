package com.whitewalk.entity;
/**
 * 用户浏览记录
* @Title: UserBrowseLog.java 
* @package: com.whitewalk.entity 
* @description: 
* @time: 2015年8月28日 上午9:58:19 
* @version : V1.0
 */
public class UserBrowseLog {
	
	/**
	 * 编号
	 */
	private int id;
	
	
	/**
	 * 用户信息
	 */
	private UserInfo userInfo;
	
	
	
	/**
	 * 图书信息
	 */
	private Book book;



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public UserInfo getUserInfo() {
		return userInfo;
	}



	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}



	public Book getBook() {
		return book;
	}



	public void setBook(Book book) {
		this.book = book;
	}
	
	
	
}
