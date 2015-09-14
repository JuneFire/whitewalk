package com.whitewalk.entity;
/**
 * 图书标签
* @Title: BookLable.java 
* @package: com.whitewalk.entity 
* @description: 
* @time: 2015年8月28日 上午9:39:51 
* @version : V1.0
 */
public class BookLable {
	
	/**
	 * 编号
	 */
	private int id;
	
	
	/**
	 * 
	 */
	private int bookId;
	
	
	/**
	 * 标签类别id
	 */
	private BookLableType bookLableType;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	

	


	public int getBookId() {
		return bookId;
	}


	public void setBookId(int bookId) {
		this.bookId = bookId;
	}


	public BookLableType getBookLableType() {
		return bookLableType;
	}


	public void setBookLableType(BookLableType bookLableType) {
		this.bookLableType = bookLableType;
	}
	
	
	
}
