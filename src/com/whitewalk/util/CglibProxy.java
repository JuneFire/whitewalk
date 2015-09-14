package com.whitewalk.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import org.apache.ibatis.session.SqlSession;

public class CglibProxy implements MethodInterceptor {
	
	
	
	//在没有标记@Autowired注解的情况下自动注入的属性必须包含的关键字:Dao
	public final static String DAO="dao"; 
	
	
	/**
	 * 设置提交事务的方法关键字
	 * 如:updateUerInfo,saveUser,deleteUser,addUser等。。。
	 * 这些方法都需要及时提交事务
	 */
	public final static String needCommitMethod[]={"update","delete","insert","save","add"};
	
	
	
	//子类生成器
	private Enhancer enhancer = new Enhancer();
	
	public Object getProxy(Class clazz){
		
		//设置需要创建子类的父类
		enhancer.setSuperclass(clazz);
		
		enhancer.setCallback(this);
		//通过字节码技术动态创建子类实例
		return enhancer.create();
		
	}
	//该方法拦截目标类的所有方法调用
	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		
		//实例化sqlsession
		SqlSession sqlSession=MybatisUtil.openSession();
				
		//以下操作获取父类是否有包含"dao"关键字的属性
		
		Class objSuperClass=obj.getClass().getSuperclass();
		
		Field[] fields = objSuperClass.getDeclaredFields();
		//检查父类的属性，
		for(Field field:fields){
			
			//设置字段访问权限为可访问
			field.setAccessible(true);
			
			//检查属性是否包含注解
			Autowired autowired =field.getAnnotation(Autowired.class);
			
			//如果该字段的注解不为空，即标记了注解
			if(autowired!=null){
				
				//通过sqlSession注入该值
				field.set(obj, sqlSession.getMapper(field.getType()));
			}
			//如果该字段没有注解，则检查字段的类型名称是否包含"dao"关键字
			else {
				//如果属性中有包含"Dao"关键字的属性，就通过反射注入到目标类实例中
				if(field.getType().getName().toLowerCase().contains(DAO)){
					//通过sqlSession注入该值
					field.set(obj, sqlSession.getMapper(field.getType()));
				}
			}
			
			
		
		}
		//将执行权交给代理类，通过代理类执行父类的方法
		Object result = proxy.invokeSuper(obj, args);
		
		//通过方法的注解判断是否需要提交事务
		Commit commit=method.getAnnotation(Commit.class);
		
		
		
		
		//如果标注了提交事务的注解
		if(commit!=null){
			
			sqlSession.commit();
			
		}
		else {
			//开发人员忘记标注方法，但是方法包含了关键字
			//检查方法名是否包含需要提交事务的关键字
			if(methodIsNeedCommit(method.getName().toLowerCase())) {
			
				sqlSession.commit();
				
			}
			else System.out.println("警告:执行的方法名没有标注提交事务的注解,也没有包含提交事务的方法关键字--结果:没有提交事务");
		}
		
			
		//执行完父类的方法，及时关闭sqlSession
		sqlSession.close();
		
		return result;
	}
	
	
	
	/**
	 * 检查正在执行的方法是否包含必须提交事务操作的关键字
	 * 包含关键字,return true
	 * 不包含关键字,return false
	 * @param methodName
	 * @return boolean
	 */
	public  boolean methodIsNeedCommit(String methodName){
		//如果方法名包含必须提交事务的关键字，则返回true
		for(String s:needCommitMethod){
			
			if(methodName.contains(s)) return true;
		}
		
		return false;
		
	}
	

}
