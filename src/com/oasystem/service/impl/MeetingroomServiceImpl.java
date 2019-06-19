package com.oasystem.service.impl;

import java.sql.Connection;
import java.util.List;

import com.oasystem.bean.Meetingroom;
import com.oasystem.dao.IMeetingRoomDao;
import com.oasystem.dao.impl.MeetingroomDaoImpl;
import com.oasystem.service.IMeetingroomService;
import com.oasystem.utils.C3P0Utils;

/**
 * 会议室service实现类
 * @author TcWong
 *
 */
public class MeetingroomServiceImpl implements IMeetingroomService {
	
	private Connection conn = C3P0Utils.getConnection();
	
	IMeetingRoomDao meetingroomDao = new MeetingroomDaoImpl(conn);

	/**
	 * 添加会议室信息
	 */
	@Override
	public boolean addMeetingroom(Meetingroom meetingroom) throws Exception {
		try {
			return meetingroomDao.insert(meetingroom)>0;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			C3P0Utils.close(conn);
		}
		return false;
	}

	/**
	 * 删除会议室信息
	 */
	@Override
	public boolean romoveMeetingroom(Integer id) throws Exception {
		try {
			return meetingroomDao.delete(id)>0;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			C3P0Utils.close(conn);
		}
		return false;
	}

	/**
	 * 编辑会议室信息
	 */
	@Override
	public boolean editMeetingroom(Meetingroom meetingroom) throws Exception {
		try {
			return meetingroomDao.update(meetingroom)>0;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			C3P0Utils.close(conn);
		}
		return false;
	}

	/**
	 * 查询所有会议室信息
	 */
	@Override
	public List<Meetingroom> findAllMeetingroom() throws Exception {
		try {
			List<Meetingroom> selectAll = meetingroomDao.selectAll();
			return meetingroomDao.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			C3P0Utils.close(conn);
		}
		return null;
	}

}
