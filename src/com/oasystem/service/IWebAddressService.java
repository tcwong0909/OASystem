package com.oasystem.service;

import java.util.List;

import com.oasystem.bean.WebAddress;

public interface IWebAddressService {
	/**
	 * 增
	 * @return
	 */
	public  int insert(WebAddress v);
	/**
	 * 删
	 * @param id
	 * @return
	 */
	public  int delete(int id);
	/**
	 * 改
	 * @param v
	 * @return
	 */
	public  int update(WebAddress v);
	
	/**
	 * 查
	 * @param user
	 * @return
	 */
	public  List<WebAddress> selectAll(String user);
}
