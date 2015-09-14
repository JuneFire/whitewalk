package com.whitewalk.dao;

import java.util.List;

import com.whitewalk.entity.BookSection;

public interface IBookSectionDao {
	
	public List<BookSection> findByBookId(int bookId);

}
