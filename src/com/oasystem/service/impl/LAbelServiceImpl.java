package com.oasystem.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.oasystem.bean.Label;
import com.oasystem.dao.ILabelDao;
import com.oasystem.dao.impl.LabelDaoImpl;
import com.oasystem.service.ILAbelService;
import com.oasystem.utils.C3P0Utils;

public class LAbelServiceImpl implements ILAbelService {
	private Connection conn = C3P0Utils.getConnection();
	
	private ILabelDao ldao = new LabelDaoImpl(conn);
	
	@Override
	public int insert(Label l) {
		try {
			return ldao.insert(l);
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
			return ldao.delete(id);
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
	public List<Label> selectAll() {
		try {
			return ldao.selectAll();
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
