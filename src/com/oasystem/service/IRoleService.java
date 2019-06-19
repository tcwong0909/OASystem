package com.oasystem.service;

import java.util.List;

import com.oasystem.bean.Role;

public interface IRoleService {
	
	/**
	 * 查询所有角色
	 * @return
	 */
	public List<Role> selectAll(); 
	
	/**
	 * 删除一条数据
	 * @param id
	 * @return
	 */
	public int delete(int id);
	
	/**
	 * 添加一条数据
	 * @param role
	 * @return
	 */
	int insert(Role role);
	
	/**
	 * 修改一条数据
	 * @param role
	 * @return
	 */
	int update(Role role);
	
	/**
	 * 模糊分页查询
	 * @param kw
	 * @param cp
	 * @param ls
	 * @return
	 */
	List<Role> selectLimit(String kw,int cp,int ls);
}
