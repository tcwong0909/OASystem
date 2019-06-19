package com.oasystem.bean;

import java.util.Date;

//操作日志
public class OperationLog {
	private int id; 
	private String operator; //操作者
	private String operation; //操作的事件
	private String remark;  //备注
	private Date  time;  //操作的时间
	public OperationLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public OperationLog(String operator, String operation, String remark, Date time) {
		super();
		this.operator = operator;
		this.operation = operation;
		this.remark = remark;
		this.time = time;
	}


	public OperationLog(int id, String operator, String operation, String remark, Date time) {
		super();
		this.id = id;
		this.operator = operator;
		this.operation = operation;
		this.remark = remark;
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "OperationLog [id=" + id + ", operator=" + operator + ", operation=" + operation + ", remark=" + remark
				+ ", time=" + time + "]";
	}
	
	
}
