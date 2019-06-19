package com.oasystem.bean;

import java.io.Serializable;

/**
 * 会议室bean类
 * @author Tcwong
 */
public class Meetingroom implements Serializable {
	//会议室id
	private Integer id;
	//会议室名称
	private String name;
	//会议室描述
	private String description;
	
	public Meetingroom() {
		super();
	}

	public Meetingroom(Integer id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "MeetingRoom [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
	
}
