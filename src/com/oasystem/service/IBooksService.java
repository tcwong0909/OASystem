package com.oasystem.service;

import java.util.List;

import com.oasystem.bean.Books;

/**
 * 书籍信息的service接口
 * @author Administrator
 *
 */
public interface IBooksService {
	/**
	 * 增加书籍
	 * 调用dao层的insert方法
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean insert(Books vo)throws Exception;
	/**
	 * 删除书籍
	 * 调用到层的delete方法
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean delete(Integer id)throws  Exception;
	/**
	 * 修改书籍信息
	 * 调用到层的update方法
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean update(Books vo)throws Exception;
	/**
	 * 查询所有的书籍信息
	 * 调用dao层的selectAll方法
	 * @return
	 * @throws Exception
	 */
	public List<Books> selectAll()throws Exception;
}
