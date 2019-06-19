package com.oasystem.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.naming.java.javaURLContextFactory;

import com.oasystem.bean.Inform;
import com.oasystem.dao.IInformDao;
import com.oasystem.dao.Adapter.DaoAdapter;
import com.oasystem.utils.C3P0Utils;

/**
 * 通告信息实现类
 * @author TcWong
 */
public class InformDaoImpl extends DaoAdapter<Integer, Inform> implements IInformDao {

	private Connection conn;
	
	private QueryRunner qr = new QueryRunner();
	
	public InformDaoImpl() {
		super();
	}
	
	public InformDaoImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	/**
	 * 插入数据
	 */
	@Override
	public int insert(Inform inform) throws Exception {
		String sql = "INSERT INTO inform (title,content,startDay,endDay,publishDay,type,publisher) VALUES(?,?,?,?,?,?,?)";
		Object[] params = {inform.getTitle(),inform.getContent(),inform.getStartDay(),inform.getEndDay(),
				inform.getPublishDay(),inform.getType(),inform.getPublisher()};
		return this.qr.update(conn, sql, params);
	}

	/**
	 * 删除数据
	 */
	@Override
	public int delete(Integer id) throws Exception {
		String sql = "DELETE FROM inform WHERE id=?";
		return this.qr.update(conn, sql, id);
	}

	/**
	 * 更新数据
	 */
	@Override
	public int update(Inform inform) throws Exception {
		String sql = "UPDATE inform SET title=?,content=?,startDay=?,endDay=?,publishDay=?,type=?,publisher=? WHERE id=?";
		Date date = new java.sql.Date(inform.getStartDay().getTime());
		
		Object[] params = {inform.getTitle(),inform.getContent(),new java.sql.Date(inform.getStartDay().getTime()),new java.sql.Date(inform.getEndDay().getTime()),
				new java.sql.Date(inform.getPublishDay().getTime()),inform.getType(),inform.getPublisher(),inform.getId()};
		return this.qr.update(conn, sql, params);
	}

	/**
	 * 查询所有数据
	 */
	@Override
	public List<Inform> selectAll() throws Exception {
		String sql = "SELECT * from inform";
		return this.qr.query(conn, sql, new BeanListHandler<Inform>(Inform.class));
	}

	
	
}
