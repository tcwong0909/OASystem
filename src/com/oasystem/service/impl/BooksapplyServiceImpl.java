package com.oasystem.service.impl;

import java.sql.Connection;
import java.util.List;

import com.oasystem.bean.Booksapply;
import com.oasystem.dao.IBooksapplyDAO;
import com.oasystem.dao.impl.BooksapplyDAOImpl;
import com.oasystem.service.IBooksapplyService;
import com.oasystem.utils.C3P0Utils;
/**
 * 书籍借阅申请的service实现类
 * @author Administrator
 *
 */
public class BooksapplyServiceImpl implements IBooksapplyService {

	private Connection conn = C3P0Utils.getConnection();
	IBooksapplyDAO DAO=new BooksapplyDAOImpl(conn);

	@Override
	public boolean insert(Booksapply vo) throws Exception {
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
	public boolean update(Booksapply vo) throws Exception {
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
	public List<Booksapply> selectAll() throws Exception {
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
