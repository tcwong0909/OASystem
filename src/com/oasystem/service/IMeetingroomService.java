package com.oasystem.service;

import java.util.List;

import com.oasystem.bean.Meetingroom;

/**
 * 会议室service 接口
 * @author TcWong
 *
 */
public interface IMeetingroomService {

	/**
	 * 添加会议室信息
	 * @param meetingroom
	 * @return
	 * @throws Exception
	 */
	boolean addMeetingroom(Meetingroom meetingroom)throws Exception;
	
	/**
	 * 删除会议室信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	boolean romoveMeetingroom(Integer id) throws Exception;
	
	/**
	 * 编辑会议室信息
	 * @param meetingroom
	 * @return
	 * @throws Exception
	 */
	boolean editMeetingroom(Meetingroom meetingroom) throws Exception;
	
	/**
	 * 查询所有会议室信息
	 * @return
	 * @throws Exception
	 */
	List<Meetingroom> findAllMeetingroom() throws Exception;
	
}
