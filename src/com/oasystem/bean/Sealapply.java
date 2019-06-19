package com.oasystem.bean;

import java.io.Serializable;
import java.util.Date;
/**
 * 用章申请信息类
 * @author Administrator
 *
 */
public class Sealapply implements Serializable {
	private Integer id;//印章申请id
	
	private String applyer;//申请人姓名
	
	private Date applyDay;//申请时间
	
	private String dept;//申请部门
	
	private String reason;//申请事由
	
	private String approver;//审批人
	
	private Integer status;//审批状态
	
	private Integer sealId;//用章类型

	public Sealapply() {
		super();
	}

	public Sealapply(Integer id, String applyer, Date applyDay, String dept, String reason, String approver,
			Integer status, Integer sealId) {
		super();
		this.id = id;
		this.applyer = applyer;
		this.applyDay = applyDay;
		this.dept = dept;
		this.reason = reason;
		this.approver = approver;
		this.status = status;
		this.sealId = sealId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApplyer() {
		return applyer;
	}

	public void setApplyer(String applyer) {
		this.applyer = applyer;
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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

	public Integer getSealId() {
		return sealId;
	}

	public void setSealId(Integer sealId) {
		this.sealId = sealId;
	}

	@Override
	public String toString() {
		return "Sealapply [id=" + id + ", applyer=" + applyer + ", applyDay=" + applyDay + ", dept=" + dept
				+ ", reason=" + reason + ", approver=" + approver + ", status=" + status + ", sealId=" + sealId + "]";
	}

	
	
	
}
