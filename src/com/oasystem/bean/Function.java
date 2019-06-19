package com.oasystem.bean;

public class Function {
	private int id;
	private String name;
	
	
	public Function() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Function(String name) {
		super();
		this.name = name;
	}


	public Function(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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


	@Override
	public String toString() {
		return "Function [id=" + id + ", name=" + name + "]";
	}
	
	
}
