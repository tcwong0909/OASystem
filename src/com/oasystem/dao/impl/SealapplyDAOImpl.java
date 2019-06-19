package com.oasystem.dao.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.oasystem.bean.Sealapply;
import com.oasystem.dao.ISealapplyDAO;
/**
 * 印章申请的dao层实现类
 * @author Administrator
 *
 */
public class SealapplyDAOImpl implements ISealapplyDAO {
	private Connection conn;
	 
	public SealapplyDAOImpl() {
		super();
	}
 
	public SealapplyDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	} 
	
	private String sql;
	private QueryRunner qr = new QueryRunner();
	@Override
	public int insert(Sealapply vo) throws Exception {
		sql="insert into sealapply(applyer,applyDay,dept,reason,approver,status,sealId) values(?,?,?,?,?,?,?);";
		Object [] params={vo.getApplyer(),new java.sql.Date(vo.getApplyDay().getTime()),vo.getDept(),vo.getReason(),vo.getApprover(),vo.getStatus(),vo.getSealId()};
		return this.qr.update(conn,sql,params);
	}

	@Override
	public int delete(Integer id) throws Exception {
		sql="DELETE sealapply WHERE id=?";
		return this.qr.update(conn, sql, id);
	}

	@Override
	public int update(Sealapply vo) throws Exception {
		sql="UPDATE sealapply SET applyer=?,applyDay=?,dept=?,reason=?,approver=?,status=?,sealId=? WHERE id=?";
		Object [] params={vo.getApplyer(),new java.sql.Date(vo.getApplyDay().getTime()),vo.getDept(),vo.getReason(),vo.getApprover(),vo.getStatus(),vo.getSealId(),vo.getId()};
		return this.qr.update(conn, sql, params);
	}

	@Override
	public List<Sealapply> selectAll() throws Exception {
		sql="SELECT * FROM sealapply;";
		return this.qr.query(conn, sql, new BeanListHandler<Sealapply>(Sealapply.class));
	}

	@Override
	public Sealapply selectById(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sealapply> selectAll(String user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sealapply> selectLimit(String kw, Integer cp, Integer ls) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
