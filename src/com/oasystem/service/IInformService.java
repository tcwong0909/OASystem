package com.oasystem.service;

import java.util.List;

import com.oasystem.bean.Inform;

/**
 *通告信息Service接口 
 * @author Lenovo
 */
public interface IInformService {
	
	/**
	 * 增加通告信息
	 * @param inform
	 * @return
	 * @throws Exception
	 */
	boolean addInform(Inform inform) throws Exception;
	
	/**
	 * 删除通告
	 * @param id
	 * @return
	 * @throws Exception
	 */
	boolean removeInform(Integer id) throws Exception;
	
	/**
	 * 编辑通告信息
	 * @param inform
	 * @return
	 * @throws Exception
	 */
	boolean editInform(Inform inform)throws Exception;
	
	/**
	 * 查询所有的通告信息
	 * @return
	 * @throws Exception
	 */
	List<Inform> findAllInforms() throws Exception;

}
