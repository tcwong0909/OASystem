package com.oasystem.service.impl;

import java.sql.Connection;
import java.util.List;

import com.oasystem.bean.CardApply;
import com.oasystem.dao.ICardApplyDAO;
import com.oasystem.dao.impl.CardApplyDAOImpl;
import com.oasystem.service.ICardApplyService;
import com.oasystem.utils.C3P0Utils;
/**
 * 名片申请的service层实现类
 * @author Administrator
 *
 */
public class CardApplyServiceImpl implements ICardApplyService {

	private Connection conn = C3P0Utils.getConnection();
	ICardApplyDAO DAO=new CardApplyDAOImpl(conn);
	@Override
	public boolean insert(CardApply vo) throws Exception {
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
	public boolean update(CardApply vo) throws Exception {
		try {
			return this.DAO.update(vo)>0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.close(conn);
		}
		return false;
	}

	@Override
	public List<CardApply> selectAll() throws Exception {
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
