package com.whitewalk.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.whitewalk.entity.Book;
import com.whitewalk.entity.BookSection;
import com.whitewalk.service.BookSectionService;
import com.whitewalk.service.BookService;
import com.whitewalk.util.CglibProxy;
import com.whitewalk.util.ReadUtil;
import com.whitewalk.util.entity.BookSectionView;

public class BookReadAction extends ActionSupport{
	
	private BookService bookService =(BookService) new CglibProxy().getProxy(BookService.class);
	
	private BookSectionService bookSectionService =(BookSectionService) new CglibProxy().getProxy(BookSectionService.class);
	
	
	private List<BookSectionView> list=new ArrayList<BookSectionView>();
	
	private List<BookSection> sectionList=new ArrayList<BookSection>();
	
	
	
	//读取请求过来的bookid参数
	private int bookid;
	
	//图书
	private Book book;
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7632443440977366248L;

	public String getBookReadPage(){
		
		book = bookService.findBookById(bookid);
		
		sectionList=bookSectionService.findByBookId(bookid);
	
		
		for(BookSection bookseSection:sectionList){
			
			BookSectionView bookSectionView=new BookSectionView();
			
			
			//获取节的标题
			bookSectionView.setTitle(bookseSection.getSectionTitle());
		
			String lineText=ReadUtil.readString(bookseSection.getSectionContent());
			bookSectionView.setContent(lineText);
			
			list.add(bookSectionView);
			
			
		}
		
	
		return SUCCESS;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	



	public List<BookSectionView> getList() {
		return list;
	}

	public void setList(List<BookSectionView> list) {
		this.list = list;
	}

	public List<BookSection> getSectionList() {
		return sectionList;
	}

	public void setSectionList(List<BookSection> sectionList) {
		this.sectionList = sectionList;
	}

	
	
	
	
	
	
	
}
