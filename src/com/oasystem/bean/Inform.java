package com.oasystem.bean;

import java.io.Serializable;
/**
 * 通告信息Bean
 * @author TcWOng
 */
import java.util.Date;
public class Inform implements Serializable {

	//通告id
	private Integer id;
	//标题
	private String title;
	//通告内容
	private String content;
	//显示开始时间
	private Date startDay;
	//显示结束时间
	private Date endDay;
	//发布时间
	private Date publishDay;
	//0 紧急 1 一般
	private Integer type;
	//发布人
	private String publisher;
	
	public Inform() {
		super();
	}

	public Inform(Integer id, String title, String content, Date startDay, Date endDay, Date publishDay, Integer type,
			String publisher) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.startDay = startDay;
		this.endDay = endDay;
		this.publishDay = publishDay;
		this.type = type;
		this.publisher = publisher;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public Date getPublishDay() {
		return publishDay;
	}

	public void setPublishDay(Date publishDay) {
		this.publishDay = publishDay;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Inform [id=" + id + ", title=" + title + ", content=" + content + ", startDay=" + startDay + ", endDay="
				+ endDay + ", publishDay=" + publishDay + ", type=" + type + ", publisher=" + publisher + "]";
	}
	
	
	
}
