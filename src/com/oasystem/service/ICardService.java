package com.oasystem.service;

import java.util.List;

import com.oasystem.bean.Card;
/**
 * 名片service接口
 * @author Administrator
 *
 */
public interface ICardService {
	/**
	 * 增加名片 调用dao层的insert方法
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean insert(Card vo) throws Exception;

	/**
	 * 删除名片 调用到层的delete方法
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean delete(Integer id) throws Exception;

	/**
	 * 修改名片信息 调用到层的update方法
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean update(Card vo) throws Exception;

	/**
	 * 查询所有的名片信息 调用dao层的selectAll方法
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Card> selectAll() throws Exception;
}
