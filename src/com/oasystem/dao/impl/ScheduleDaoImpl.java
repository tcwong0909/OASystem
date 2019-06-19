package com.oasystem.dao.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.oasystem.bean.Schedule;
import com.oasystem.dao.IScheduleDao;
import com.oasystem.dao.Adapter.DaoAdapter;

public class ScheduleDaoImpl extends DaoAdapter<Integer, Schedule> implements IScheduleDao {
	
	private Connection conn;
	
	private QueryRunner qr=new QueryRunner();
	
	public ScheduleDaoImpl() {
		super();
	}

	public ScheduleDaoImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	/**
	 * 查询
	 */
	@Override
	public List<Schedule> selectAll(String name) throws Exception {
		String sql = "SELECT * FROM schedule WHERE user =?";
		return this.qr.query(conn, sql, name, new BeanListHandler<Schedule>(Schedule.class));
	}

	/**
	 * 插入数据
	 */
	@Override
	public int insert(Schedule schedule) throws Exception {
		String sql = "INSERT INTO schedule (user, time,remark) VALUES (?,?,?)";
		Object[] params = {schedule.getUser(),new java.sql.Date(schedule.getTime().getTime()) ,schedule.getRemark()};
		return this.qr.update(conn, sql, params);
	}
	
	

}
