package com.whitewalk.test;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.whitewalk.entity.Book;
import com.whitewalk.entity.BookGrade;
import com.whitewalk.service.AuthorService;
import com.whitewalk.service.BookGradeService;
import com.whitewalk.service.BookSectionService;
import com.whitewalk.service.BookService;
import com.whitewalk.service.UserBookMarksService;
import com.whitewalk.service.UserCollectionService;
import com.whitewalk.service.UserInfoService;
import com.whitewalk.service.UserMessageService;
import com.whitewalk.util.CglibProxy;

public class DAOTest {
	
	private BookService bookService=(BookService) new CglibProxy().getProxy(BookService.class);
	
	private BookGradeService bookGradeService=(BookGradeService) new CglibProxy().getProxy(BookGradeService.class);
	
	private UserInfoService userInfoService=(UserInfoService) new CglibProxy().getProxy(UserInfoService.class);
	
	private AuthorService authorService=(AuthorService) new CglibProxy().getProxy(AuthorService.class);
	
	private UserBookMarksService userBookMarksService=(UserBookMarksService) new CglibProxy().getProxy(UserBookMarksService.class);
	
	private UserMessageService userMessageService=(UserMessageService) new CglibProxy().getProxy(UserMessageService.class);
	
	private UserCollectionService userCollectionService=(UserCollectionService) new CglibProxy().getProxy(UserCollectionService.class);
	
	private BookSectionService bookSectionService =(BookSectionService) new CglibProxy().getProxy(BookSectionService.class);
	
	
	@Test
	public void testFindAllWithPage(){
		
		
		//执行bookService下的分页查询图书方法
		List<Book> list=bookService.findAllWithPage(1, 3).getResult();
		
		//打印图书信息
		for(Book book:list){
			print(book);
		}
		
		
	}
	
	
	@Test
	public void testBookGradeDao(){
		
	
		BookGrade bookGrade =new BookGrade();
		bookGrade.setUserId(1);
		bookGrade.setBookId(18);
		bookGrade.setGrade(9);
		bookGradeService.saveBookGrade(bookGrade);
		
		
	}
	@Test
	public void testFind5bookByHits(){
		List<Book> list=bookService.find5BookOrderByGrade();
		for(Book  book:list){
			print(book);
		}
	}
	@Test
	public void testFindBookCount(){
		println(bookService.findBookCount());
	}
	
	
	@Test
	public void testFindUserCount(){
		println(userInfoService.findUserCount());
		
	}
	
	@Test
	public void findAuthorCount(){
		
		println(authorService.findAuthorCount());
	}
	@Test
	public void testFindBookMraksCount(){
		println(userBookMarksService.findUserBookMarksCountByUserId(1));
	}
	
	@Test
	public void testUserMessageService(){
		println(userMessageService.findUserMessageCountByUserId(1));
		
		println(new Date().toString());
	
	}
	@Test
	public void testFindBookById(){
		println(bookService.findBookById(1).getSynopsis());
	}
	
	@Test
	public void tsetUserCollectionService(){
		
		println(userCollectionService.findUserCollectionCountByUserId(1));
	}
	
	@Test
	public void findBookSectionByBookId(){
		println(bookSectionService.findByBookId(1).size());
	}
	
	
	@Test
	public void testReadTxt() throws IOException{
		
		String encodeing="UTF-8";
		
		
		
		String name="G:/text/node.txt";
		File file =new File(name);
		InputStreamReader read;
		
		read = new InputStreamReader(new FileInputStream(file),encodeing);
		BufferedReader bufferedReader = new BufferedReader(read);
	             System.out.println("ss");
				 String lineTxt = null;
	             
				 while((lineTxt = bufferedReader.readLine()) != null){
	                 System.out.println(lineTxt);
	             }
	             read.close();
			
			
			 
	}
	
	
	public void println(Object object){
		System.out.println(object);
		
	}
	
	public void print(Book book){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("id:"+book.getBookId())
			.append("title:"+book.getTitle())
			.append("hits:"+book.getHits())
			.append("grade:"+book.getGrade())
			.append("简介:"+book.getSynopsis());
		println(sb);
		
	}
	

}
