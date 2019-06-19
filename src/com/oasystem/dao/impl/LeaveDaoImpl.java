package com.oasystem.dao.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.oasystem.bean.Leaves;
import com.oasystem.bean.User;
import com.oasystem.dao.ILeaveDAO;
import com.oasystem.dao.Adapter.DaoAdapter;

public class LeaveDaoImpl extends DaoAdapter<Integer, Leaves> implements ILeaveDAO{
	    private Connection conn;
	
		public LeaveDaoImpl() {
	}

		public LeaveDaoImpl(Connection conn) {
		this.conn = conn;
	}
		private QueryRunner qr = new QueryRunner();

		@Override
		public int insert(Leaves vo) throws Exception {
			String sql="INSERT INTO leaves(name,dept,startdate,enddate,leaveNumber,type,reason,approver,status) "
					+ " VALUES(?,?,?,?,?,?,?,'admin',0)";
			Object [] params={vo.getName(),vo.getDept(),new java.sql.Date(vo.getStartdate().getTime()),new java.sql.Date(vo.getEnddate().getTime()),vo.getLeaveNumber(),vo.getType(),vo.getReason()};
			return this.qr.update(conn, sql,params);
		}
		
		@Override
		public int update(Leaves vo) throws Exception {
		     String sql="UPDATE leaves SET name=?,dept=?,startdate=?,enddate=?,leaveNumber=?,type=?,reason=?,approver=? WHERE id=?";
		     Object [] params={vo.getName(),vo.getDept(),new java.sql.Date(vo.getStartdate().getTime()),new java.sql.Date(vo.getEnddate().getTime()),vo.getLeaveNumber(),vo.getType(),vo.getReason(),vo.getApprover(),vo.getId()};
		   return this.qr.update(conn, sql, params);
		   
		}
		
		public int updateStatus(int status,int id) throws Exception {
			String sql = "update leaves set status = ? where id = ?";
			Object [] params = {status,id};
			return this.qr.update(conn, sql, params);
		}
		@Override
		public List<Leaves> selectAll() throws Exception {
			String sql="SELECT * FROM leaves";
			return this.qr.query(conn, sql,new BeanListHandler<Leaves>(Leaves.class));
		}
		
		@Override
		public int delete(Integer id) throws Exception {
		String sql="DELETE FROM leaves WHERE id=?";
		return this.qr.update(conn, sql,id);
		}
}
