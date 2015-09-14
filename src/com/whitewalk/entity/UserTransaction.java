package com.whitewalk.entity;
/**
 * 交易表，记录用户消费或充值记录
* @Title: Transaction.java 
* @package: com.whitewalk.entity 
* @description: 
* @time: 2015年8月27日 下午7:14:17 
* @version : V1.0
 */
public class UserTransaction {
	
	/**
	 * 交易类型：充值
	 */
	public final static int RECHARGE =0;
	
	/**
	 * 交易类型：充值VIP
	 */
	public final static int RECHARGEFORVIP =1;
	
	/**
	 * 交易类型：打赏
	 */
	public final static int exceptional =2;
	
	
	/**
	 * 交易ID
	 */
	private int id;
	
	
	/**
	 * 用户信息
	 * 一次交易记录对应一个用户
	 */
	private UserInfo userInfo;
	
	
	/**
	 * 交易金额
	 */
	private int amount;
	
	/**
	 * 交易类型
	 */
	private int translateType;
	
	/**
	 * 交易日期
	 */
	private String translateDate;
	
	
	/**
	 * 备注
	 */
	private String remark;


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


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public int getTranslateType() {
		return translateType;
	}


	public void setTranslateType(int translateType) {
		this.translateType = translateType;
	}


	public String getTranslateDate() {
		return translateDate;
	}


	public void setTranslateDate(String translateDate) {
		this.translateDate = translateDate;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}
