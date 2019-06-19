package com.oasystem.dao.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.oasystem.bean.Message;
import com.oasystem.dao.IDao;
import com.oasystem.dao.IMessageDao;
import com.oasystem.dao.Adapter.DaoAdapter;

public class IMessageDaoImpl extends DaoAdapter<Integer, Message> implements IMessageDao {
	
	private Connection conn;

	public IMessageDaoImpl() {
	}

	public IMessageDaoImpl(Connection conn) {
		this.conn = conn;
	}

	
	public String sql;
	private QueryRunner qr = new QueryRunner();
	 
	@Override
	public int insert(Message message) throws Exception {
		 sql = "insert into messages(user,message)values(?,?)";
		 Object [] params = {message.getUser(),message.getMessage()};
		return this.qr.update(conn, sql, params);
	}
	
	@Override
	public int delete(Integer id) throws Exception {
		sql ="delete from messages where id = ?";
		
		return this.qr.update(conn, sql, id);
	}
	
	@Override
	public List<Message> selectAll() throws Exception {
		sql = "select *from messages";
		return this.qr.query(conn, sql, new BeanListHandler<Message>(Message.class));
	}
	
}
