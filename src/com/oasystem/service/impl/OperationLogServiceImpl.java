package com.oasystem.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.oasystem.bean.OperationLog;
import com.oasystem.dao.IOperationLogDao;
import com.oasystem.dao.impl.OperationLogDaoImpl;
import com.oasystem.service.IOperationLogService;
import com.oasystem.utils.C3P0Utils;

public class OperationLogServiceImpl implements IOperationLogService {
	private Connection conn = C3P0Utils.getConnection();
	
	private IOperationLogDao  op = new OperationLogDaoImpl(conn);
	@Override
	public int insert(OperationLog log) {
	 try {
		return op.insert(log);
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
	public List<OperationLog> selectLimit(String kw, int cp, int ls) {
		 try {
				return op.selectLimit(kw, cp, ls);
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

	 @Override
	public int delete(int id) {
		try {
			return op.delete(id);
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
	public int selectCount() {
		 try {
				return (int)op.selectCount();
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

}
