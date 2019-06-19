package com.oasystem.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.oasystem.bean.Leaves;
import com.oasystem.bean.User;
import com.oasystem.dao.ILeaveDAO;
import com.oasystem.dao.impl.LeaveDaoImpl;
import com.oasystem.service.ILeaveService;
import com.oasystem.utils.C3P0Utils;

public class LeaveServiceImpl implements ILeaveService {
	private Connection conn = C3P0Utils.getConnection();
	
	ILeaveDAO leaveDAO=new LeaveDaoImpl(conn);
	@Override
	public boolean insert(Leaves vo)throws Exception {
		try {
			return this.leaveDAO.insert(vo)>0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			C3P0Utils.close(conn);
		}
		return false;
	}
	
	
	@Override
	public List<Leaves> selectAll() {
		try {
			return this.leaveDAO.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				C3P0Utils.close(conn);
		}
		return null;
	}


	@Override
	public boolean update(Leaves leaves) {
		try {
			return this.leaveDAO.update(leaves)>0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			C3P0Utils.close(conn);
		}
		return false;
	}


	@Override
	public boolean delete(Integer id) {
		try {
			return this.leaveDAO.delete(id)>0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			C3P0Utils.close(conn);
		}
		return false;
	}


	@Override
	public boolean updateStatus(int status, int id) {
		try {
			return this.leaveDAO.updateStatus(status,id)>0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			C3P0Utils.close(conn);
		}
		return false;
	}


	
}
