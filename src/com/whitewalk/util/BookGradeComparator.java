package com.whitewalk.util;

import java.util.Comparator;

import com.whitewalk.entity.Book;

public class BookGradeComparator implements Comparator<Book> {

	@Override
	public int compare(Book book1, Book book2) {
		if(book1.getGrade()>book2.getGrade())
			return -1;
		else if(book1.getGrade()<book2.getGrade())
			return 1;
		
		return 0;
	}

}
