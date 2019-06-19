package com.oasystem.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.oasystem.bean.Function;
import com.oasystem.dao.IFunctionDao;
import com.oasystem.dao.impl.FunctionDaoImpl;
import com.oasystem.service.IFunctionService;
import com.oasystem.utils.C3P0Utils;

public class FunctionServiceImpl implements IFunctionService {
	private Connection conn = C3P0Utils.getConnection();
	 
	IFunctionDao fDao = new FunctionDaoImpl(conn);
	
	
	@Override
	public int insert(Function f) {
		try {
			return fDao.insert(f);
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
	};
	
	
	
	@Override
	public List<Function> selectAll() {
		 try {
			return fDao.selectAll();
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
	public int update(Function f) {
		 try {
			return fDao.update(f);
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
	public Function selectById(int lid) {
		 try {
			return fDao.selectById(lid);
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
	public int deleteById(int lid) {
		try {
			return fDao.deleteById(lid);
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
	public List<Function> selectLimit(int cp ,int ls) {
		 try {
			return fDao.selectLimit(cp, ls);
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
