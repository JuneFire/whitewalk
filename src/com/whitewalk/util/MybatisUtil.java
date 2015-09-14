package com.whitewalk.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {

	/**
	 * sqlSessionFactory是ORM框架Hibernate一个数据库session的连接工厂配置，更像一种连接池管理类，
	 * 每次的数据操作都将由连接池来分配连接后进行
	 */
	private final static SqlSessionFactory sqlSessionFactory;
	static {
		String resource = "mybatis-config.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}
	//得到资源连接
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	//打开资源连接
	public static SqlSession openSession() {
		return sqlSessionFactory.openSession();
	}
}
