package com.oasystem.dao.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.oasystem.bean.Card;
import com.oasystem.dao.ICardDAO;

public class CardDAOImpl implements ICardDAO {
	private Connection conn;
	private QueryRunner qr=new QueryRunner();
	private String sql;
	
	public CardDAOImpl() {
		super();
	}

	public CardDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	/**
	 * 增加书籍的方法
	 */
	@Override
	public int insert(Card vo) throws Exception {
		sql="INSERT INTO card(name,job,mb,tel) VALUES(?,?,?,?)";
		Object [] params={vo.getName(),vo.getJob(),vo.getMb(),vo.getTel()};
		return this.qr.update(conn,sql,params);
	}
	/**
	 * 删除书籍信息的方法
	 */
	@Override
	public int delete(Integer id) throws Exception {
		sql="DELETE FROM card WHERE id=?";
		return this.qr.update(conn, sql,id);
	}
	/**
	 * 修改书籍的方法
	 */
	@Override
	public int update(Card vo) throws Exception {
		sql="UPDATE card SET name=?,job=?,mb=?,tel=? WHERE id=?";
		Object [] params={vo.getName(),vo.getJob(),vo.getMb(),vo.getTel(),vo.getId()};
		return this.qr.update(conn,sql,params);
	}
	/**
	 * 查询所有书籍信息的方法
	 */
	@Override
	public List<Card> selectAll() throws Exception {
		sql="SELECT * FROM card";
		return this.qr.query(conn,sql, new BeanListHandler<Card>(Card.class));
	}

	@Override
	public Card selectById(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Card> selectLimit(String kw, Integer cp, Integer ls) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Card> selectAll(String user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
