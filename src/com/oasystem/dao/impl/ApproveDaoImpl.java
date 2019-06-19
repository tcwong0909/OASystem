package com.oasystem.dao.impl;

import java.sql.Connection;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.oasystem.bean.Leaves;
import com.oasystem.bean.Mtroomapply;
import com.oasystem.dao.IApproveDao;

/**
 * 审批表Dao实现层
 * @author TcWong
 *
 */
public class ApproveDaoImpl implements IApproveDao {
	
	private Connection conn;
	
	private QueryRunner qr = new QueryRunner();

	public ApproveDaoImpl() {
		super();
	}
	
	public ApproveDaoImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	/**
	 * 会议室申请审批
	 */
	@Override
	public List<Mtroomapply> selectMroomApply( String name) throws Exception {
		String sql = "SELECT * from mtroomapply WHERE approver = ? and status=0";
		return this.qr.query(conn, sql, new BeanListHandler<Mtroomapply>(Mtroomapply.class), name);
	}
	
	/**
	 * 请假审批
	 */
	@Override
	public List<Leaves> selectLeaves(String name) throws Exception {
		String sql = "SELECT * from leaves WHERE approver = ? and status=0";
		return this.qr.query(conn, sql, new BeanListHandler<Leaves>(Leaves.class), name);
	}

}
