package com.whitewalk.service;

import com.whitewalk.dao.IUserCollectionDao;
import com.whitewalk.util.Autowired;

public class UserCollectionService {
	
	@Autowired
	private IUserCollectionDao userCollectionDao;
	
	
	public int findUserCollectionCountByUserId(int userId){
		
		
		return userCollectionDao.findUserCollectionCountByUserId(userId);
	}
}
