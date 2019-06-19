package com.oasystem.service;

import java.util.List;

import com.oasystem.bean.Trip;

public interface ITripService {
	/**
	 * 增加数据
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean insert(Trip vo)throws Exception;
	
	/**
	 * 删除数据
	 * @param id
	 * @return
	 * @throws Exception
	 */
	
	public	boolean delete(Integer id) throws Exception;
	
	/**
	 * 修改数据
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean update(Trip vo)throws Exception;
	
	/**
	 * 查询所有数据
	 * @return
	 * @throws Exception
	 */
	public List<Trip> selectAll() throws Exception;
	
	/**
	 * 根据id查询
	 * @param k
	 * @return
	 * @throws Exception
	 */
	public Trip selectById(Integer id) throws Exception;

	
}
