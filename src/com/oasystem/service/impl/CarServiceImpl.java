package com.oasystem.service.impl;

import java.sql.Connection;
import java.util.List;

import com.oasystem.bean.Car;
import com.oasystem.dao.ICarDAO;
import com.oasystem.dao.impl.CarDaoImpl;
import com.oasystem.service.ICarService;
import com.oasystem.utils.C3P0Utils;
/**
 * 车辆信息的service实现类
 * @author Administrator
 *
 */
public class CarServiceImpl implements ICarService {
	private Connection conn = C3P0Utils.getConnection();
	
	ICarDAO carDAO = new CarDaoImpl(conn);
	
	//添加数据
	@Override
	public boolean insert(Car vo) throws Exception {
		try {
			return this.carDAO.insert(vo)>0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.close(conn);
		}
		return false;
	}
	/**
	 * 删除数据
	 */
	@Override
	public boolean delete(Integer id) throws Exception {
		try {
			return this.carDAO.delete(id)>0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.close(conn);
		}
		return false;
	}
	/**
	 * 修改数据
	 */
	@Override
	public boolean update(Car vo) throws Exception {
		try {
			return this.carDAO.update(vo)>0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.close(conn);
		}
		return false;
	}
	/**
	 * 查询所有数据
	 */
	@Override
	public List<Car> selectAll() throws Exception {
		try {
			return this.carDAO.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.close(conn);
		}
		return null;
	}

}
