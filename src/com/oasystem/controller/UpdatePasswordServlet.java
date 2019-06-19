package com.oasystem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oasystem.bean.OperationLog;
import com.oasystem.bean.User;
import com.oasystem.service.IOperationLogService;
import com.oasystem.service.UserService;
import com.oasystem.service.impl.OperationLogServiceImpl;
import com.oasystem.service.impl.UserServiceImpl;

@WebServlet(urlPatterns={"/updatePassword/*"})
public class UpdatePasswordServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		if ("/update".equals(pathInfo)) {
			this.updatePassword(req,resp);
		} 
	}
	
	
	
	public void updatePassword(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		UserService us = new UserServiceImpl();
		//ILimitService is = new LimitServiceImpl();
		String loginName = (String) req.getSession().getAttribute("loginName");
		String password1 = (String) req.getSession().getAttribute("password");
		System.out.println(password1);
		String password = req.getParameter("oldpassword");
		
		String password2 = req.getParameter("password1");
		String password3 = req.getParameter("password2");
		System.out.println(password3);
		
		PrintWriter out = resp.getWriter();
		if (password.equals(password1)) {
			if (password2.equals(password3)) {
				us.updatePassword(password2, loginName);
				IOperationLogService ios = new OperationLogServiceImpl();
				OperationLog log = new OperationLog((String)req.getSession().getAttribute("loginName"),"修改了密码","",new Date());
				ios.insert(log);
				out.print(0);
			}else{
				req.setAttribute("sys", "两次密码不相同");
				out.print(2);
			}
			
		}else{
			req.setAttribute("msg", "密码密码输入不正确");
			out.print(1);
		}
		out.flush();
		out.close();
	}



	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doGet(req, resp);
	}
}
