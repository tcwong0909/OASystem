package com.oasystem.bean;

import java.io.Serializable;
import java.util.Date;
/**
 * 书籍借阅申请类
 * @author Administrator
 *
 */
public class Booksapply implements Serializable {
	private Integer id;//书籍借阅申请id
	
	private String name;//姓名
	
	private Date borrowDate;//借阅日期
	
	private String booksName;//书籍名称
	
	private String approver;//审核人

	public Booksapply() {
		super();
	}

	public Booksapply(Integer id, String name, Date borrowDate, String booksName, String approver) {
		super();
		this.id = id;
		this.name = name;
		this.borrowDate = borrowDate;
		this.booksName = booksName;
		this.approver = approver;
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

	public Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public String getBooksName() {
		return booksName;
	}

	public void setBooksName(String booksName) {
		this.booksName = booksName;
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	@Override
	public String toString() {
		return "Booksapply [id=" + id + ", name=" + name + ", borrowDate=" + borrowDate + ", booksName=" + booksName
				+ ", approver=" + approver + "]";
	}

	
}
