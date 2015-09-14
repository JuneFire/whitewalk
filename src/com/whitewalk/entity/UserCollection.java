package com.whitewalk.entity;
/**
 * 用户阅读记录
 * 记录用户阅读图书时的阅读位置，方便用户下次重新阅读该书时定位到原阅读位置
* @Title: UserCollection.java 
* @package: com.whitewalk.entity 
* @description: 
* @time: 2015年8月28日 上午9:54:18 
* @version : V1.0
 */
public class UserCollection {
	
	
	/**
	 * 编号
	 */
	private int id;
	
	/**
	 * 用户信息
	 */
	private int userId;
	
	
	/**
	 * 图书信息
	 */
	private int  bookId;
	
	
	/**
	 * 阅读进度
	 */
	private String readschedule;
	
	/**
	 * 最后一次阅读日期
	 */
	private String collectDate;

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

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getReadschedule() {
		return readschedule;
	}

	public void setReadschedule(String readschedule) {
		this.readschedule = readschedule;
	}

	public String getCollectDate() {
		return collectDate;
	}

	public void setCollectDate(String collectDate) {
		this.collectDate = collectDate;
	}
	
	
	
	
	
}
