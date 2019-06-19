package com.oasystem.dao.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.oasystem.bean.Trip;
import com.oasystem.bean.User;
import com.oasystem.dao.ITripDAO;
import com.oasystem.dao.Adapter.DaoAdapter;

public class TripDaoImol extends DaoAdapter<Integer, Trip> implements ITripDAO {
	private Connection conn;
	
	public TripDaoImol() {
     }
	public TripDaoImol(Connection conn) {
		this.conn=conn;
    }
	
	public String sql;
	private QueryRunner qr = new QueryRunner();
	@Override
	public int insert(Trip vo) throws Exception {
		sql="INSERT INTO trip(name,dept,stardate,enddate,place,loanAmount,tripReason,task,approver,status)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,'admin')";
		Object [] params={vo.getName(),vo.getDept(),new java.sql.Date(vo.getStardate().getTime()),new java.sql.Date(vo.getEnddate().getTime()),vo.getPlace(),vo.getLoanAmount(),vo.getTripReason(),vo.getTask(),vo.getStatus()};
		
		return qr.update(conn,sql,params);
	}

	@Override
	public int delete(Integer id) throws Exception {
		sql="DELETE FROM trip WHERE id=?";
		return this.qr.update(conn,sql,id);
	}
	
	@Override
	public int update(Trip vo) throws Exception {
		sql="UPDATE trip SET name=?,dept=?,stardate=?,enddate=?,place=?,loanAmount=?,tripReason=?,task=?,approver=?,status=? WHERE id=?";
		Object [] param={vo.getName(),vo.getDept(),new java.sql.Date(vo.getStardate().getTime()),new java.sql.Date(vo.getEnddate().getTime()),vo.getPlace(),vo.getLoanAmount(),vo.getTripReason(),vo.getTask(),vo.getApprover(),vo.getStatus(),vo.getId()};
		return this.qr.update(conn,sql,param);
	}

	@Override
	public List<Trip> selectAll() throws Exception {
		sql="select * from trip ";
		return qr.query(conn, sql, new BeanListHandler<Trip>(Trip.class));
	}

	@Override
	public Trip selectById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
