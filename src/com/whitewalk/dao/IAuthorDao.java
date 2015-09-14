package com.whitewalk.dao;

import java.util.List;
import java.util.Map;

import com.whitewalk.entity.Author;

/**
 * 作家方法类
 * @author 程志康
 */
public interface IAuthorDao {
	

	public List<Author> findAll(); //查询所有作者
	
	public void addAuthor(Author author);  // 添加作者
	
	public Author findAuthorById(int id); //准确查找作者
	
	public void updateAuthor(Author author); 
	
	 int findAuthorCount();
	
	public void deleteAuthor(int id);

}
