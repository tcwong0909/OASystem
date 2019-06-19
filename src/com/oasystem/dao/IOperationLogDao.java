package com.oasystem.dao;

import com.oasystem.bean.OperationLog;

public interface IOperationLogDao extends IDao<Integer,OperationLog>{
	/**
	 * 查询总数据量
	 * @return
	 */
	public long selectCount() throws Exception ;
}
