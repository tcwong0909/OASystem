package com.oasystem.service;

import java.util.List;

import com.oasystem.bean.Sealapply;

/**
 * 印章申请的service接口
 * @author Administrator
 *
 */
public interface ISealapplyService {
	/**
	 * 增加印章申请
	 * 调用dao层的增加方法
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean insert(Sealapply vo)throws Exception;
	/**
	 * 删除印章申请信息
	 * 调用dao层的删除方法
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean delete(Integer id)throws Exception;
	/**
	 * 修改印章申请信息
	 * 调用dao层的update方法
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean update(Sealapply vo)throws Exception;
	/**
	 * 查询所有印章信息的方法
	 * 调用dao层的selectAll方法
	 * @return
	 * @throws Exception
	 */
	public List<Sealapply> selectAll()throws Exception;
}
