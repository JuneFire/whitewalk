package com.whitewalk.entity;
/**
 * 用户消息类
* @Title: UserMessage.java 
* @package: com.whitewalk.entity 
* @description: 
* @time: 2015年9月1日 上午10:30:44 
* @version : V1.0
 */
public class UserMessage {
	
	public final static int HAVEREAD=1;
	
	
	public final static int NOREAD=0;
	
	/**
	 * 编号
	 */
	private int id;
	
	
	/**
	 * 用户编号
	 */
	private int userId;
	
	
	/**
	 * 内容
	 */
	private String content;
	
	/**
	 * 发送时间
	 */
	private String date;
	
	
	/**
	 * 是否已读
	 */
	private int isRead=NOREAD;


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


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public int getIsRead() {
		return isRead;
	}


	public void setIsRead(int isRead) {
		this.isRead = isRead;
	}
	
	
	
	
	
}
