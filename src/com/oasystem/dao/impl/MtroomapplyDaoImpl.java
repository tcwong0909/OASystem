package com.oasystem.dao.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.naming.java.javaURLContextFactory;

import com.oasystem.bean.Mtroomapply;
import com.oasystem.dao.IMtroomapplyDao;
import com.oasystem.dao.Adapter.DaoAdapter;

/**
 * 会议室申请表Dao 实现类
 * @author TcWong
 *
 */
public class MtroomapplyDaoImpl extends DaoAdapter<Integer, Mtroomapply> implements IMtroomapplyDao {

	private Connection conn;
	
	private QueryRunner qr = new QueryRunner();

	public MtroomapplyDaoImpl() {
		super();
	}

	public MtroomapplyDaoImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	/**
	 * 添加数据
	 */
	@Override
	public int insert(Mtroomapply mtroomapply) throws Exception {
		String sql = "INSERT INTO mtroomapply (startDay,endDay,userName,type,mtId,approver,status) VALUES(?,?,?,?,?,?,?)";
		Object[] params = {new java.sql.Date(mtroomapply.getStartDay().getTime()),new java.sql.Date(mtroomapply.getEndDay().getTime()),mtroomapply.getUserName(),
				mtroomapply.getType(),mtroomapply.getMtId(),mtroomapply.getApprover(),mtroomapply.getStatus()};
		return this.qr.update(conn, sql, params);
	}

	/**
	 * 删除数据
	 */
	@Override
	public int delete(Integer id) throws Exception {
		String sql = "DELETE FROM mtroomapply WHERE id=?";
		return this.qr.update(conn, sql, id);
	}

	/**
	 * 更新数据
	 */
	@Override
	public int update(Mtroomapply mtroomapply) throws Exception {
		String sql = "UPDATE mtroomapply SET startDay=?,endDay=?,userName=?,type=?,mtId=?,approver=?,status=? WHERE id=?";
		Object[] params = {new java.sql.Date(mtroomapply.getStartDay().getTime()),new java.sql.Date(mtroomapply.getEndDay().getTime()),mtroomapply.getUserName(),
				mtroomapply.getType(),mtroomapply.getMtId(),mtroomapply.getApprover(),mtroomapply.getStatus(),mtroomapply.getId()};
		return this.qr.update(conn, sql, params);
	}

	/**
	 * 查询所有数据
	 */
	@Override
	public List<Mtroomapply> selectAll() throws Exception {
		String sql = "SELECT * from mtroomapply";
		return this.qr.query(conn, sql, new BeanListHandler<Mtroomapply>(Mtroomapply.class));
	}

	@Override
	public int updateStatus(int status, int id) throws Exception {
		String sql = "update mtroomapply set status= ? where id = ?";
		Object [] params ={status,id};
		return this.qr.update(conn, sql, params);
	}
	
	
	
}
