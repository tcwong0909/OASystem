package com.oasystem.dao;

import java.util.List;

import com.oasystem.bean.Leaves;
/**
 * 请假申请
 * @author Administrator
 *
 */
public interface ILeaveDAO extends IDao<Integer, Leaves> {
		
	public int updateStatus(int status,int id) throws Exception;
}
