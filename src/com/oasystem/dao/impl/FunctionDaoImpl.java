package com.oasystem.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.oasystem.bean.Function;
import com.oasystem.bean.User;
import com.oasystem.dao.IFunctionDao;

public class FunctionDaoImpl implements IFunctionDao {
	private Connection conn;
	
	
	public FunctionDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FunctionDaoImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	
	private QueryRunner qr = new QueryRunner();
	private String sql;
	@Override
	public int insert(Function f) throws SQLException {
		sql ="insert into function(name)values(?)";
	 return qr.update(conn, sql, f.getName());
		
	}
	
	@Override
	public int update(Function f) throws Exception {
		 sql = "UPDATE function SET name=? WHERE id=?";
		 Object[] params = {f.getName(),f.getId()};
		return qr.update(conn, sql, params);
	}

	@Override
	public List<Function> selectAll() throws Exception {
		 sql = "select *from function";
		return qr.query(conn, sql, new BeanListHandler<Function>(Function.class));
	}

	@Override
	public Function selectById(int id) throws Exception {
		sql = "select *from function where id = ?";	
		return this.qr.query(conn, sql, new BeanHandler<Function>(Function.class), id);
	}

	@Override
	public int deleteById(int id) throws Exception {
		sql = "delete from function where id = ?";	
		return this.qr.update(conn, sql, id);
	}

	@Override
	public List<Function> selectLimit(Integer cp, Integer ls) throws SQLException {
		 sql = "select *from function limit ?,?";
		 Object [] params ={(cp-1)*ls,ls};	 
		return this.qr.query(conn, sql,new BeanListHandler<Function>(Function.class), params);
	}

}
