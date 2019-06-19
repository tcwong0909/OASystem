package com.oasystem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oasystem.bean.Label;
import com.oasystem.bean.OperationLog;
import com.oasystem.service.ILAbelService;
import com.oasystem.service.IOperationLogService;
import com.oasystem.service.impl.LAbelServiceImpl;
import com.oasystem.service.impl.OperationLogServiceImpl;
import com.oasystem.utils.Status;

@WebServlet("/labelServlet/*")
public class LabelServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String pathInfo = req.getPathInfo();
		 if ("/query".equals(pathInfo)) {
			this.query(req,resp);
		} else if("/add".equals(pathInfo)) {
			try {
				this.add(req,resp);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if("/delete".equals(pathInfo)) {
			try {
				this.delete(req,resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ILAbelService is = new LAbelServiceImpl();
		int rows  = is.delete(Integer.parseInt(req.getParameter("id")));
		PrintWriter out = resp.getWriter();
		if (rows >0) {
			out.print(Status.SUCCESS);
		}else {
			out.print(Status.FAILURE);
		}
		out.flush();
		out.close();
	
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) throws ParseException, IOException {
		ILAbelService is = new LAbelServiceImpl();
		Label label  = new Label(req.getParameter("name"),new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("time")),req.getParameter("content"));
		int rows = is.insert(label);
		PrintWriter out = resp.getWriter();
		if (rows >0) {
			out.print(Status.SUCCESS);
		}else {
			out.print(Status.FAILURE);
		}
		out.flush();
		out.close();
	
	}

	private void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ILAbelService is = new LAbelServiceImpl();
		List<Label> list = is.selectAll();
		PrintWriter out = resp.getWriter();
		out.print(JSON.toJSON(list));
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 doGet(req, resp);
	}
}
