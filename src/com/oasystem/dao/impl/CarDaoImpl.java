package com.oasystem.dao.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.oasystem.bean.Car;
import com.oasystem.dao.ICarDAO;
import com.oasystem.dao.Adapter.DaoAdapter;
/**
 * 车辆信息dao层的实现类
 * @author Administrator
 *
 */
@SuppressWarnings("all")
public class CarDaoImpl extends DaoAdapter<Integer, Car> implements ICarDAO {
	private Connection conn;
	private QueryRunner qr=new QueryRunner();
	private String sql;

	public CarDaoImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public CarDaoImpl() {
		super();
	}
	/**
	 * 添加车辆信息的方法
	 */
	@Override
	public int insert(Car vo) throws Exception {
		sql="INSERT INTO car(id,plateNumber,type,remark)"
				+ " VALUES(?,?,?,?)";
		Object [] param={vo.getId(),vo.getPlateNumber(),vo.getType(),vo.getRemark()};
		return this.qr.update(conn, sql, param);
	}
	/**
	 * 删除车辆信息方法
	 */
	@Override
	public int delete(Integer id) throws Exception {
		sql="DELETE FROM car WHERE id=?";
		return this.qr.update(conn, sql,id);
	}
	/**
	 * 修改车辆信息的方法
	 */
	@Override
	public int update(Car vo) throws Exception {
		sql="UPDATE car SET plateNumber=?,type=?,remark=? WHERE id=?";
		Object [] param={vo.getPlateNumber(),vo.getType(),vo.getRemark(),vo.getId()};
		return this.qr.update(conn,sql, param);
	}
	/**
	 * 查询所有车辆信息的方法
	 */
	@Override
	public List<Car> selectAll() throws Exception {
		sql="SELECT * FROM car";
		return this.qr.query(conn, sql, new BeanListHandler<Car>(Car.class));
	}

	@Override
	public Car selectById(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> selectLimit(String kw, Integer cp, Integer ls) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
