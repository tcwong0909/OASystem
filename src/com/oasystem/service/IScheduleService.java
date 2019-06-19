package com.oasystem.service;

import java.util.List;

import com.oasystem.bean.Schedule;

/**
 * 日历Service接口
 * @author TcWong
 *
 */
public interface IScheduleService {
	
	/**
	 * 查询所有日历
	 * @param user
	 * @return
	 * @throws Exception
	 */
	List<Schedule> findAll(String user)throws Exception;
	
	/**
	 * 添加日历
	 * @param schedule
	 * @return
	 * @throws Exception
	 */
	boolean add(Schedule schedule)throws Exception;

}
