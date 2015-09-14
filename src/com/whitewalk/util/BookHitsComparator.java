package com.whitewalk.util;

import java.util.Comparator;

import com.whitewalk.entity.Book;

/**
 * 比较器：根据图书的点击量排序
* @Title: BookHitsComparator.java 
* @package: com.whitewalk.util 
* @description: 
* @time: 2015年8月30日 下午10:03:26 
* @version : V1.0
 */
public class BookHitsComparator implements Comparator<Book>{

	@Override
	public int compare(Book book1, Book book2) {
		
		if(book1.getHits()>book2.getHits())
			return -1;
		else if(book1.getHits()<book2.getHits())
			return 1;
		return 0;
	}
	

	

}
