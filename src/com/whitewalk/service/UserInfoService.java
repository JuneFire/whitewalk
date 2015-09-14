package com.whitewalk.service;

import java.util.List;

import com.whitewalk.dao.IUserInfoDao;
import com.whitewalk.entity.UserInfo;
import com.whitewalk.util.Commit;

public class UserInfoService {
	
	
	private IUserInfoDao userInfoDao;
	
	@Commit
	public void saveUserInfo(UserInfo userInfo){
		
	
		userInfoDao.saveUserInfo(userInfo);
			
		
	}
	public List<UserInfo> findUserInfoByUserName(String userName){
		
		return userInfoDao.findUserInfoByUserName(userName);
	}
	
	
	/**
	 * 获取已注册的用户数
	 * @return
	 */
	public int findUserCount(){
		return userInfoDao.findUserCount();
	}

	// 登录功能
	public UserInfo login(UserInfo userInfo) {

			return userInfoDao.login(userInfo);
	}
	
	
}
