package com.oasystem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oasystem.bean.Message;
import com.oasystem.bean.OperationLog;
import com.oasystem.service.IMessageService;
import com.oasystem.service.IOperationLogService;
import com.oasystem.service.impl.MessageServiceImpl;
import com.oasystem.service.impl.OperationLogServiceImpl;
import com.oasystem.utils.Status;

@WebServlet(urlPatterns={"/messageServlet/*"})
public class MessageServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 String pathInfo = req.getPathInfo();
	
	 if ("/query".equals(pathInfo)) {
		this.query(req,resp);
	} if ("/add".equals(pathInfo)) {
		this.add(req,resp);
	}if ("/delete".equals(pathInfo)) {
		this.delete(req,resp);
	}
	 
	 
	 
	}
	
	private void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		 IMessageService im = new MessageServiceImpl();
		 List<Message> list = im.selectAll();
		 //System.out.println(list);
		 //Map<String , Object> map 
		 PrintWriter out = resp.getWriter();
		 out.print(JSON.toJSONString(list));
		 out.flush();
		 out.close();
		 
		
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		 IMessageService im = new MessageServiceImpl();
		Message m = new Message((String)req.getSession().getAttribute("loginName"),req.getParameter("message"));
		int rows = im.insert(m);
		PrintWriter out = resp.getWriter();
		if (rows >0) {
			IOperationLogService ios = new OperationLogServiceImpl();
			OperationLog log = new OperationLog((String)req.getSession().getAttribute("loginName"),"添加了"+req.getParameter("loginName")+"这个用户","",new Date());
			ios.insert(log);
			out.print(Status.SUCCESS);
		}else {
			out.print(Status.FAILURE);
		}
		out.flush();
		out.close();
		
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		 IMessageService im = new MessageServiceImpl();
			int id = Integer.parseInt(req.getParameter("id"));
			int rows = im.delete(id);
			PrintWriter out = resp.getWriter();
			if (rows >0) {
				IOperationLogService ios = new OperationLogServiceImpl();
				OperationLog log = new OperationLog((String)req.getSession().getAttribute("loginName"),"添加了"+req.getParameter("loginName")+"这个用户","",new Date());
				ios.insert(log);
				out.print(Status.SUCCESS);
			}else {
				out.print(Status.FAILURE);
			}
			out.flush();
			out.close(); 
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
