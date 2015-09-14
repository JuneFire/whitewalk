package com.whitewalk.entity;

public class UserPayway {
	
	
	/**
	 * 支付方式ID
	 */
	private int id;
	
	/**
	 * 用户ID
	 */
	private int userId;
	
	
	/**
	 * 支付方式账号
	 */
	private String paywayCccount;
	
	
	/**
	 * 支付工具名称
	 */
	private String paywayName;

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

	public String getPaywayCccount() {
		return paywayCccount;
	}

	public void setPaywayCccount(String paywayCccount) {
		this.paywayCccount = paywayCccount;
	}

	public String getPaywayName() {
		return paywayName;
	}

	public void setPaywayName(String paywayName) {
		this.paywayName = paywayName;
	}
	
	
	

}
