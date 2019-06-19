package com.oasystem.service;

import java.util.List;

import com.oasystem.bean.Carapply;

/**
 * 用车申请的service接口
 * @author Administrator
 *
 */
public interface ICarapplyService {
	/**
	 * 调用dao层的insert的方法
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean insert(Carapply vo)throws Exception;
	/**
	 * 调用dao层的delete方法
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean delete(Integer id)throws Exception;
	/**
	 * 调用dao层的update方法
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean update(Carapply vo)throws Exception;
	/**
	 * 调用dao层的slectAll方法
	 * @return
	 * @throws Exception
	 */
	public List<Carapply>selectAll()throws Exception;
	
}
