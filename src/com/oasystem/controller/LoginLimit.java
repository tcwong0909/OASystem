package com.oasystem.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oasystem.bean.User;
import com.oasystem.service.UserService;
import com.oasystem.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginLimit
 */
@WebServlet("/loginLimit/*")
public class LoginLimit extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		if ("/login".equals(pathInfo)) {
			this.login(request,response);
		}
	}
  
	
	private void login(HttpServletRequest request, HttpServletResponse response) {
		UserService us = new UserServiceImpl();
		//ILimitService is = new LimitServiceImpl();
		String loginName = (String) request.getSession().getAttribute("loginName");
		User user = us.login(loginName);
		//Limit limit = is.selectById(user.getId());
		
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(JSON.toJSONString(user));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 doGet(request, response);
	 
	}

}
