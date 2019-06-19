package com.oasystem.dao;

import java.util.List;

import com.oasystem.bean.Function;

public interface IFunctionDao{
	/**
	 * 添加权限
	 * @return
	 */
	public int insert(Function f) throws Exception;
	
	/**
	 * 查询全部的权限数据
	 * @return
	 */
	public List<Function> selectAll()throws Exception ;
	
	/**
	 * 修改权限
	 * @param v
	 * @return
	 */
	public int update(Function f)throws Exception ;
	
	/**
	 * 根据id查到所有权限
	 * @param lid
	 * @return
	 * @throws Exception
	 */
	public Function selectById(int id) throws Exception ;
	
	/**
	 * 根据删除用户时传过来的id,把对应的权限删除
	 * @param lid
	 * @return
	 * @throws Exception
	 */
	public int deleteById(int id) throws Exception;
	
	/**
	 * 模糊分页查询
	 * @param kw  关键字查询
	 * @param cp  哪一页
	 * @param ls  显示多少条数据
	 * @return
	 */
	public List<Function> selectLimit(Integer cp, Integer ls) throws Exception;
}
