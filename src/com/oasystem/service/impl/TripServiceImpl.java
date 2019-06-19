package com.oasystem.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.oasystem.bean.Trip;
import com.oasystem.dao.ITripDAO;
import com.oasystem.dao.impl.TripDaoImol;
import com.oasystem.service.ITripService;
import com.oasystem.utils.C3P0Utils;

public class TripServiceImpl implements ITripService {
	private Connection conn = C3P0Utils.getConnection();

	ITripDAO tripDAO = new TripDaoImol(conn);

	@Override
	public boolean insert(Trip vo) throws Exception {

		try {
			return this.tripDAO.insert(vo)>0;
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
			return this.tripDAO.delete(id)>0;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			C3P0Utils.close(conn);
		}
		return false;
	}
	
	@Override
	public boolean update(Trip vo) throws Exception {
		try {
			return this.tripDAO.update(vo)>0;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			C3P0Utils.close(conn);
		}
		
		return false;
	}
	
	@Override
	public List<Trip> selectAll() throws Exception {
		try {
			return  this.tripDAO.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			C3P0Utils.close(conn);
		}
		return null;
	}

	@Override
	public Trip selectById(Integer id) throws Exception {
		return null;
	}

	
}
