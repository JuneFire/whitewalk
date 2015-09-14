package com.whitewalk.service;

import com.whitewalk.dao.IUserMessageDao;
import com.whitewalk.util.Autowired;

public class UserMessageService {
	
	@Autowired
	private IUserMessageDao userMessageDao;
	
	
	public int findUserMessageCountByUserId(int userId){
		return userMessageDao.findUserMessageCountByUserId(userId);
	}
}
