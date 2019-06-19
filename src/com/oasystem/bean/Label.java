package com.oasystem.bean;

import java.util.Date;

public class Label {
	private int id;
	private String name;
	private Date time;
	private String content;
	
	
	
	public Label() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Label(int id, String name, Date time, String content) {
		super();
		this.id = id;
		this.name = name;
		this.time = time;
		this.content = content;
	}



	public Label(String name, Date time, String content) {
		super();
		this.name = name;
		this.time = time;
		this.content = content;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Date getTime() {
		return time;
	}



	public void setTime(Date time) {
		this.time = time;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	@Override
	public String toString() {
		return "Label [id=" + id + ", name=" + name + ", time=" + time + ", content=" + content + "]";
	}
	
	
}
