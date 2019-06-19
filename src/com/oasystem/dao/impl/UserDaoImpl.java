package com.oasystem.dao.impl;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.oasystem.bean.User;
import com.oasystem.dao.UserDao;
import com.oasystem.dao.Adapter.DaoAdapter;

public class UserDaoImpl extends DaoAdapter<Integer,User> implements UserDao  {
	private Connection conn;
	
	
	public UserDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDaoImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	
	private QueryRunner qr = new QueryRunner();
	private String sql;
	
	@Override
	public User login(String loginName) throws Exception {
		sql = "select *from user where loginName = ?";
		return this.qr.query(conn, sql, new BeanHandler<User>(User.class),loginName); 
	}
	
	@Override
	public List<User> selectAll() throws Exception {
		 sql = "select * from user";
		return qr.query(conn, sql, new BeanListHandler<User>(User.class));
	}
	
	@Override
	public int update(User v) throws Exception {
		 sql = "update user set loginName=?,password=?,realName=?,sex=?,roleId=?  where id = ?";
		 Object [] params = {v.getLoginName(),v.getPassword(),v.getRealName(),v.getSex(),v.getRoleId(),v.getId()};
		 return this.qr.update(conn, sql, params);	
	}
	
	@Override
	public int insert(User v) throws Exception {
		sql = "insert into user(loginName,password,realName,sex,roleId)values(?,?,?,?,?)";
		Object [] params = {v.getLoginName(),v.getPassword(),v.getRealName(),v.getSex(),v.getRoleId()};
		this.qr.update(conn, sql, params);
		
		//查询出自动增长的主键值的sql语句
		String sql1 = "SELECT @@identity";
		//实现自增长主键值的查询
		BigInteger num = this.qr.query(conn, sql1, new ScalarHandler<>(1));
		return num.intValue();
	}
	
	@Override
	public int delete(Integer id) throws Exception {
		 sql = "delete from user where id = ?";
		 
		return  this.qr.update(conn, sql, id);
	}

	@Override
	public List<User> selectLimit(String kw, Integer cp, Integer ls) throws Exception {
		 sql = "select*from user where loginName like ? or realName like ?  limit ?,?";
		 Object [] params = {"%"+kw+"%","%"+kw+"%",(cp-1)*ls,ls};
		 return this.qr.query(conn, sql, new BeanListHandler<User>(User.class),params);
	}

	@Override
	public int updatePassword(String password, String loginName) throws Exception {
		 sql ="update user set password = ? where loginName = ?";
		 Object [] params = {password , loginName};
		return this.qr.update(conn, sql, params);
	}
	 
}
