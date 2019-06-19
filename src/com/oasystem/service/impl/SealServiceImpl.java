package com.oasystem.service.impl;

import java.sql.Connection;
import java.util.List;

import com.oasystem.bean.Books;
import com.oasystem.bean.Seal;
import com.oasystem.dao.IBooksDAO;
import com.oasystem.dao.ISealDAO;
import com.oasystem.dao.impl.BooksDaoImpl;
import com.oasystem.dao.impl.SealDAOImpl;
import com.oasystem.service.ISealService;
import com.oasystem.utils.C3P0Utils;

public class SealServiceImpl implements ISealService {

	private Connection conn = C3P0Utils.getConnection();
	ISealDAO DAO=new SealDAOImpl(conn);

	@Override
	public boolean insert(Seal vo) throws Exception {
		try {
			return this.DAO.insert(vo)>0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.close(conn);
		}
		return false;
	}

	@Override
	public boolean delete(Integer id) throws Exception {
		try {
		 return this.DAO.delete(id)>0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.close(conn);
		}
		return false;
	}

	@Override
	public boolean update(Seal vo) throws Exception {
		try {
			return this.DAO.update(vo)>0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.close(conn);
		}
		return false;
	}
	/**
	 * 查询所有印章信息
	 */
	@Override
	public List<Seal> selectAll() throws Exception {
		try {
			return this.DAO.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.close(conn);
		}
		return null;
	}

}
