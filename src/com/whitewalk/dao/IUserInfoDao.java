package com.whitewalk.dao;

import java.util.List;

import com.whitewalk.entity.UserInfo;

public interface IUserInfoDao {
	
	void saveUserInfo(UserInfo userInfo);
	
	List<UserInfo> findUserInfoByUserName(String userName);
	
	int findUserCount();
	
	
	
	UserInfo login(UserInfo userInfo);
}
