package com.oasystem.service;

import java.util.List;

import com.oasystem.bean.Income;

public interface IncomeService {
	/**
	 * 增加数据
	 * 
	 * @param v
	 * @return
	 * @throws Exception
	 */
	public boolean insert(Income v) throws Exception;

	/**
	 * 删除数据
	 * 
	 * @param k
	 * @return
	 * @throws Exception
	 */
	public boolean delete(Integer id) throws Exception;

	/**
	 * 修改数据
	 * 
	 * @param v
	 * @return
	 * @throws Exception
	 */
	public boolean update(Income v) throws Exception;

	/**
	 * 查询所有数据
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Income> selectAll() throws Exception;

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Income selectById(Integer id) throws Exception;
}
