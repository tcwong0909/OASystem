package com.oasystem.service.impl;

import java.sql.Connection;
import java.util.List;

import com.oasystem.bean.Schedule;
import com.oasystem.dao.IScheduleDao;
import com.oasystem.dao.impl.ScheduleDaoImpl;
import com.oasystem.service.IScheduleService;
import com.oasystem.utils.C3P0Utils;

public class ScheduleServiceImpl implements IScheduleService{
	
	private Connection conn = C3P0Utils.getConnection();
	
	IScheduleDao scheduleDao = new ScheduleDaoImpl(conn);

	/**
	 * 查询所有
	 */
	@Override
	public List<Schedule> findAll(String user) throws Exception {
		try {
			return scheduleDao.selectAll(user);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			C3P0Utils.close(conn);
		}
		return null;
	}

	/**
	 * 插入数据
	 */
	@Override
	public boolean add(Schedule schedule) throws Exception {
		try {
			return scheduleDao.insert(schedule)>0;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			C3P0Utils.close(conn);
		}
		return false;
	}

}
