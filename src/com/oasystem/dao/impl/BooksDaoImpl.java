package com.oasystem.dao.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.oasystem.bean.Books;
import com.oasystem.dao.IBooksDAO;
import com.oasystem.dao.Adapter.DaoAdapter;
/**
 * 图书信息dao层实现类
 * @author Administrator
 *
 */
public class BooksDaoImpl extends DaoAdapter<Integer, Books> implements IBooksDAO {
	private Connection conn;
	private QueryRunner qr=new QueryRunner();
	private String sql;
	
	public BooksDaoImpl() {
		super();
	}

	public BooksDaoImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	/**
	 * 增加书籍的方法
	 */
	@Override
	public int insert(Books vo) throws Exception {
		sql="INSERT INTO books(name,remark) VALUES(?,?)";
		Object [] params={vo.getName(),vo.getRemark()};
		return this.qr.update(conn,sql,params);
	}
	/**
	 * 删除书籍信息的方法
	 */
	@Override
	public int delete(Integer id) throws Exception {
		sql="DELETE FROM books WHERE id=?";
		return this.qr.update(conn, sql,id);
	}
	/**
	 * 修改书籍的方法
	 */
	@Override
	public int update(Books vo) throws Exception {
		sql="UPDATE books SET name=?,remark=? WHERE id=?";
		Object [] param={vo.getName(),vo.getRemark(),vo.getId()};
		return this.qr.update(conn,sql,param);
	}
	/**
	 * 查询所有书籍信息的方法
	 */
	@Override
	public List<Books> selectAll() throws Exception {
		sql="SELECT * FROM books";
		return this.qr.query(conn,sql, new BeanListHandler<Books>(Books.class));
	}

	@Override
	public Books selectById(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Books> selectLimit(String kw, Integer cp, Integer ls) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
