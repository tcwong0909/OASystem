package com.oasystem.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.oasystem.bean.User;
import com.oasystem.dao.IFunctionDao;
import com.oasystem.dao.UserDao;
import com.oasystem.dao.impl.FunctionDaoImpl;
import com.oasystem.dao.impl.UserDaoImpl;
import com.oasystem.service.UserService;
import com.oasystem.utils.C3P0Utils;

public class UserServiceImpl implements UserService {
	private Connection conn = C3P0Utils.getConnection();
	
	UserDao userDao = new UserDaoImpl(conn);
	IFunctionDao limit = new FunctionDaoImpl(conn);
	
	
	@Override
	public int insert(User user) {
		try {
			//取消事务的自动提交，该方法涉及到2个事务，要保证事务的原子性
			//conn.setAutoCommit(false);
			//增加用户信息，并且取得自动增长主键值
			//int rowId = this.userDao.insert(user);
			 
			//手动提交事务
			//conn.commit();
			return this.userDao.insert(user);
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
	public User login(String loginName){
		 try {
			 return userDao.login(loginName);
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
	public List<User> selectAll() {
		try {
			return  userDao.selectAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
	public int update(User user) {
		try {
			return userDao.update(user);
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
		 
			return 	userDao.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
	public List<User> selectLimit(String kw, Integer cp, Integer ls) {
		try {
			return userDao.selectLimit(kw, cp, ls);
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
	public int updatePassword(String password, String loginName) {
		try {
			return userDao.updatePassword(password, loginName);
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
		return 0;
	}
	 
	}
	 
	
	

