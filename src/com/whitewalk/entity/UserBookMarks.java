package com.whitewalk.entity;
/**
 * 书签类
* @Title: UserBookMarks.java 
* @package: com.whitewalk.entity 
* @description: 
* @time: 2015年9月1日 上午10:34:55 
* @version : V1.0
 */
public class UserBookMarks {
	
	/**
	 * 编号
	 */
	private int id;
	
	/**
	 * 用户编号
	 */
	private int userId;
	
	/**
	 * 图书编号
	 */
	private int bookId;
	
	/**
	 * 图书的阅读位置
	 */
	private String bookReadPosition;
	
	/**
	 * 添加时间
	 */
	private String addDate;


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


	public String getBookReadPosition() {
		return bookReadPosition;
	}


	public void setBookReadPosition(String bookReadPosition) {
		this.bookReadPosition = bookReadPosition;
	}


	public String getAddDate() {
		return addDate;
	}


	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	
	
	
	

}
