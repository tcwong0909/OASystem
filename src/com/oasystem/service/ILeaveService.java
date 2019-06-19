package com.oasystem.service;

import java.util.List;

import com.oasystem.bean.Leaves;
import com.oasystem.bean.User;

public interface ILeaveService {
	/**
	 * 调用dao层的insert()方法
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean insert(Leaves vo) throws Exception;
	/**
	 * 调用dao层的selectAll()方法
	 * 查询所有请假记录
	 * @return
	 */
	public List<Leaves> selectAll() throws Exception; 
	
	/**
	 * 调用dao层的update方法   
	 * 修改指定的用户
	 * @param 
	 * @return
	 */
	public boolean  update(Leaves leaves);
	/**
	 * 调用dao层的的delete方法
	 * @param id
	 * @return
	 */
	public boolean delete(Integer id);
	
	/**
	 * 调用dao层的的updateStatus方法
	 * 通过处理审批  该掉状态
	 * @param status
	 * @param id
	 * @return
	 */
	public boolean updateStatus(int status,int id);
	
}
