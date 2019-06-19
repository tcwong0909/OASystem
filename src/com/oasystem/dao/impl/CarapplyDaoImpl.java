package com.oasystem.dao.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.oasystem.bean.Carapply;
import com.oasystem.dao.ICarapplyDAO;
import com.oasystem.dao.Adapter.DaoAdapter;
/**
 * 申请车辆的dao层实现类
 * @author Administrator
 *
 */
public class CarapplyDaoImpl extends DaoAdapter<Integer, Carapply> implements ICarapplyDAO {
	private Connection conn;
	
	public CarapplyDaoImpl() {
		super();
	}

	public CarapplyDaoImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	private QueryRunner qr=new QueryRunner();
	private String sql;
	/**
	 * 添加车辆申请
	 */
	@Override
	public int insert(Carapply vo) throws Exception {
		sql="INSERT INTO carapply(driver,userName,companyer,dept,startDay,endDay,destination,mileage,reason,status,approver)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,0,'admin')";
		Object [] params={vo.getDriver(),vo.getUserName(),vo.getCompanyer(),vo.getDept(),new java.sql.Date(vo.getStartDay().getTime()),new java.sql.Date(vo.getEndDay().getTime()),vo.getDestination(),vo.getMileage(),vo.getReason()};
		return this.qr.update(conn, sql, params);
	}
	/**
	 * 删除用车申请
	 */
	@Override
	public int delete(Integer id) throws Exception {
		sql="DELETE FROM carapply WHERE id=?";
		return this.qr.update(conn, sql,id);
	}
	/**
	 * 修改用车申请
	 */
	@Override
	public int update(Carapply vo) throws Exception {
		sql="UPDATE  carapply SET driver=?,userName=?,companyer=?,dept=?,startDay=?,endDay=?,destination=?,mileage=?,reason=?,status=?,Approver=? WHERE id=?";
		Object [] params={vo.getDriver(),vo.getUserName(),vo.getCompanyer(),vo.getDept(),new java.sql.Date(vo.getStartDay().getTime()),new java.sql.Date(vo.getEndDay().getTime()),vo.getDestination(),vo.getMileage(),vo.getReason(),vo.getStatus(),vo.getApprover(),vo.getId()};
		return this.qr.update(conn, sql,params);
	}
	/**
	 * 查询所有用车申请
	 */
	@Override
	public List<Carapply> selectAll() throws Exception {
		sql="SELECT * FROM carapply";
		return this.qr.query(conn, sql,new BeanListHandler<Carapply>(Carapply.class));
	}

	@Override
	public Carapply selectById(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Carapply> selectLimit(String kw, Integer cp, Integer ls) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
