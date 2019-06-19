package com.oasystem.dao;

import java.util.List;

import com.oasystem.bean.Schedule;

/**
 * 日程管理Dao接口
 * @author TcWong
 *
 */
public interface IScheduleDao extends IDao<Integer, Schedule> {
	
	/**
	 * 查询数据
	 * @param name
	 * @return
	 * @throws Exception
	 */
	List<Schedule> selectAll(String name) throws Exception;

}
