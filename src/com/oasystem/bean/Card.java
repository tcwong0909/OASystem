package com.oasystem.bean;

import java.io.Serializable;
/**
 * 名片信息类
 * @author Administrator
 *
 */
public class Card implements Serializable {
	private Integer id;//名片id
	
	private String name;//姓名
	 
	private String job;//职位
	
	private String mb;//手机号码
	
	private String tel;//电话号码

	public Card(Integer id, String name, String job, String mb, String tel) {
		super();
		this.id = id;
		this.name = name;
		this.job = job;
		this.mb = mb;
		this.tel = tel;
	}

	public Card() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getMb() {
		return mb;
	}

	public void setMb(String mb) {
		this.mb = mb;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", name=" + name + ", job=" + job + ", mb=" + mb + ", tel=" + tel + "]";
	}
	
	
}
