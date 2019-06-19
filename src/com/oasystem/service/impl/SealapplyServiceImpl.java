package com.oasystem.service.impl;

import java.sql.Connection;
import java.util.List;

import com.oasystem.bean.Sealapply;
import com.oasystem.dao.IScheduleDao;
import com.oasystem.dao.ISealDAO;
import com.oasystem.dao.ISealapplyDAO;
import com.oasystem.dao.impl.ScheduleDaoImpl;
import com.oasystem.dao.impl.SealapplyDAOImpl;
import com.oasystem.service.ISealapplyService;
import com.oasystem.utils.C3P0Utils;
/**
 * 印章申请的service实现类
 * @author Administrator
 *
 */
public class SealapplyServiceImpl implements ISealapplyService {
	private Connection conn = C3P0Utils.getConnection();

	ISealapplyDAO DAO = new SealapplyDAOImpl(conn);
	/**
	 * 增加印章申请
	 */
	@Override
	public boolean insert(Sealapply vo) throws Exception {
		try {
			return this.DAO.insert(vo) > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.close(conn);
		}
		return false;
	}
	/**
	 * 删除印章申请 
	 */
	@Override
	public boolean delete(Integer id) throws Exception {
		try {
			return this.DAO.delete(id) > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.close(conn);
		}
		return false;
	}
	/**
	 * 修改印章申请信息
	 */
	@Override
	public boolean update(Sealapply vo) throws Exception {
		try {
			return this.DAO.update(vo) > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.close(conn);
		}
		return false;
	}
	/**
	 * 查询所有印章申请信息
	 */
	@Override
	public List<Sealapply> selectAll() throws Exception {
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
