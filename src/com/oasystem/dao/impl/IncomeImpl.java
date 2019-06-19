package com.oasystem.dao.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.oasystem.bean.Income;
import com.oasystem.dao.IncomeDAO;
import com.oasystem.dao.Adapter.DaoAdapter;

public class IncomeImpl extends DaoAdapter<Integer, Income> implements IncomeDAO{
	private Connection conn;

	public IncomeImpl() {
	}

	public IncomeImpl(Connection conn) {
		this.conn = conn;
	}

	
	public String sql;
	private QueryRunner qr = new QueryRunner();
	@Override
	public int insert(Income vo) throws Exception {
		sql="INSERT INTO income(name,applyDay,dept,job,applicationReason,status,approver)"
				+ " VALUES(?,?,?,?,?,?,'admin')";
		Object [] params={vo.getName(),new java.sql.Date(vo.getApplyDay().getTime()),vo.getDept(),vo.getJob(),vo.getApplicationReason(),vo.getStatus()};
		return this.qr.update(conn,sql,params);
	}
	@Override
	public int update(Income vo) throws Exception {
		sql="UPDATE income SET name=?,applyDay=?,dept=?,job=?,applicationReason=?,approver=? status=? WHERE id=?";
		Object [] param={vo.getName(),new java.sql.Date(vo.getApplyDay().getTime()),vo.getDept(),vo.getJob(),vo.getApplicationReason(),vo.getApprover(),vo.getStatus(),vo.getId()};
		return this.qr.update(conn,sql,param);
	}
	@Override
	public int delete(Integer id) throws Exception {
		sql="DELETE FROM income WHERE id=?";
		return this.qr.update(conn, sql,id);
	}
	
	@Override
	public List<Income> selectAll() throws Exception {
		sql="SELECT * FROM income";
		return this.qr.query(conn,sql,new BeanListHandler<Income>(Income.class));
	}
}
