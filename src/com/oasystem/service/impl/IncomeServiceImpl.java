package com.oasystem.service.impl;

import java.sql.Connection;
import java.util.List;

import com.oasystem.bean.Income;
import com.oasystem.dao.IncomeDAO;
import com.oasystem.dao.impl.IncomeImpl;
import com.oasystem.service.IncomeService;
import com.oasystem.utils.C3P0Utils;

public class IncomeServiceImpl implements IncomeService {
	private Connection conn = C3P0Utils.getConnection();
	IncomeDAO incomDAO = new IncomeImpl(conn);

	@Override
	public boolean insert(Income v) throws Exception {
		try {
			return this.incomDAO.insert(v)>0;
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
			return this.incomDAO.delete(id)>0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.close(conn);
		}
		return false;
	}

	@Override
	public boolean update(Income v) throws Exception {
		try {
			return this.incomDAO.update(v)>0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.close(conn);
		}
		return false;
	}

	@Override
	public List<Income> selectAll() throws Exception {
		try {
			return this.incomDAO.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.close(conn);
		}
		return null;
	}

	@Override
	public Income selectById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
