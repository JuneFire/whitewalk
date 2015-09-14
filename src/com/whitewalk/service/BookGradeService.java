package com.whitewalk.service;

import com.whitewalk.dao.IBookGradeDao;
import com.whitewalk.entity.BookGrade;
import com.whitewalk.util.Autowired;
import com.whitewalk.util.Commit;

public class BookGradeService {
	
	
	@Autowired
	private IBookGradeDao bookGradeDao;
	
	/**
	 * 保存图书的评分记录
	 */
	@Commit
	public void saveBookGrade(BookGrade bookGrade){
		
		bookGradeDao.saveBookGrade(bookGrade);
		
	}

	
	
	
	
	

}
