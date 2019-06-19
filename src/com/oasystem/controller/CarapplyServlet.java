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
import com.oasystem.bean.Carapply;
import com.oasystem.bean.OperationLog;
import com.oasystem.service.ICarapplyService;
import com.oasystem.service.IOperationLogService;
import com.oasystem.service.impl.CarapplyServiceImpl;
import com.oasystem.service.impl.OperationLogServiceImpl;
import com.oasystem.utils.Status;

/**
 * Servlet implementation class carapplyServlet
 */
@WebServlet("/carapplyServlet/*")
public class CarapplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void addLeave(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ICarapplyService service=new CarapplyServiceImpl();
		Carapply carapply=new Carapply();
		try {
			carapply.setDriver(request.getParameter("driver"));
			carapply.setUserName(request.getParameter("userName"));
			carapply.setCompanyer(request.getParameter("companyer"));
			carapply.setDept(request.getParameter("dept"));
			System.out.println(request.getParameter("dept"));
			carapply.setStartDay(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("startDay")));
			System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("startDay")));
			carapply.setEndDay(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("endDay")));
			carapply.setDestination(request.getParameter("destination"));
			carapply.setMileage(Double.parseDouble(request.getParameter("mileage")));
			carapply.setReason(request.getParameter("reason"));
			System.out.println(carapply);
			PrintWriter out=response.getWriter();
			if (service.insert(carapply)) {
				IOperationLogService ios = new OperationLogServiceImpl();
				OperationLog log = new OperationLog((String)request.getSession().getAttribute("loginName"),"修改了一条请假申请","",new Date());
				ios.insert(log);
				out.print(Status.SUCCESS);
			}else {
				out.print(Status.FAILURE);
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void selectAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ICarapplyService service=new CarapplyServiceImpl();
		try {
			 PrintWriter out = response.getWriter();
			 out.print(JSON.toJSON(service.selectAll()));
			 out.flush();
			 out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void delete(HttpServletRequest request, HttpServletResponse response){
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		ICarapplyService service=new CarapplyServiceImpl();
 		try {
			PrintWriter out = response.getWriter();
			if (service.delete(id)==true) {
				IOperationLogService ios = new OperationLogServiceImpl();
				OperationLog log = new OperationLog((String)request.getSession().getAttribute("loginName"),"删除了一条请假申请","",new Date());
				ios.insert(log);
				out.print(Status.SUCCESS);
			}else {
				out.print(Status.FAILURE);
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 修改
	 * @param request
	 * @param response
	 */
	public void update(HttpServletRequest request, HttpServletResponse response){
		ICarapplyService service=new CarapplyServiceImpl();
		Carapply carapply=new Carapply();
		try {
			carapply.setDriver(request.getParameter("driver"));
			carapply.setUserName(request.getParameter("userName"));
			carapply.setCompanyer(request.getParameter("companyer"));
			carapply.setDept(request.getParameter("dept"));
			carapply.setStartDay(new SimpleDateFormat("YYYY-MM-dd").parse(request.getParameter("startDay")));
			carapply.setEndDay(new SimpleDateFormat("YYYY-MM-dd").parse(request.getParameter("endDay")));
			carapply.setDestination(request.getParameter("destination"));
			carapply.setMileage(Double.parseDouble(request.getParameter("mileage")));
			carapply.setReason(request.getParameter("reason"));
			carapply.setStatus(Integer.parseInt(request.getParameter("status")));
			carapply.setApprover(request.getParameter("approver"));
			PrintWriter out=response.getWriter();
			if (service.update(carapply)) {
				IOperationLogService ios = new OperationLogServiceImpl();
				OperationLog log = new OperationLog((String)request.getSession().getAttribute("loginName"),"修改了一条请假申请","",new Date());
				ios.insert(log);
				out.print(Status.SUCCESS);
			}else {
				out.print(Status.FAILURE);
			}
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
			addLeave(request, response);
		}else if ("/query".equals(pathInfo)) {
			selectAll(request, response);
		}else if ("/delete".equals(pathInfo)) {
			delete(request, response);
		}else if ("/update".equals(pathInfo)) {
			update(request, response);
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
