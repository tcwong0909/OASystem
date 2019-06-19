package com.oasystem.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.oasystem.bean.Message;
import com.oasystem.dao.IMessageDao;
import com.oasystem.dao.IMtroomapplyDao;
import com.oasystem.dao.impl.IMessageDaoImpl;
import com.oasystem.dao.impl.MtroomapplyDaoImpl;
import com.oasystem.service.IMessageService;
import com.oasystem.utils.C3P0Utils;

public class MessageServiceImpl implements IMessageService {

	private Connection conn = C3P0Utils.getConnection();
	
	IMessageDao mDao = new IMessageDaoImpl(conn);
	@Override
	public int insert(Message m) {
		try {
			return mDao.insert(m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int delete(int id) {
		try {
			return mDao.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public List<Message> selectAll() {
		try {
			return mDao.selectAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
