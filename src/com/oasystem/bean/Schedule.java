package com.oasystem.bean;

import java.io.Serializable;
/**
 * 日历
 * @author TcWong
 *
 */
import java.util.Date;
public class Schedule implements Serializable {
	
	//日程id
	private Integer id;
	//操作人
	private String user;
	//记录时间
	private Date time;
	//备注
	private String remark;
	
	public Schedule() {
		super();
	}

	public Schedule(Integer id, String user, Date time, String remark) {
		super();
		this.id = id;
		this.user = user;
		this.time = time;
		this.remark = remark;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Schedule [id=" + id + ", user=" + user + ", time=" + time + ", remark=" + remark + "]";
	}
	
	

}
