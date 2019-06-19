package com.oasystem.dao.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.oasystem.bean.Meetingroom;
import com.oasystem.dao.IMeetingRoomDao;
import com.oasystem.dao.Adapter.DaoAdapter;

/**
 * 会议室Dao实现层
 * @author TcWong
 */
public class MeetingroomDaoImpl extends DaoAdapter<Integer, Meetingroom> implements IMeetingRoomDao{
	
	private Connection conn;
	
	private QueryRunner qr=new QueryRunner();
	
	public MeetingroomDaoImpl() {
		super();
	}

	public MeetingroomDaoImpl(Connection conn) {
		super();
		this.conn = conn;
	}


	/**
	 * 插入会议室信息
	 */
	@Override
	public int insert(Meetingroom meetingroom) throws Exception {
		String sql = "INSERT INTO meetingroom (name,description) VALUES(?,?)";
		Object[] params = {meetingroom.getName(),meetingroom.getDescription()};
		return this.qr.update(conn, sql, params);
	}

	/**
	 * 删除会议室信息
	 */
	@Override
	public int delete(Integer id) throws Exception {
		String sql = "DELETE FROM meetingroom WHERE id=?";
		return this.qr.update(conn, sql, id);
	}

	/**
	 * 更新会议室信息
	 */
	@Override
	public int update(Meetingroom meetingroom) throws Exception {
		String sql = "UPDATE meetingroom SET name=?,description=? WHERE id=?";
		Object[] params = {meetingroom.getName(),meetingroom.getDescription(),meetingroom.getId()};
		return this.qr.update(conn, sql, params);
	}

	/**
	 * 查询所有信息
	 */
	@Override
	public List<Meetingroom> selectAll() throws Exception {
		String sql = "SELECT * FROM meetingroom";
		return this.qr.query(conn, sql, new BeanListHandler<Meetingroom>(Meetingroom.class));
	}

	
}
