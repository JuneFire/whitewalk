package com.whitewalk.entity;
/**
 * 图书：节
* @Title: BookSection.java 
* @package: com.whitewalk.entity 
* @description: 
* @time: 2015年8月28日 上午10:11:48 
* @version : V1.0
 */
public class BookSection {
	/**
	 * 编号
	 */
	private int id;
	
	/**
	 * 图书编号
	 */
	private int bookId;
	
	
	/**
	 * 标题
	 */
	private String sectionTitle;
	
	
	/**
	 * 开始页码
	 */
	private int startPageNum;
	
	/**
	 * 结束页码
	 */
	private int endPageNum;
	
	
	
	
	/**
	 * 节内容
	 */
	private String sectionContent;
	
	
	


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


	
	public String getSectionTitle() {
		return sectionTitle;
	}


	public void setSectionTitle(String sectionTitle) {
		this.sectionTitle = sectionTitle;
	}


	public String getSectionContent() {
		return sectionContent;
	}


	public void setSectionContent(String sectionContent) {
		this.sectionContent = sectionContent;
	}


	public int getStartPageNum() {
		return startPageNum;
	}


	public void setStartPageNum(int startPageNum) {
		this.startPageNum = startPageNum;
	}


	public int getEndPageNum() {
		return endPageNum;
	}


	public void setEndPageNum(int endPageNum) {
		this.endPageNum = endPageNum;
	}


	
	
	
	

}
