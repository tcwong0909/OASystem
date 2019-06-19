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
import com.oasystem.bean.Role;
import com.oasystem.service.IOperationLogService;
import com.oasystem.service.IRoleService;
import com.oasystem.service.impl.OperationLogServiceImpl;
import com.oasystem.service.impl.RoleServiceImpl;
import com.oasystem.utils.Status;

@WebServlet(urlPatterns={"/roleServlet/*"})
public class RoleServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String pathInfo = req.getPathInfo();
		 if ("/query".equals(pathInfo)) {
			this.query(req,resp);
		}else  if ("/add".equals(pathInfo)) {
			this.add(req,resp);
		} if ("/delete".equals(pathInfo)) {
			this.delete(req,resp);
		} if ("/update".equals(pathInfo)) {
			this.update(req,resp);
		}
		 
	}
	
	public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Role role = new Role(req.getParameter("name"));
		IRoleService rs = new RoleServiceImpl();
			int rows = 	rs.insert(role);
			PrintWriter out = resp.getWriter();
			if (rows >0) {
				IOperationLogService ios = new OperationLogServiceImpl();
				OperationLog log = new OperationLog((String)req.getSession().getAttribute("loginName"),"添加了一个角色","",new Date());
				ios.insert(log);
				out.print(Status.SUCCESS);
			}else {
				out.print(Status.FAILURE);
			}
			out.flush();
			out.close();
	}


	public  void delete(HttpServletRequest req, HttpServletResponse resp) {
 		int id = Integer.parseInt(req.getParameter("id"));
 		System.out.println(id);
 		IRoleService rs = new RoleServiceImpl();
 		
 		int rows = 	rs.delete(id);
 	 
 		try {
			PrintWriter out = resp.getWriter();
			if (rows>1) {
				IOperationLogService ios = new OperationLogServiceImpl();
				OperationLog log = new OperationLog((String)req.getSession().getAttribute("loginName"),"删除了一个角色","",new Date());
				ios.insert(log);
				out.print(Status.SUCCESS);
			}else {
				out.print(Status.FAILURE);
			}
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void update(HttpServletRequest req, HttpServletResponse resp) {
		IRoleService rs = new RoleServiceImpl();
		Role role = new Role(Integer.parseInt(req.getParameter("id")),req.getParameter("name"));
		System.out.println(role);
		int rows= rs.update(role);
		try {
			PrintWriter out = resp.getWriter();
			if (rows>1) {
				IOperationLogService ios = new OperationLogServiceImpl();
				OperationLog log = new OperationLog((String)req.getSession().getAttribute("loginName"),"修改了一个角色","",new Date());
				ios.insert(log);
				out.print(Status.SUCCESS);
			}else {
				out.print(Status.FAILURE);
			}
		
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
	
	public void query(HttpServletRequest req, HttpServletResponse resp) {
		IRoleService irs = new RoleServiceImpl();
		IRoleService irs2 = new RoleServiceImpl();
		
		String kw = req.getParameter("kw");
		if (kw == null) {
			kw = "";
		}
		int cp =Integer.parseInt( req.getParameter("page"));
		int ls =Integer.parseInt( req.getParameter("rows"));
		
		List<Role> list = irs2.selectLimit(kw, cp, ls);
		List<Role> list2 = irs.selectAll();
		
		Map<String , Object> map = new HashMap<>();
		map.put("total", list2.size());
		map.put("rows", list);
		 PrintWriter out;
		try {
			out = resp.getWriter();
			 out.print(JSON.toJSON(map));
			 out.flush();
			 out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 doGet(req, resp);
	}
}
