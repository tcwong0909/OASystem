package com.oasystem.service;

import java.util.List;

import com.oasystem.bean.OperationLog;

public interface IOperationLogService {
	/**
	 * 添加一条数据
	 * @param log
	 * @return
	 */
	public int insert(OperationLog log);
	
	
	/**
	 * 删除一条数据
	 * @param id
	 * @return
	 */
	public int delete(int id);
	/**
	 * 模糊分页查询
	 * @param kw
	 * @param cp
	 * @param ls
	 * @return
	 */
	public List<OperationLog> selectLimit(String kw ,int cp,int ls);
	
	/**
	 * 查询全部的数据的数量
	 * @return
	 */
	public int selectCount();
}
