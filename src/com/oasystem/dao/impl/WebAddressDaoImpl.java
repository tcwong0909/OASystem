package com.oasystem.dao.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.oasystem.bean.WebAddress;
import com.oasystem.dao.IWebAddressDao;
import com.oasystem.dao.Adapter.DaoAdapter;

public class WebAddressDaoImpl extends DaoAdapter<Integer, WebAddress> implements IWebAddressDao {

	private Connection conn;
	
	
	public WebAddressDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WebAddressDaoImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	
	private QueryRunner qr = new QueryRunner();
	private String sql;
	
	@Override
	public int insert(WebAddress v) throws Exception {
		sql = "insert into webaddress(name,webaddress,user)values(?,?,?)";
		Object [] params = {v.getName(),v.getWebaddress(),v.getUser()};
		return this.qr.update(conn, sql, params);
	}

	@Override
	public int delete(Integer k) throws Exception {
	 sql = "delete from webaddress where id = ?";
	 
		return this.qr.update(conn, sql, k);
	}

	@Override
	public int update(WebAddress v) throws Exception {
		sql ="update webaddress set name=?,webaddress=?,user=? where id=?";
		Object [] params = {v.getName(),v.getWebaddress(),v.getUser(),v.getId()};
		return this.qr.update(conn, sql, params);
	}

	@Override
	public List<WebAddress> selectAll(String user) throws Exception {
		sql ="select *from webaddress where user = ?";
		
		return this.qr.query(conn, sql, new BeanListHandler<WebAddress>(WebAddress.class), user);
	}

	@Override
	public WebAddress selectById(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WebAddress> selectLimit(String kw, Integer cp, Integer ls) throws Exception {
		 
		return null;
	}

}
