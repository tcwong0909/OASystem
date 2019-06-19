package com.oasystem.bean;

import java.io.Serializable;
/**
 * 图书信息类
 * @author Administrator
 *
 */

import com.sun.xml.internal.bind.v2.runtime.Name;

public class Books implements Serializable {
	private Integer id;// 书籍id

	private String name;// 书籍名称

	private String remark;// 备注

	public Books() {
		super();
	}

	public Books(Integer id, String name, String remark) {
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
		return "Books [id=" + id + ", name=" + name + ", remark=" + remark + "]";
	}

}
