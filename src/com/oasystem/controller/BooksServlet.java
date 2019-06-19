package com.oasystem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oasystem.bean.Books;
import com.oasystem.bean.OperationLog;
import com.oasystem.service.IBooksService;
import com.oasystem.service.IOperationLogService;
import com.oasystem.service.impl.BooksServiceImpl;
import com.oasystem.service.impl.OperationLogServiceImpl;
import com.oasystem.utils.Status;

/**
 * 书籍信息的控制层
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("all")
@WebServlet("/booksServlet/*")
public class BooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 增加书籍的方法
	 * 
	 * @param request
	 * @param respons
	 */
	public void add(HttpServletRequest request, HttpServletResponse respons) {
		IBooksService service = new BooksServiceImpl();
		Books books = new Books();
		books.setName(request.getParameter("name"));
		books.setRemark(request.getParameter("remark"));
		try {
			PrintWriter out = respons.getWriter();
			if (service.insert(books)) {
				IOperationLogService ios = new OperationLogServiceImpl();
				OperationLog log = new OperationLog((String)request.getSession().getAttribute("loginName"),"添加了一本"+request.getParameter("name")+"的书","",new Date());
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
		IBooksService service = new BooksServiceImpl();
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
		IBooksService service = new BooksServiceImpl();
		Books books = new Books();
		books.setName(request.getParameter("name"));
		books.setRemark(request.getParameter("remark"));
		books.setId( Integer.parseInt(request.getParameter("id")));
		try {
			PrintWriter out = respons.getWriter();
			if (service.update(books)) {
				IOperationLogService ios = new OperationLogServiceImpl();
				OperationLog log = new OperationLog((String)request.getSession().getAttribute("loginName"),"修改了一本id为"+Integer.parseInt(request.getParameter("id"))+"的书","",new Date());
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
		IBooksService service = new BooksServiceImpl();
		try {
			PrintWriter out = respons.getWriter();
			out.println(JSON.toJSON(service.selectAll()));
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

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

}
