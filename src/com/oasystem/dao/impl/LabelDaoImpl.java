package com.oasystem.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.oasystem.bean.Label;
import com.oasystem.dao.ILabelDao;
import com.oasystem.dao.Adapter.DaoAdapter;
import com.oasystem.utils.C3P0Utils;

public class LabelDaoImpl extends DaoAdapter<Integer, Label> implements ILabelDao {
	
	private Connection conn;
	 
	public LabelDaoImpl() {
		super();
	}
 
	public LabelDaoImpl(Connection conn) {
		super();
		this.conn = conn;
	} 
	
	private String sql;
	private QueryRunner qr = new QueryRunner();

	@Override
	public int insert(Label v) throws Exception {
	 sql ="insert into label(name,time,content)values(?,?,?)";
	 Object [] params ={v.getName(),new Date(v.getTime().getTime()),v.getContent()};
		return this.qr.update(conn, sql, params);
	}
	
	
	@Override
	public int delete(Integer k) throws Exception {
		sql ="delete from label where id = ?";
		return this.qr.update(conn, sql, k);
	}
	
	
	@Override
	public List<Label> selectAll() throws Exception {
		sql ="select*from label";
		return this.qr.query(conn, sql, new BeanListHandler<Label>(Label.class));
	}
	
	
	
	
}
