package com.oasystem.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 会议申请表Bean
 * @author TcWong
 *
 */
public class Mtroomapply implements Serializable {
	
	//会议室申请表Id
	private Integer id;
	//预定开始时间
	private Date startDay;
	//预定结束时间
	private Date endDay;
	//会议室预订人
	private String userName;
	//用途类型 0：周会议  1 面试 2 考试
	private Integer type;
	//会议室Id
	private Integer mtId;
	//审批人
	private String approver;
	//0未审核1已审核2驳回
	private Integer status;
	public Mtroomapply() {
		super();
	}
	
	
	
	public Mtroomapply(Date startDay, Date endDay, String userName, Integer type, Integer mtId) {
		super();
		this.startDay = startDay;
		this.endDay = endDay;
		this.userName = userName;
		this.type = type;
		this.mtId = mtId;
	}



	public Mtroomapply(Integer id, Date startDay, Date endDay, String userName, Integer type, Integer mtId,
			String approver, Integer status) {
		super();
		this.id = id;
		this.startDay = startDay;
		this.endDay = endDay;
		this.userName = userName;
		this.type = type;
		this.mtId = mtId;
		this.approver = approver;
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getStartDay() {
		return startDay;
	}
	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}
	public Date getEndDay() {
		return endDay;
	}
	public void setEndDay(Date endDay) {
		this.endDay = endDay;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getMtId() {
		return mtId;
	}
	public void setMtId(Integer mtId) {
		this.mtId = mtId;
	}
	public String getApprover() {
		return approver;
	}
	public void setApprover(String approver) {
		this.approver = approver;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Mtroomapply [id=" + id + ", startDay=" + startDay + ", endDay=" + endDay + ", userName=" + userName
				+ ", type=" + type + ", mtId=" + mtId + ", approver=" + approver + ", status=" + status + "]";
	}

	
	
}
