package com.oasystem.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.oasystem.bean.Leaves;
import com.oasystem.bean.Mtroomapply;
import com.oasystem.dao.IApproveDao;
import com.oasystem.dao.impl.ApproveDaoImpl;
import com.oasystem.utils.C3P0Utils;

public class AppleServiceImpl {

	private Connection conn = C3P0Utils.getConnection();
	
	IApproveDao approveDao = new ApproveDaoImpl(conn);
	
	public List<Mtroomapply> find1(String name){
			try {
			return approveDao.selectMroomApply(name);
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
	
	public List<Leaves> find2(String name){
		try {
		return approveDao.selectLeaves(name);
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
