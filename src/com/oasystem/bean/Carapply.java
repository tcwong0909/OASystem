package com.oasystem.bean;

import java.io.Serializable;
/**
 * 车辆申请信息类
 * @author Administrator
 *
 */
import java.util.Date;
public class Carapply implements Serializable {
	private Integer id;//车辆申请id
	
	private String driver;//司机
	
	private String userName;//用车人
	
	private String companyer;//随行人员
	
	private String dept;//用车部门
	
	private Date startDay;//开始时间
	
	private Date endDay;//归还时间
	
	private String destination;//目的地
	
	private Double mileage;//申请里程
	
	private String reason;//用车事由
	
	private Integer status;//审核状态
	
	private String approver;//审核人

	public Carapply(Integer id, String driver, String userName, String companyer, String dept, Date startDay,
			Date endDay, String destination, Double mileage, String reason, Integer status, String approver) {
		super();
		this.id = id;
		this.driver = driver;
		this.userName = userName;
		this.companyer = companyer;
		this.dept = dept;
		this.startDay = startDay;
		this.endDay = endDay;
		this.destination = destination;
		this.mileage = mileage;
		this.reason = reason;
		this.status = status;
		this.approver = approver;
	}

	public Carapply() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCompanyer() {
		return companyer;
	}

	public void setCompanyer(String companyer) {
		this.companyer = companyer;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
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

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Double getMileage() {
		return mileage;
	}

	public void setMileage(Double mileage) {
		this.mileage = mileage;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	@Override
	public String toString() {
		return "Carapply [id=" + id + ", driver=" + driver + ", userName=" + userName + ", companyer=" + companyer
				+ ", dept=" + dept + ", startDay=" + startDay + ", endDay=" + endDay + ", destination=" + destination
				+ ", mileage=" + mileage + ", reason=" + reason + ", status=" + status + ", approver=" + approver + "]";
	}

	
	
	
}
