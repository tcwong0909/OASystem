package com.oasystem.service;

import java.util.List;

import com.oasystem.bean.Label;

public interface ILAbelService {
	/**
	 * 添加标签
	 * @param l
	 * @return
	 */
	public int insert(Label l);
	
	/**
	 * 删除标签
	 * @param id
	 * @return
	 */
	 
	public int delete(int id);
	
	/**
	 * 查询全部
	 * @return
	 */
	public  List<Label> selectAll();
	
	
}
