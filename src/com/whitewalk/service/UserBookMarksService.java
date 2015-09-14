package com.whitewalk.service;

import com.whitewalk.dao.IUserBookMarksDao;

public class UserBookMarksService {
	
	private IUserBookMarksDao userBookMraksDao;
	
	
	public int findUserBookMarksCountByUserId(int userId){
		
		return userBookMraksDao.findUserBookMarksCountByUserId(userId);
	
	}

}
