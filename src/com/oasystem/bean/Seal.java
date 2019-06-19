package com.oasystem.bean;

import java.io.Serializable;
/**
 * 印章信息类
 * @author Administrator
 *
 */
public class Seal implements Serializable {
	private Integer id;//印章id
	
	private String name;//印章名称
	
	private String remark;//备注

	public Seal() {
		super();
	}

	public Seal(Integer id, String name, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.remark = remark;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Seal [id=" + id + ", name=" + name + ", remark=" + remark + "]";
	}
	
	
}
