package com.oasystem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oasystem.bean.OperationLog;
import com.oasystem.bean.WebAddress;
import com.oasystem.service.IOperationLogService;
import com.oasystem.service.IWebAddressService;
import com.oasystem.service.impl.OperationLogServiceImpl;
import com.oasystem.service.impl.WebAddressServiceImpl;
import com.oasystem.utils.Status;

@WebServlet(urlPatterns={"/webaddressServlet/*"})
public class WebAddressServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String  pathInfo = req.getPathInfo();
		 if ("/query".equals(pathInfo)) {
			this.query(req,resp);
		}else if ("/add".equals(pathInfo)) {
			this.add(req,resp);
		}else if ("/delete".equals(pathInfo)) {
			this.delete(req,resp);
		}
	}
	
	private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		 IWebAddressService is = new WebAddressServiceImpl();
		int id =Integer.parseInt(req.getParameter("id"));
		int rows = is.delete(id);
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

	private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		 IWebAddressService is = new WebAddressServiceImpl();
		WebAddress web = new WebAddress(req.getParameter("name"),req.getParameter("webaddress"),(String)req.getSession().getAttribute("loginName"));
		int rows = is.insert(web);
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

	public void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		 IWebAddressService is = new WebAddressServiceImpl();
		 List<WebAddress> list = is.selectAll((String)req.getSession().getAttribute("loginName"));
		//System.out.println(list);
//		Map<String , Object> map = new HashMap<>();
//		map.put("list", list);
		 PrintWriter out;
		 if (list.size()>0) {
			 out = resp.getWriter();
			 out.print(JSON.toJSON(list));
			 out.flush();
			 out.close();
		} else {
			 out = resp.getWriter();
			 out.print(JSON.toJSON(0+""));
			 out.flush();
			 out.close();
		}
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		doGet(req, resp);	
	};
}
