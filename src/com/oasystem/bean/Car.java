package com.oasystem.bean;

import java.io.Serializable;
/**
 * 车辆信息类
 * @author Administrator
 *
 */
public class Car implements Serializable{
	private Integer id;//车辆id
	
	private String plateNumber;//车牌号
	
	private Integer type;//车辆类型
	
	private Integer carNumber;//车辆编号
	
	private String remark;//备注

	public Car() {
		super();
	}

	public Car(Integer id, String plateNumber, Integer type, Integer carNumber, String remark) {
		super();
		this.id = id;
		this.plateNumber = plateNumber;
		this.type = type;
		this.carNumber = carNumber;
		this.remark = remark;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(Integer carNumber) {
		this.carNumber = carNumber;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", plateNumber=" + plateNumber + ", type=" + type + ", carNumber=" + carNumber
				+ ", remark=" + remark + "]";
	}
	
	
}
