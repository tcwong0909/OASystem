package com.oasystem.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.oasystem.bean.WebAddress;
import com.oasystem.dao.IWebAddressDao;
import com.oasystem.dao.UserDao;
import com.oasystem.dao.impl.UserDaoImpl;
import com.oasystem.dao.impl.WebAddressDaoImpl;
import com.oasystem.service.IWebAddressService;
import com.oasystem.utils.C3P0Utils;

public class WebAddressServiceImpl implements IWebAddressService {
private Connection conn = C3P0Utils.getConnection();
	
	IWebAddressDao  Dao = new WebAddressDaoImpl(conn);
	
	@Override
	public int insert(WebAddress v) {
		 try {
			return Dao.insert(v);
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
				return Dao.delete(id);
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
	public int update(WebAddress v) {
		 try {
				return Dao.update(v);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
	              conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		return 0;
	}

	@Override
	public List<WebAddress> selectAll(String user) {
		 try {
				return Dao.selectAll(user);
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
