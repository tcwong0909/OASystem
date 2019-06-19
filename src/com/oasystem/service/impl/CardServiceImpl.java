package com.oasystem.service.impl;

import java.sql.Connection;
import java.util.List;

import com.oasystem.bean.Books;
import com.oasystem.bean.Card;
import com.oasystem.dao.IBooksDAO;
import com.oasystem.dao.ICardDAO;
import com.oasystem.dao.impl.BooksDaoImpl;
import com.oasystem.dao.impl.CarDaoImpl;
import com.oasystem.dao.impl.CardDAOImpl;
import com.oasystem.service.ICardService;
import com.oasystem.utils.C3P0Utils;

public class CardServiceImpl implements ICardService {

	private Connection conn = C3P0Utils.getConnection();
	ICardDAO DAO=new CardDAOImpl(conn);
	@Override
	public boolean insert(Card vo) throws Exception {
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
	public boolean update(Card vo) throws Exception {
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
	public List<Card> selectAll() throws Exception {
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
