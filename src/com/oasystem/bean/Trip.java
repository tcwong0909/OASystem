package com.oasystem.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 出差申请
 * @author Administrator
 *
 */
public class Trip implements Serializable{
	
	private Integer id;//出差申请编号
	
	private String  name;//出差人的姓名
	
	private String dept;//所属部门
	
	private Date stardate;//开始时间
	
	private Date enddate;//结束日期
	
	private String place;//出差地址
	
	private Double loanAmount;//借款金额
	
	private String tripReason;//出差理由
	
	private String task;//工作任务
	
	private String approver;//审批人
	
	private Integer status;//0未审核1已审核3驳回

	public Trip() {
		super();
	}

	public Trip(Integer id, String name, String dept, Date stardate, Date enddate, String place, Double loanAmount,
			String tripReason, String task, String approver, Integer status) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.stardate = stardate;
		this.enddate = enddate;
		this.place = place;
		this.loanAmount = loanAmount;
		this.tripReason = tripReason;
		this.task = task;
		this.approver = approver;
		this.status = status;
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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Date getStardate() {
		return stardate;
	}

	public void setStardate(Date stardate) {
		this.stardate = stardate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getTripReason() {
		return tripReason;
	}

	public void setTripReason(String tripReason) {
		this.tripReason = tripReason;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
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
		return "Trip [id=" + id + ", name=" + name + ", dept=" + dept + ", stardate=" + stardate + ", enddate="
				+ enddate + ", place=" + place + ", loanAmount=" + loanAmount + ", tripReason=" + tripReason + ", task="
				+ task + ", approver=" + approver + ", status=" + status + "]";
	}

	
	
	
	
}
