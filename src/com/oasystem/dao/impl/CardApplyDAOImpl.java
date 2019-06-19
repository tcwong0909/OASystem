package com.oasystem.dao.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.oasystem.bean.CardApply;
import com.oasystem.dao.ICardApplyDAO;

public class CardApplyDAOImpl implements ICardApplyDAO {

	private Connection conn;
	private QueryRunner qr=new QueryRunner();
	private String sql;
	
	public CardApplyDAOImpl() {
		super();
	}

	public CardApplyDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	/**
	 * 增加书籍的方法
	 */
	@Override
	public int insert(CardApply vo) throws Exception {
		sql="INSERT INTO cardApply(applyDate,name,dept,job,mb,tel,cardNumber,remark,status,approver)"
				+ "  VALUES(?,?,?,?,?,?,?,?,?,'admin')";
		Object [] params={new java.sql.Date(vo.getApplyDate().getTime()),vo.getName(),vo.getDept(),vo.getJob(),vo.getMb(),vo.getTel(),vo.getCardNumber(),vo.getRemark(),vo.getStatus()};
		return this.qr.update(conn,sql,params);
	}
	/**
	 * 删除书籍信息的方法
	 */
	@Override
	public int delete(Integer id) throws Exception {
		sql="DELETE FROM cardApply WHERE id=?";
		return this.qr.update(conn, sql,id);
	}
	/**
	 * 修改书籍的方法
	 */
	@Override
	public int update(CardApply vo) throws Exception {
		sql="UPDATE cardApply SET applyDate=?,name=?,dept=?,job=?,mb=?,tel=?,cardNumber=?,remark=?,status=?,approver=? WHERE id=?";
		Object [] params={new java.sql.Date(vo.getApplyDate().getTime()),vo.getName(),vo.getDept(),vo.getJob(),vo.getMb(),vo.getTel(),vo.getCardNumber(),vo.getRemark(),vo.getStatus(),vo.getApprover(),vo.getId()};
		return this.qr.update(conn,sql,params);
	}
	/**
	 * 查询所有书籍信息的方法
	 */
	@Override
	public List<CardApply> selectAll() throws Exception {
		sql="SELECT * FROM cardApply";
		return this.qr.query(conn,sql, new BeanListHandler<CardApply>(CardApply.class));
	}

	@Override
	public CardApply selectById(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CardApply> selectLimit(String kw, Integer cp, Integer ls) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CardApply> selectAll(String user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	
}
