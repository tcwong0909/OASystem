package com.oasystem.service;

import java.util.List;

import com.oasystem.bean.Booksapply;

public interface IBooksapplyService {
	/**
	 * 增加书籍借阅申请
	 * 调用dao层的insert方法
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean insert(Booksapply vo)throws Exception;
	/**
	 * 删除书籍借阅申请
	 * 调用到层的delete方法
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean delete(Integer id)throws  Exception;
	/**
	 * 修改书籍信息借阅申请
	 * 调用到层的update方法
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean update(Booksapply vo)throws Exception;
	/**
	 * 查询所有的书籍借阅申请信息
	 * 调用dao层的selectAll方法
	 * @return
	 * @throws Exception
	 */
	public List<Booksapply> selectAll()throws Exception;
}
