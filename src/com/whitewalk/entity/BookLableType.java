package com.whitewalk.entity;
/**
 * 图书标签类别
* @Title: BookLableType.java 
* @package: com.whitewalk.entity 
* @description: 
* @time: 2015年8月27日 下午7:27:16 
* @version : V1.0
 */
public class BookLableType {
	
	/**
	 * 标签类别id
	 */
	private int id;
	
	/**
	 * 标签类别名称
	 */
	private String typeName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
	
}
