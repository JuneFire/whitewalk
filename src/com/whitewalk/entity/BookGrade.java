package com.whitewalk.entity;
/**
 * 图书评分
 */
public class BookGrade {
	
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
	 * 评分[1-10]
	 */
	private int grade;


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


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
	
	
}
