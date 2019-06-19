package com.oasystem.bean;

import java.util.Date;

/**
 * 收入证明申请类
 * @author Administrator
 *
 */
public class Income {
	private Integer id;//收入证明申请id
	
	private String name;//收入人姓名
	
	private Date applyDay;//申请日期
	
	private String dept;//所属部门
	
	private String job;//岗位
	
	private String applicationReason;//申请理由
	
	private String approver;//审核人

	private Integer status;//0未审核1已审核3驳回
	public Income() {
		super();
	}
	public Income(Integer id, String name, Date applyDay, String dept, String job, String applicationReason,
			String approver, Integer status) {
		super();
		this.id = id;
		this.name = name;
		this.applyDay = applyDay;
		this.dept = dept;
		this.job = job;
		this.applicationReason = applicationReason;
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
	public Date getApplyDay() {
		return applyDay;
	}
	public void setApplyDay(Date applyDay) {
		this.applyDay = applyDay;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getApplicationReason() {
		return applicationReason;
	}
	public void setApplicationReason(String applicationReason) {
		this.applicationReason = applicationReason;
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
		return "Income [id=" + id + ", name=" + name + ", applyDay=" + applyDay + ", dept=" + dept + ", job=" + job
				+ ", applicationReason=" + applicationReason + ", approver=" + approver + ", status=" + status + "]";
	}

	
	
}
