package com.oasystem.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.oasystem.bean.Role;
import com.oasystem.dao.IRoleDao;
import com.oasystem.dao.impl.RoleDaoImpl;
import com.oasystem.service.IRoleService;
import com.oasystem.utils.C3P0Utils;

public class RoleServiceImpl implements IRoleService {
	private Connection conn = C3P0Utils.getConnection();
	
	private IRoleDao  rDao = new RoleDaoImpl(conn);
	@Override
	public List<Role> selectAll() {
		try {
			return rDao.selectAll();
		} catch (Exception e) {
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
			return rDao.delete(id);
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
	public int insert(Role role) {
		try {
			return rDao.insert(role);
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
	public int update(Role role) {
		try {
			return rDao.update(role);
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
	public List<Role> selectLimit(String kw, int cp, int ls) {
		try {
			return rDao.selectLimit(kw, cp, ls);
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
