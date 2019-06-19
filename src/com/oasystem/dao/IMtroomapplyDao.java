package com.oasystem.dao;

import com.oasystem.bean.Mtroomapply;

/**
 * 会议室申请表Dao接口
 * @author TcWong
 *
 */
public interface IMtroomapplyDao extends IDao<Integer, Mtroomapply> {
	
	/**
	 * 申请处理后改变状态码
	 * @param status
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int updateStatus(int status,int id)throws Exception;
}
