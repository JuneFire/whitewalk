package com.whitewalk.service;

import java.util.List;

import com.whitewalk.dao.IBookSectionDao;
import com.whitewalk.entity.BookSection;
import com.whitewalk.util.Autowired;

public class BookSectionService {
	
	@Autowired
	private IBookSectionDao bookSectionDao;

	
	public List<BookSection> findByBookId(int bookId){
		return bookSectionDao.findByBookId(bookId);
	}
}
