package com.oasystem.service.impl;

import java.sql.Connection;
import java.util.List;

import com.oasystem.bean.Inform;
import com.oasystem.dao.IInformDao;
import com.oasystem.dao.impl.InformDaoImpl;
import com.oasystem.service.IInformService;
import com.oasystem.utils.C3P0Utils;

public class InformServiceImpl implements IInformService {
	
	private Connection conn = C3P0Utils.getConnection();
	
	IInformDao informDao = new InformDaoImpl(conn);

	/**
	 * 添加通告信息
	 */
	@Override
	public boolean addInform(Inform inform) throws Exception {
		try {
			return informDao.insert(inform)>0;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			C3P0Utils.close(conn);
		}
		return false;
	}

	/**
	 * 删除通告信息
	 */
	@Override
	public boolean removeInform(Integer id) throws Exception {
		try {
			return informDao.delete(id)>0;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			C3P0Utils.close(conn);
		}
		return false;
	}

	/**
	 * 编辑通告信息
	 */
	@Override
	public boolean editInform(Inform inform) throws Exception {
		try {
			return informDao.update(inform)>0;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			C3P0Utils.close(conn);
		}
		return false;
	}

	/**
	 * 查询所有通告信息
	 */
	@Override
	public List<Inform> findAllInforms() throws Exception {
		try {
			return informDao.selectAll();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			C3P0Utils.close(conn);
		}
		return null;
	}

}
