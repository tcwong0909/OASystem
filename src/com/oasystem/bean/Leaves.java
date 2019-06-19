package com.oasystem.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 请假类
 * 
 * @author Administrator
 *
 */
public class Leaves implements Serializable {
	private Integer id;// 请假的编号

	private String name;// 姓名

	private String dept;// 所属部门

	private Date startdate;// 开始请假的时间

	private Date enddate;// 结束时间

	private Integer leaveNumber;// 请假天数

	private Integer type;// 请假类型

	private String reason;// 请假理由

	private String approver;// 审核人

	private Integer status; //申请状态



	public Leaves() {
		super();
	}

	public Leaves(Integer id, String name, String dept, Date startdate, Date enddate, Integer leaveNumber, Integer type,
			String reason, String approver) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.startdate = startdate;
		this.enddate = enddate;
		this.leaveNumber = leaveNumber;
		this.type = type;
		this.reason = reason;
		this.approver = approver;
	}

	
	public Leaves(Integer id, String name, String dept, Date startdate, Date enddate, Integer leaveNumber, Integer type,
			String reason, String approver, Integer status) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.startdate = startdate;
		this.enddate = enddate;
		this.leaveNumber = leaveNumber;
		this.type = type;
		this.reason = reason;
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

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Integer getLeaveNumber() {
		return leaveNumber;
	}

	public void setLeaveNumber(Integer leaveNumber) {
		this.leaveNumber = leaveNumber;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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

	@Override
	public String toString() {
		return "Leaves [id=" + id + ", name=" + name + ", dept=" + dept + ", startdate=" + startdate + ", enddate="
				+ enddate + ", leaveNumber=" + leaveNumber + ", type=" + type + ", reason=" + reason + ", approver="
				+ approver + ", status=" + status + "]";
	}
 
}
