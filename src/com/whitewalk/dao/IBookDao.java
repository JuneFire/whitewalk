package com.whitewalk.dao;

import java.util.List;

import com.whitewalk.entity.Book;
import com.whitewalk.entity.BookGrade;

public interface IBookDao {
	
		
	   List<Book> findAll();
		
	   List<Book> findAllWithPage();
	   
	   List<Book> findAllByOrderByHitsWithPage();
	   
	   int findBookCount();
	   
	   Book findBookById(int bookId);
	  

}
