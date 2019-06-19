package com.oasystem.bean;

public class WebAddress {
	private int id;
	private String name;
	private String webaddress;
	private String user;
	
	public WebAddress() {
		super();
		// TODO Auto-generated constructor stub
	}


	public WebAddress(int id, String name, String webaddress) {
		super();
		this.id = id;
		this.name = name;
		this.webaddress = webaddress;
	}

	

	public WebAddress(String name, String webaddress, String user) {
		super();
		this.name = name;
		this.webaddress = webaddress;
		this.user = user;
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


	public String getWebaddress() {
		return webaddress;
	}


	public void setWebaddress(String webaddress) {
		this.webaddress = webaddress;
	}

	

	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "WebAddress [id=" + id + ", name=" + name + ", webaddress=" + webaddress + ", user=" + user + "]";
	}

	
 
}
