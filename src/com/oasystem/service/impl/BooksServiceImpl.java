package com.oasystem.service.impl;

import java.sql.Connection;
import java.util.List;

import com.oasystem.bean.Books;
import com.oasystem.dao.IBooksDAO;
import com.oasystem.dao.impl.BooksDaoImpl;
import com.oasystem.service.IBooksService;
import com.oasystem.utils.C3P0Utils;

/**
 * 书籍信息的service实现类
 * 
 * @author Administrator
 *
 */
public class BooksServiceImpl implements IBooksService {
	private Connection conn = C3P0Utils.getConnection();
	IBooksDAO booksDAO = new BooksDaoImpl(conn);

	@Override
	public boolean insert(Books vo) throws Exception {
		try {
			return this.booksDAO.insert(vo)>0;
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
		 return this.booksDAO.delete(id)>0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.close(conn);
		}
		return false;
	}

	@Override
	public boolean update(Books vo) throws Exception {
		try {
			return this.booksDAO.update(vo)>0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.close(conn);
		}
		return false;
	}

	@Override
	public List<Books> selectAll() throws Exception {
		try {
			return this.booksDAO.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.close(conn);
		}
		return null;
	}

}
