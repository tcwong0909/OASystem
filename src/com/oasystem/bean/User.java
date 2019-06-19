package com.oasystem.bean;

import java.util.Arrays;

public class User {
	private int id;  //用户id
	private String loginName;//登录名称
	private String password;//登录密码
	private String realName;//真实姓名
	private int sex;//0 代表男  1代表女
	private int roleId;//角色id
 
 
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public User(int id,String loginName, String password, String realName, int sex) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.password = password;
		this.realName = realName;
		this.sex = sex;
	}

	
	
	public User(String loginName, String password, String realName, int sex, int roleId) {
		super();
		this.loginName = loginName;
		this.password = password;
		this.realName = realName;
		this.sex = sex;
		this.roleId = roleId;
	}


	public User(String loginName, String password, String realName, int sex) {
		super();
		this.loginName = loginName;
		this.password = password;
		this.realName = realName;
		this.sex = sex;
	 
	}
 
	public User(int id, String loginName, String password, String realName, int sex, int roleId) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.password = password;
		this.realName = realName;
		this.sex = sex;
		this.roleId = roleId;
	}
 
 

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLoginName() {
		return loginName;
	}


	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRealName() {
		return realName;
	}


	public void setRealName(String realName) {
		this.realName = realName;
	}


	public int getSex() {
		return sex;
	}


	public void setSex(int sex) {
		this.sex = sex;
	}


	public int getRoleId() {
		return roleId;
	}


	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", loginName=" + loginName + ", password=" + password + ", realName=" + realName
				+ ", sex=" + sex + ", roleId=" + roleId + "]";
	}

 
 
 
}
