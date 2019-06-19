package com.oasystem.service;

import java.util.List;

import com.oasystem.bean.Function;

//权限表的service
public interface IFunctionService {
	
	/**
	 * 添加一条数据
	 * @param f
	 * @return
	 */
	public int insert(Function f);
	/**
	 * 查询全部的权限数据
	 * @return
	 */
	public List<Function> selectAll();
	
	/**
	 * 修改权限
	 * @param v
	 * @return
	 */
	public int update(Function f);
	
	/**
	 * 通过调用dao层的方法    查到输入的id的权限
	 * @param id
	 * @return
	 */
	public Function selectById(int id);
	/**
	 * 通过调用dao层的方法    查到输入的id删除数据
	 * @param id
	 * @return  
	 */
 	public int deleteById(int id);
 	
 	/**
 	 * 模糊分页查询
 	 * @return
 	 */
 	public List<Function> selectLimit(int cp ,int ls);
}
