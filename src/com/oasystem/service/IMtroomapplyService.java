package com.oasystem.service;

import java.util.List;

import com.oasystem.bean.Mtroomapply;

/**
 * 会议室申请表service 接口
 * @author TcWong
 *
 */
public interface IMtroomapplyService {
	
	/**
	 * 添加会议室申请表
	 * @param mtroomapply
	 * @return
	 * @throws Exception
	 */
	boolean add(Mtroomapply mtroomapply)throws Exception;
	
	/**
	 * 删除会议室申请表
	 * @param id
	 * @return
	 * @throws Exception
	 */
	boolean remove(Integer id) throws Exception;
	
	/**
	 * 编辑会议室申请表
	 * @param mtroomapply
	 * @return
	 * @throws Exception
	 */
	boolean edit(Mtroomapply mtroomapply) throws Exception;
	
	/**
	 * 查询所有表单
	 * @return
	 * @throws Exception
	 */
	List<Mtroomapply> findAll() throws Exception;

	/**
	 * 申请处理后改变状态码
	 * @param status
	 * @param id
	 * @return
	 */
	int  updateStatus(int status ,int id);
}
