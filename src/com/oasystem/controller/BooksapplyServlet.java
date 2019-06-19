package com.oasystem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oasystem.bean.Booksapply;
import com.oasystem.bean.OperationLog;
import com.oasystem.service.IBooksapplyService;
import com.oasystem.service.IOperationLogService;
import com.oasystem.service.impl.BooksapplyServiceImpl;
import com.oasystem.service.impl.OperationLogServiceImpl;
import com.oasystem.utils.Status;

/**
 * 书籍借阅申请控制层
 */
@WebServlet("/booksapplyServlet/*")
public class BooksapplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		if ("/add".equals(pathInfo)) {
			add(request, response);
		} else if ("/delete".equals(pathInfo)) {
			delete(request, response);
		} else if ("/update".equals(pathInfo)) {
			edit(request, response);
		} else if ("/find".equals(pathInfo)) {
			selectAll(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


	/**
	 * 增加书籍的方法
	 * 
	 * @param request
	 * @param respons
	 */
	public void add(HttpServletRequest request, HttpServletResponse respons) {
		IBooksapplyService service=new BooksapplyServiceImpl();
		try {
			Booksapply books = new Booksapply();
			books.setName(request.getParameter("name"));
			books.setBorrowDate(new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("borrowDate")));
			books.setBooksName(request.getParameter("booksName"));
			System.out.println(books);
			PrintWriter out = respons.getWriter();
			if (service.insert(books)) {
				IOperationLogService ios = new OperationLogServiceImpl();
				OperationLog log = new OperationLog((String)request.getSession().getAttribute("loginName"),"添加了一本"+request.getParameter("name")+"","",new Date());
				ios.insert(log);
				out.println(Status.SUCCESS);
			} else {
				out.println(Status.FAILURE);
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除书籍的方法
	 * 
	 * @param request
	 * @param respons
	 */
	public void delete(HttpServletRequest request, HttpServletResponse respons) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		IBooksapplyService service=new BooksapplyServiceImpl();
		try {
			PrintWriter out = respons.getWriter();
			if (service.delete(id)) {
				IOperationLogService ios = new OperationLogServiceImpl();
				OperationLog log = new OperationLog((String)request.getSession().getAttribute("loginName"),"删除了一本id为"+id +"的书","",new Date());
				ios.insert(log);
				out.print(Status.SUCCESS);
			} else {
				out.print(Status.FAILURE);
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 修改书籍信息的方法
	 * 
	 * @param request
	 * @param respons
	 */
	public void edit(HttpServletRequest request, HttpServletResponse respons) {
		IBooksapplyService service=new BooksapplyServiceImpl();
		try {
			Booksapply books = new Booksapply();
			books.setName(request.getParameter("name"));
			books.setBorrowDate(new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("borrowDate")));
			books.setBooksName(request.getParameter("booksName"));
			books.setId(Integer.parseInt(request.getParameter("id")));
			PrintWriter out = respons.getWriter();
			if (service.update(books)) {
				IOperationLogService ios = new OperationLogServiceImpl();
				OperationLog log = new OperationLog((String)request.getSession().getAttribute("loginName"),"添加了一本"+request.getParameter("name")+"","",new Date());
				ios.insert(log);
				out.println(Status.SUCCESS);
			} else {
				out.println(Status.FAILURE);
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询所有书籍信息的方法
	 * 
	 * @param request
	 * @param respons
	 */
	public void selectAll(HttpServletRequest request, HttpServletResponse respons) {
		IBooksapplyService service=new BooksapplyServiceImpl();
		try {
			PrintWriter out = respons.getWriter();
			System.out.println(11);
		
			out.print(JSON.toJSON(service.selectAll()));
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
}
