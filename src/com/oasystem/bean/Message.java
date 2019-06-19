package com.oasystem.bean;

public class Message {
	private int id;
	private String user;
	private String message;
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Message(String user, String message) {
		super();
		this.user = user;
		this.message = message;
	}



	public Message(int id, String user, String message) {
		super();
		this.id = id;
		this.user = user;
		this.message = message;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUser() {
		return user;
	}



	public void setUser(String user) {
		this.user = user;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	@Override
	public String toString() {
		return "Message [id=" + id + ", user=" + user + ", message=" + message + "]";
	}
	
	
}
