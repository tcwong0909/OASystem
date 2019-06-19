package com.oasystem.dao.impl;


import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.oasystem.bean.OperationLog;
import com.oasystem.dao.IOperationLogDao;
import com.oasystem.dao.Adapter.DaoAdapter;

public class OperationLogDaoImpl extends DaoAdapter<Integer, OperationLog> implements IOperationLogDao {
	private Connection conn;
	 
	public OperationLogDaoImpl() {
		super();
	}

	public OperationLogDaoImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	
	private QueryRunner qr = new QueryRunner();
	private String sql;
	
	@Override
	public int insert(OperationLog v) throws Exception {
		 sql ="insert into operationLog(operator,operation,remark,time)values(?,?,?,?)";
		 Object [] params= {v.getOperator(),v.getOperation(),v.getRemark(),new Date(v.getTime().getTime())};
		return this.qr.update(conn, sql, params);
	}
	
	@Override
	public List<OperationLog> selectLimit(String kw, Integer cp, Integer ls) throws Exception {
	  sql = "select *from operationLog where operator like ? or operation = ? limit ?,?";
	  Object [] params ={"%"+kw+"%","%"+kw+"%",(cp-1)*ls,ls};
		return this.qr.query(conn, sql, new BeanListHandler<OperationLog>(OperationLog.class),params);
	}
	
	@Override
	public long selectCount() throws Exception {
		sql = "select count(*) from operationLog";
		return this.qr.query(conn, sql, new ScalarHandler<>());
	}
}
