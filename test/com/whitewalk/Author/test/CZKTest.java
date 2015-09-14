package com.whitewalk.Author.test;

import java.util.List;

import org.junit.Test;

import com.whitewalk.entity.Author;
import com.whitewalk.service.AuthorService;
import com.whitewalk.util.CglibProxy;
import com.whitewalk.util.PageHelper;
public class CZKTest {
	AuthorService as = (AuthorService) new CglibProxy().getProxy(AuthorService.class);
	@Test
	public void Test1(){
		List<Author> list = as.findAll();
		for(Author a:list){
			println(a.getRealname());
		}
	}
	private void println(Object object) {
		System.out.println(object);
		
	}
	/**
	 * mybatis配置映射，配置实体名
	 */
	
	@Test
	public void addTest(){
		//实例化一个作者对象
		Author at = new Author();
		
		at.setId(6);
		at.setIdCard("360281199411122718");
		at.setMail("3823498@qq.com");
		at.setPenName("TestAuthor");
		at.setRealname("TA");
		at.setTel("123143");
		at.setUserId(1);
		as.addAuthor(at);
	}
	
	@Test
	public void FindById(){
		
		Author a = as.findAuthorById(1);
		System.out.println(a.getId()+" "+a.getRealname());
	}
	@Test
	public void  updateAuthor(){
		
		Author a = as.findAuthorById(1); //找到该行的所有数据
		System.out.println("++++++++");
		a.setMail("112134451@123");
		as.updateAuthor(a);
	}
	@Test 
	public void deleteAuthor(){
		
		as.deleteAuthor(5);
	}
}



