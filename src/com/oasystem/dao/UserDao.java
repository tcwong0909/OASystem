package com.oasystem.dao;

import java.util.List;

import com.oasystem.bean.User;

public interface UserDao extends IDao<Integer,User>{
	/**
	 * 通过登录的用户名来判断数据是否存在此用户
	 * 存在就取出此条数据  
	 * @return
	 * @throws Exception
	 */
	public User login(String loginName) throws Exception;
	
	/**
	 * 修改密码
	 * @param password
	 * @param loginName
	 * @return
	 */
	public int updatePassword(String password,String loginName) throws Exception;
}
