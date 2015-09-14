package com.whitewalk.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.log4j.Logger;

@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class}),  
@Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})})  

public class PageHelper implements Interceptor {

	
	    public static final ThreadLocal<Page> localPage = new ThreadLocal<Page>();  
  
	    private static final Logger logger = Logger.getLogger(PageHelper.class);  

	    public static void startPage(int pageNum, int pageSize) {  
	        localPage.set(new Page(pageNum, pageSize));  
	    }  
	 
		public static Page endPage() {  
	        Page page = localPage.get();  
	        localPage.remove();  
	       return page;  
	    }  
	  
	    @Override  
	    public Object intercept(Invocation invocation) throws Throwable {  
	         if (localPage.get() == null) {  
	             return invocation.proceed();  
	        }  
	        if (invocation.getTarget() instanceof StatementHandler) {  
	            StatementHandler statementHandler = (StatementHandler) invocation.getTarget();  
	             MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);  
	               
	            while (metaStatementHandler.hasGetter("h")) {  
	                 Object object = metaStatementHandler.getValue("h");  
	                 metaStatementHandler = SystemMetaObject.forObject(object);  
	             }  
	            
	           while (metaStatementHandler.hasGetter("target")) {  
	                Object object = metaStatementHandler.getValue("target");  
	                metaStatementHandler = SystemMetaObject.forObject(object);  
	            }  
	          MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");  
	            //分页信息if (localPage.get() != null) {   
	             Page page = localPage.get();  
	            BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");  
	             // 分页参数作为参数对象parameterObject的一个属性   
	            String sql = boundSql.getSql();  
	            // 重写sql   
	             String pageSql = buildPageSql(sql, page);  
	            //重写分页sql   
	             metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);  
	            Connection connection = (Connection) invocation.getArgs()[0];  
	             // 重设分页参数里的总页数等   
	             setPageParameter(sql, connection, mappedStatement, boundSql, page);  
	           // 将执行权交给下一个拦截器   
	            return invocation.proceed();  
	      } else if (invocation.getTarget() instanceof ResultSetHandler) {  
	             Object result = invocation.proceed(); 
	             
	             
	             Page page = localPage.get();
	             
	             page.setResult((List) result);
	             
	             //page.getResult().sort(new BookHitsComparator());
	             
	             
	            return result;  
	       }  
	       return null;  
  }  
	 
	
	   @Override  
	   public Object plugin(Object target) {  
	        if (target instanceof StatementHandler || target instanceof ResultSetHandler) {  
	           return Plugin.wrap(target, this);  
	       } else {  
	             return target;  
	      }  
	    }  
	 
	    @Override  
	    public void setProperties(Properties properties) {  
	 
	    }  
	
	
	    private String buildPageSql(String sql, Page page){ 
	        StringBuilder pageSql = new StringBuilder(200);  
	      pageSql.append("select * from ( select temp.*, rownum row_id from ( ");  
	        pageSql.append(sql);  
	         pageSql.append(" ) temp where rownum <= ").append(page.getEndRow());  
	         pageSql.append(") where row_id > ").append(page.getStartRow());  
	         return pageSql.toString();  
	      }  
	  
	      private void setPageParameter(String sql, Connection connection, MappedStatement mappedStatement,  
	                                    BoundSql boundSql, Page page) {  
	        // 记录总记录数   
	        String countSql = "select count(0) from (" + sql + ")";  
	        PreparedStatement countStmt = null;  
	        ResultSet rs = null;  
	        try {  
	              countStmt = connection.prepareStatement(countSql);  
	           BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(), countSql,  
	                      boundSql.getParameterMappings(), boundSql.getParameterObject());  
	              setParameters(countStmt, mappedStatement, countBS, boundSql.getParameterObject());  
	           rs = countStmt.executeQuery();  
	             int totalCount = 0;  
	              if (rs.next()) {  
	              totalCount = rs.getInt(1);  
	             }  
	             page.setTotal(totalCount);  
	             int totalPage = totalCount / page.getPageSize() + ((totalCount % page.getPageSize() == 0) ? 0 : 1);  
	            page.setPages(totalPage);  
	        } catch (SQLException e) {  
	              //logger.error("Ignore this exception", e);  
	         } finally {  
	             try {  
	               rs.close();  
	              } catch (SQLException e) {  
	                  //logger.error("Ignore this exception", e);  
	              }  
	            try {  
	                 countStmt.close();  
	             } catch (SQLException e) {  
	                  //logger.error("Ignore this exception", e);  
	           }  
	          }  
	     }  
	   
	     private void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql,  
	                                Object parameterObject) throws SQLException {  
	        ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);  
	        parameterHandler.setParameters(ps);  
    }  
	  
	     public static class Page<E> {  
	         private int pageNum;  
	         private int pageSize;  
	        private int startRow;  
	          private int endRow;  
	          private long total;  
	          private int pages;  
	        private List<E> result;  
	   
	         public Page(int pageNum, int pageSize) {  
	             this.pageNum = pageNum;  
	             this.pageSize = pageSize;  
	             this.startRow = pageNum > 0 ? (pageNum - 1) * pageSize : 0;  
	             this.endRow = pageNum * pageSize;  
	          }  
	    
	         public List<E> getResult() {  
	             return result;  
	        }  
	   
	          public void setResult(List<E> result) {  
	             this.result = result;  
	         }  
	   
	          public int getPages() {  
	             return pages;  
	          }  
	   
	         public void setPages(int pages) {  
	             this.pages = pages;  
	        }  
	    
	        public int getEndRow() {  
	              return endRow;  
	          }  
	    
	         public void setEndRow(int endRow) {  
	              this.endRow = endRow;  
	         }  
	   
	         public int getPageNum() {  
	              return pageNum;  
	          }  
	  
	         public void setPageNum(int pageNum) {  
	             this.pageNum = pageNum;  
	        }  
	  
	          public int getPageSize() {  
	            return pageSize;  
	         }  
	   
	          public void setPageSize(int pageSize) {  
	             this.pageSize = pageSize;  
	         }  
	   
	         public int getStartRow() {  
	            return startRow;  
	        }  
	   
	        public void setStartRow(int startRow) {  
	            this.startRow = startRow;  
	         }  
	   
	          public long getTotal() {  
	             return total;  
	          }  
	   
	         public void setTotal(long total) {  
	            this.total = total;  
	        }  
	  
	       @Override  
	        public String toString() {  
	            return "Page{" +  
	                     "pageNum=" + pageNum +  
	                    ", pageSize=" + pageSize +  
	                    ", startRow=" + startRow +  
	                    ", endRow=" + endRow +  
	                    ", total=" + total +  
	                     ", pages=" + pages +  
	                    '}';  
	      }  
	   }  


}
