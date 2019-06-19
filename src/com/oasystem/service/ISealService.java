package com.oasystem.service;

import java.util.List;

import com.oasystem.bean.Seal;
/**
 * 印章信息service层接口
 * @author Administrator
 *
 */
public interface ISealService {
	/**
	 * 增加印章
	 * 调用dao层的insert方法
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean insert(Seal vo)throws Exception;
	/**
	 * 删除印章
	 * 调用到层的delete方法
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean delete(Integer id)throws  Exception;
	/**
	 * 修改印章信息
	 * 调用到层的update方法
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean update(Seal vo)throws Exception;
	/**
	 * 查询所有的印章信息
	 * 调用dao层的selectAll方法
	 * @return
	 * @throws Exception
	 */
	public List<Seal> selectAll()throws Exception;
}
