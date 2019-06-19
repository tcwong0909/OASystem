package com.oasystem.dao.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.oasystem.bean.Booksapply;
import com.oasystem.dao.IBooksapplyDAO;
/**
 * 书籍借阅dao层实现类
 * @author Administrator
 *
 */
public class BooksapplyDAOImpl implements IBooksapplyDAO {

	private Connection conn;
	private QueryRunner qr=new QueryRunner();
	private String sql;
	
	public BooksapplyDAOImpl() {
		super();
	}

	public BooksapplyDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	/**
	 * 增加书籍的方法
	 */
	@Override
	public int insert(Booksapply vo) throws Exception {
		sql="INSERT INTO booksapply(name,borrowDate,booksName,approver) VALUES(?,?,?,'admin')";
		Object [] params={vo.getName(),new java.sql.Date(vo.getBorrowDate().getTime()),vo.getBooksName()};
		return this.qr.update(conn,sql,params);
	}
	/**
	 * 删除书籍信息的方法
	 */
	@Override
	public int delete(Integer id) throws Exception {
		sql="DELETE FROM booksapply WHERE id=?";
		return this.qr.update(conn, sql,id);
	}
	/**
	 * 修改书籍的方法
	 */
	@Override
	public int update(Booksapply vo) throws Exception {
		sql="UPDATE booksapply SET name=?,name=?,borrowDate=?,booksName=?,approver=? WHERE id=?";
		Object [] params={vo.getName(),new java.sql.Date(vo.getBorrowDate().getTime()),vo.getBooksName(),vo.getApprover()};
		return this.qr.update(conn,sql,params);
	}
	/**
	 * 查询所有书籍信息的方法
	 */
	@Override
	public List<Booksapply> selectAll() throws Exception {
		sql="SELECT * FROM booksapply";
		return this.qr.query(conn,sql, new BeanListHandler<Booksapply>(Booksapply.class));
	}

	@Override
	public Booksapply selectById(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booksapply> selectLimit(String kw, Integer cp, Integer ls) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booksapply> selectAll(String user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
