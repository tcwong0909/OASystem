package com.oasystem.dao;

import java.util.List;

import com.oasystem.bean.Leaves;
import com.oasystem.bean.Mtroomapply;
/**
 * 审批Dao接口
 * @author TcWong
 *
 */
public interface IApproveDao {
	
	/**
	 * 查询会议室审批
	 * @return
	 * @throws Exception
	 */
	List<Mtroomapply> selectMroomApply(String name) throws Exception;
	
	/**
	 * 查询请假审批
	 * @return
	 * @throws Exception
	 */
	List<Leaves> selectLeaves(String name)throws Exception;

}
