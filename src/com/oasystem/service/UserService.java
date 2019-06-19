package com.oasystem.service;

import java.util.List;

import com.oasystem.bean.User;

public interface UserService {
	/**
	 * 调用dao层的login方法    
	 * 查出登陆的用户的那一条数据
	 * @param loginName
	 * @return
	 */
	public User login(String loginName);
	
	
	/**
	 * 调用dao层的insert方法
	 * 添加一条数据
	 * @param user
	 * @return
	 */
	public int insert(User user);
	/**
	 * 调用dao层的selectAll方法   
	 * 查出所有用户
	 * @return
	 * @throws Exception
	 */
	public List<User> selectAll(); 
	
	/**
	 * 调用dao层的update方法   
	 * 修改指定的用户
	 * @param id
	 * @return
	 */
	public int  update(User user);
	
	/**
	 * 调用dao层的delete方法   
	 * 删除指定的用户
	 * @param id
	 * @return
	 */
	public int delete(int id);
	
	/**
	 * 模糊分页查询
	 * @return
	 */
	public List<User> selectLimit(String kw,Integer cp,Integer ls);
	
	/**
	 * 修改密码
	 * @param password
	 * @param loginName
	 * @return
	 */
	public int updatePassword(String password,String loginName);
	 
}
