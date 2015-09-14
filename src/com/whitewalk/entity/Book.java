package com.whitewalk.entity;

import java.io.Serializable;

/**
 * 图书类
* @Title: Book.java 
* @package: com.whitewalk.entity 
* @description: 
* @time: 2015年8月28日 上午9:42:15 
* @version : V1.0
 */

public class Book implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5422081726681985502L;


	/**
	 * 编号
	 */
	private int bookId;
	
	
	/**
	 * 图书标题
	 */
	private String title;
	
	
	/**
	 * 作者
	 */
	private String author;
	
	
	/**
	 * 版权
	 */
	private String copyright;
	
	/**
	 * 出版日期
	 */
	private String publishDate;
	
	
	/**
	 *简介
	 */
	private String synopsis;
	
	
	/**
	 * 字数
	 */
	private String wordnumber;
	
	
	/**
	 * 大小
	 */
	private String bookSize;
	
	
	/**
	 * 书号
	 */
	private String bookNumber;
	
	
	/**
	 * 最后更新时间
	 */
	private String updateDate;
	
	/**
	 * 点击量
	 */
	private int hits;
	
	
	/**
	 * 评分[1-10]
	 */
	private int grade;

	
	/**
	 * 图书分页图片
	 * @return
	 */
	private String bookImageUrl;

	

	public int getBookId() {
		return bookId;
	}


	public void setBookId(int bookId) {
		this.bookId = bookId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getCopyright() {
		return copyright;
	}


	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}


	public String getPublishDate() {
		return publishDate;
	}


	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}


	public String getSynopsis() {
		return synopsis;
	}


	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}


	public String getWordnumber() {
		return wordnumber;
	}


	public void setWordnumber(String wordnumber) {
		this.wordnumber = wordnumber;
	}


	public String getBookSize() {
		return bookSize;
	}


	public void setBookSize(String bookSize) {
		this.bookSize = bookSize;
	}


	public String getBookNumber() {
		return bookNumber;
	}


	public void setBookNumber(String bookNumber) {
		this.bookNumber = bookNumber;
	}


	public String getUpdateDate() {
		return updateDate;
	}


	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}


	public int getHits() {
		return hits;
	}


	public void setHits(int hits) {
		this.hits = hits;
	}


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}


	public String getBookImageUrl() {
		return bookImageUrl;
	}


	public void setBookImageUrl(String bookImageUrl) {
		this.bookImageUrl = bookImageUrl;
	}



	
	
	
}
