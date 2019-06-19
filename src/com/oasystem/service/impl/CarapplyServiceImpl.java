package com.oasystem.service.impl;

import java.sql.Connection;
import java.util.List;

import com.oasystem.bean.Carapply;
import com.oasystem.dao.ICarapplyDAO;
import com.oasystem.dao.impl.CarapplyDaoImpl;
import com.oasystem.service.ICarapplyService;
import com.oasystem.utils.C3P0Utils;

/**
 * 用车申请的service实现类
 * 
 * @author Administrator
 *
 */
public class CarapplyServiceImpl implements ICarapplyService {
	private Connection conn = C3P0Utils.getConnection();
	ICarapplyDAO carapplyDao = new CarapplyDaoImpl(conn);

	@Override
	public boolean insert(Carapply vo) throws Exception {
		try {
			return this.carapplyDao.insert(vo)>0;
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
			return this.carapplyDao.delete(id)>0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.close(conn);
		}
		return false;
	}

	@Override
	public boolean update(Carapply vo) throws Exception {
		try {
			return this.carapplyDao.update(vo)>0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.close(conn);
		}
		return false;
	}

	@Override
	public List<Carapply> selectAll() throws Exception {
		try {
			return this.carapplyDao.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.close(conn);
		}
		return null;
	}

}
