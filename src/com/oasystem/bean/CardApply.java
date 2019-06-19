package com.oasystem.bean;

import java.io.Serializable;
import java.util.Date;
/**
 * 名片申请类
 * @author Administrator
 *
 */
public class CardApply implements Serializable {
	private Integer id; //名片申请id
	
	private Date applyDate;//名片申请时间
	
	private String name;//姓名
	
	private String dept;//部门
	
	private String job;//职位
	
	private String mb;//手机号码
	
	private String tel;//电话号码
	
	private Integer cardNumber;//申请名片的数量
	
	private String remark;//备注
	
	private Integer status;//0未审核1已审核3驳回
	
	private String approver;//审核人

	public CardApply() {
		super();
	}

	public CardApply(Integer id, Date applyDate, String name, String dept, String job, String mb, String tel,
			Integer cardNumber, String remark, Integer status, String approver) {
		super();
		this.id = id;
		this.applyDate = applyDate;
		this.name = name;
		this.dept = dept;
		this.job = job;
		this.mb = mb;
		this.tel = tel;
		this.cardNumber = cardNumber;
		this.remark = remark;
		this.status = status;
		this.approver = approver;
	}

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
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

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getMb() {
		return mb;
	}

	public void setMb(String mb) {
		this.mb = mb;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
		return "CardApply [id=" + id + ", applyDate=" + applyDate + ", name=" + name + ", dept=" + dept + ", job=" + job
				+ ", mb=" + mb + ", tel=" + tel + ", cardNumber=" + cardNumber + ", remark=" + remark + ", status="
				+ status + ", approver=" + approver + "]";
	}

	
	
}
