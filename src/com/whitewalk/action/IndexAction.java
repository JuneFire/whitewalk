package com.whitewalk.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.whitewalk.contant.Cons;
import com.whitewalk.entity.Book;
import com.whitewalk.entity.UserInfo;
import com.whitewalk.service.AuthorService;
import com.whitewalk.service.BookService;
import com.whitewalk.service.UserBookMarksService;
import com.whitewalk.service.UserCollectionService;
import com.whitewalk.service.UserInfoService;
import com.whitewalk.service.UserMessageService;
import com.whitewalk.util.CglibProxy;
import com.whitewalk.util.PageHelper;
import com.whitewalk.util.PageHelper.Page;


public class IndexAction extends ActionSupport{
	
	private BookService bookService=(BookService) new CglibProxy().getProxy(BookService.class);
	
	
	private UserInfoService userInfoService=(UserInfoService) new CglibProxy().getProxy(UserInfoService.class);
	
	private UserMessageService userMessageService=(UserMessageService) new CglibProxy().getProxy(UserMessageService.class);
	
	private AuthorService authorService=(AuthorService) new CglibProxy().getProxy(AuthorService.class);
	
	private UserBookMarksService userBookMarksService=(UserBookMarksService) new CglibProxy().getProxy(UserBookMarksService.class);
	
	
	private UserCollectionService userCollectionService=(UserCollectionService) new CglibProxy().getProxy(UserCollectionService.class);
	/**
	 * json数据根对象
	 */
	private Map<String, Object> map;
	
	private int totalPage;
	
	
	private int currentPageNum;
	
	
	private List<Book> listBooks;
	
	//根据点击量取得前5条的的数据
	private List<Book> listHits;
	
	//根据图书的评分取得前5条数据
	private List<Book> listGrade;
	
	
	
	
	//处理返回图书页面视图
	
	public String getIndex(){
		
		Map<String, Object> session =ActionContext.getContext().getSession();
		
		//已注册用户数
		int userCount=userInfoService.findUserCount();
		//已发布图书数
		int bookCount=bookService.findBookCount();
		//已注册作者数
		int authorCount=authorService.findAuthorCount();
		
		//存放5条点击量最高的图书数据
		listHits=bookService.find5BooksOrderByHits();
		
		//存放5条好评最高的图书数据
		listGrade=bookService.find5BookOrderByGrade();
		
		//取右侧图书数据
		PageHelper.Page<Book> page=bookService.findAllWithPage(1, Cons.DEFAULTPAGESIZE);
		
		listBooks=page.getResult();
		
		totalPage=(int) page.getPages();
		currentPageNum=page.getPageNum();
		
		
		
		session.put("userCount", userCount);
		
		session.put("bookCount", bookCount);
		
		session.put("authorCount", authorCount);
		
		UserInfo userInfo=(UserInfo) session.get("userInfo");
		if(userInfo!=null){
			
			int messageCount=userMessageService.findUserMessageCountByUserId(userInfo.getUserId());
			System.out.println("消息数:"+messageCount);
			
			session.put("messageCount", messageCount);
			
			int markCount=userBookMarksService.findUserBookMarksCountByUserId(userInfo.getUserId());
			System.out.println("书签数:"+markCount);
			
			session.put("markCount", markCount);
			
			int collectionCount=userCollectionService.findUserCollectionCountByUserId(userInfo.getUserId());
			session.put("collectionCount", collectionCount);
		}
	
		
		return "index";
	}
	
	//获得下一页的数据
	public String getNextPage(){
		
		if(currentPageNum==totalPage) currentPageNum=1;
		
		else currentPageNum=currentPageNum+1;
		
		Page<Book> page = bookService.findAllWithPage(currentPageNum, Cons.DEFAULTPAGESIZE);
		
		currentPageNum=page.getPageNum();
		
		Map<String, Object> map=new HashMap<String, Object>();
		
		List<Book> list =page.getResult();
		
		
		map.put("currentPageNum", currentPageNum);
		map.put("list", list);
		
		
		this.setMap(map);
		return SUCCESS;
	}

	

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
	
	

	public List<Book> getListBooks() {
		return listBooks;
	}

	public void setListBooks(List<Book> listBooks) {
		this.listBooks = listBooks;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPageNum() {
		return currentPageNum;
	}

	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}

	public List<Book> getListHits() {
		return listHits;
	}

	public void setListHits(List<Book> listHits) {
		this.listHits = listHits;
	}

	public List<Book> getListGrade() {
		return listGrade;
	}

	public void setListGrade(List<Book> listGrade) {
		this.listGrade = listGrade;
	}

	
	

}
