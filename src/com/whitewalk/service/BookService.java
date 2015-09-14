package com.whitewalk.service;

import java.util.ArrayList;
import java.util.List;
import com.whitewalk.dao.IBookDao;
import com.whitewalk.entity.Book;
import com.whitewalk.util.Autowired;
import com.whitewalk.util.BookGradeComparator;
import com.whitewalk.util.BookHitsComparator;
import com.whitewalk.util.PageHelper;
import com.whitewalk.util.PageHelper.Page;

public class BookService {

	
	@Autowired
	private IBookDao bookDao;
	/**
	 * 分页查询所有图书信息
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public Page<Book> findAllWithPage(int pageNum, int pageSize) {
	
		
		//执行查询
		//SqlSession sqlSession=MybatisUtil.openSession();
		//开始分页
		PageHelper.startPage(pageNum, pageSize);
		
		bookDao.findAllWithPage();
		//sqlSession.close();
		//返回查询结果
		return PageHelper.endPage();
	}
	
	//根据点击量排序并返回前5条数据
	public List<Book> find5BooksOrderByHits(){
		
	
		
		List<Book> listAll=bookDao.findAll();
		
		//listAll.sort(new BookHitsComparator());
		//去掉这个相当于只取所有记录的前5条
		List<Book> resultList=new ArrayList<Book>();
		
		//取前五条数据
		for(int i=0;i<5;i++){
			resultList.add(listAll.get(i));
		}
		listAll=null;
		return resultList;
	}
	
	public List<Book> find5BookOrderByGrade(){
		
		
		
		List<Book> listAll=bookDao.findAll();
		
		
		
		List<Book> resultList=new ArrayList<Book>();
		
		//取前五条数据
		for(int i=0;i<5;i++){
			resultList.add(listAll.get(i));
		}
		listAll=null;
		return resultList;
	}
	
	//获得所有上架图书的数量
	public int findBookCount(){
	
		
		return bookDao.findBookCount();
	}

	
	/**
	 * 根据图书的id查询图书信息
	 * 
	 */
	public Book findBookById(int bookId){
		return bookDao.findBookById(bookId);
	}
	
	
	


	
	
}
