package com.oasystem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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
import com.oasystem.bean.User;
import com.oasystem.service.IFunctionService;
import com.oasystem.service.IOperationLogService;
import com.oasystem.service.UserService;
import com.oasystem.service.impl.FunctionServiceImpl;
import com.oasystem.service.impl.OperationLogServiceImpl;
import com.oasystem.service.impl.UserServiceImpl;
import com.oasystem.utils.Status;

@WebServlet(urlPatterns={"/userServlet/*"}) 
public class UserServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		if (pathInfo.equals("/login")) {
			this.login(req, resp);
		}else if (pathInfo.equals("/query")) {
			this.selectAll(req, resp);
		}else if (pathInfo.equals("/update")) {
			this.update(req, resp);
		}else if (pathInfo.equals("/delete")) {
			this.delete(req, resp);
		}else if (pathInfo.equals("/add")) {
			this.add(req, resp);
		}
	}
	
	
	public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		User user = new User(req.getParameter("loginName"),req.getParameter("password"),req.getParameter("realName"),Integer.parseInt(req.getParameter("sex")),Integer.parseInt(req.getParameter("roleId")));
		UserService us = new UserServiceImpl();
			int rows = 	us.insert(user);
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


	public  void delete(HttpServletRequest req, HttpServletResponse resp) {
 		int id = Integer.parseInt(req.getParameter("id"));
 		IFunctionService is = new FunctionServiceImpl();
 		UserService us = new UserServiceImpl();
 		
 		int rows = 	us.delete(id);
 		//删除用户的时候也把权限表的相关数据删掉
 		is.deleteById(id);
 		try {
			PrintWriter out = resp.getWriter();
			if (rows>0) {
				IOperationLogService ios = new OperationLogServiceImpl();
				OperationLog log = new OperationLog((String)req.getSession().getAttribute("loginName"),"删除了一个用户","",new Date());
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
		UserService us = new UserServiceImpl();
		User user = new User(Integer.parseInt(req.getParameter("id")),req.getParameter("loginName"),req.getParameter("password"),req.getParameter("realName"),Integer.parseInt(req.getParameter("sex")),Integer.parseInt(req.getParameter("roleId")));
		int rows= us.update(user);
		try {
			PrintWriter out = resp.getWriter();
			if (rows>0) {
				IOperationLogService ios = new OperationLogServiceImpl();
				OperationLog log = new OperationLog((String)req.getSession().getAttribute("loginName"),"修改了一个用户","",new Date());
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


	public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		UserService us = new UserServiceImpl();
		UserService us1 = new UserServiceImpl();
		String kw = req.getParameter("kw");
		if (kw == null) {
			kw = "";
		}
		int cp =Integer.parseInt( req.getParameter("page"));
		int ls =Integer.parseInt( req.getParameter("rows"));
		 
		 List<User> list = us.selectLimit(kw, cp, ls);
		 List<User> list1 = us1.selectAll();
		 Map<String , Object> map = new HashMap<>();
		map.put("total", list1.size());
		map.put("rows", list);
		 PrintWriter out = resp.getWriter();
		 out.print(JSON.toJSON(map));
		 out.flush();
		 out.close();
	}


	//验证用户登陆的方法
	public void login(HttpServletRequest req, HttpServletResponse resp){
		 
		String loginName = req.getParameter("loginName");
		 String password = req.getParameter("password");
	 
		 UserService uDao = new UserServiceImpl();
		 try {
			 //根据登录的用户名查询数据库
			User user =  uDao.login(loginName);
			
			PrintWriter out = resp.getWriter();
			//如果用户存在也就是不为空 就进去判断密码
			if (user != null) {
				//判断密码是否正确
				if (password.equals(user.getPassword())) {
					req.getSession().setAttribute("loginName", loginName);
					req.getSession().setAttribute("password", password);
					req.getSession().setAttribute("ip", req.getLocalAddr());
					req.getSession().setAttribute("time", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
					//正确给页面返回个0
					out.print(0);
					out.flush();
					out.close();
				}else{
					//不正确给页面返回个1
					out.print(1);
					out.flush();
					out.close();
				}
			}else {
				//用户不存在就返回2
				out.print(2);
				out.flush();
				out.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 doGet(req, resp);
	}
}
