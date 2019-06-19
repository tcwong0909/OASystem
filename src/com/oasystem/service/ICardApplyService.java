package com.oasystem.service;

import java.util.List;

import com.oasystem.bean.CardApply;

public interface ICardApplyService {
	/**
	 * 增加名片申请 调用dao层的insert方法
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean insert(CardApply vo) throws Exception;

	/**
	 * 删除名片申请 调用到层的delete方法
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean delete(Integer id) throws Exception;

	/**
	 * 修改名片申请信息 调用到层的update方法
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean update(CardApply vo) throws Exception;

	/**
	 * 查询所有的名片申请信息 调用dao层的selectAll方法
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<CardApply> selectAll() throws Exception;
}
