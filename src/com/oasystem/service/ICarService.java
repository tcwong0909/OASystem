package com.oasystem.service;

import java.util.List;

import com.oasystem.bean.Car;

/**
 * 车辆信息的service层接口
 * @author Administrator
 *
 */
public interface ICarService {
	/**
	 * 调用dao层的insertf方法
	 * 添加车辆信息的方法
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean insert(Car vo)throws Exception;
	/**
	 * 调用dao层的delete方法
	 * @param id 需要删除数据的id
	 * 根据id删除数据
	 * @return
	 * @throws Exception
	 */
	public boolean delete(Integer id)throws Exception;
	/**
	 * 调用dao层的update方法
	 * 修改数据
	 * @param vo 
	 * @return
	 * @throws Exception
	 */
	public boolean update(Car vo)throws Exception;
	/**
	 * 查询所有的数据
	 * @return
	 * @throws Exception
	 */
	public List<Car> selectAll()throws Exception;
}
