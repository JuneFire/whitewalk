package com.whitewalk.action;

import java.util.List;

import javax.jms.Session;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.whitewalk.entity.Author;
import com.whitewalk.service.AuthorService;
import com.whitewalk.util.CglibProxy;

//ActionSupport和ModelDriven不冲突
public class AuthorAction extends ActionSupport implements ModelDriven<Author>{
	
	private int authorId;
	private List<Author> list;  //外部声明（理解ActionSupport就懂）
	private Author author;
	private AuthorService authorService = (AuthorService) new CglibProxy().getProxy(AuthorService.class);
	
	public String showPage(){
		return "input";
	}
	
	public String loginAuthor(){
		System.out.println("authorId"+authorId);
		if(authorService.findAuthorById(authorId)!=null){
			return "success";
		}
		return "error";
	}
	/*
	 * 增添
	 */
	public String saveNewAuthor(){
		
		print(author);
		String result = "success";
	//	author.setUserId(1);
		authorService.addAuthor(author);
		return result;
	}
	/*更新
	 */
	public String findAuthorbyid(){
		author = authorService.findAuthorById(authorId);
		return SUCCESS;
	}
	
	public String updateAuthor(){
		
		authorService.updateAuthor(author);
		return "success";
		//1.获取传入的authorId
		
		//2.根据传入的authorId获取Author对象
		
		//3.把栈顶对象的属性装配好：此时栈顶对象是author
	}
	
	/*删除
	 */
	public String deleteAuthor(){
		authorService.deleteAuthor(authorId);
		return "success";
	}
	/*显示
	 */
	public String showAuthor(){
		list = authorService.findAll();
		if(list==null){
			return "error";
			
		}else{
			return "success";
		}
	}
	
	public void print(Author author){
		StringBuffer sb = new StringBuffer();
		
		sb.append("id:"+author.getId())
		.append("userId:"+author.getId()).append("realName"+author.getRealname())
		.append("penName"+author.getPenName()).append("mail"+author.getMail())
		.append("tel"+author.getTel()).append("idCard"+author.getIdCard());
		System.out.println(sb.toString());
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	@Override
	public Author getModel() {
		// TODO Auto-generated method stub
		return author;
	}

	public List<Author> getList() {
		return list;
	}

	public void setList(List<Author> list) {
		this.list = list;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	
}
