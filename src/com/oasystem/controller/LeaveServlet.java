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
import com.oasystem.bean.Leaves;
import com.oasystem.bean.OperationLog;
import com.oasystem.service.ILeaveService;
import com.oasystem.service.IOperationLogService;
import com.oasystem.service.impl.LeaveServiceImpl;
import com.oasystem.service.impl.OperationLogServiceImpl;
import com.oasystem.utils.Status;
import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

/**
 * Servlet implementation class LeaveServlet
 */
@WebServlet("/leaveServlet/*")
public class LeaveServlet extends HttpServlet {
	
	/**
	 * 增加申请
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */

	public void addLeave(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ILeaveService service = new LeaveServiceImpl();

		Leaves leave = new Leaves();
		leave.setName(request.getParameter("name"));
		leave.setDept(request.getParameter("dept"));
		try {
			leave.setStartdate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("startdate")));
			leave.setEnddate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("enddate")));
			leave.setLeaveNumber(Integer.getInteger(request.getParameter("leaveNumber")));
			leave.setType(Integer.parseInt(request.getParameter("type")));
			leave.setReason(request.getParameter("reason"));
			service.insert(leave);
			IOperationLogService ios = new OperationLogServiceImpl();
			OperationLog log = new OperationLog((String)request.getSession().getAttribute("loginName"),"添加了一条请假申请","",new Date());
			ios.insert(log);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void selectAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ILeaveService service = new LeaveServiceImpl();
		try {
			List<Leaves> list = service.selectAll();
			//System.out.println(list);

			Map<String, Object> map = new HashMap<>();
			map.put("total", list.size());
			map.put("rows", list);
			 PrintWriter out = response.getWriter();
			out.print(JSON.toJSON(map));
			 out.flush();
			 out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void delete(HttpServletRequest request, HttpServletResponse response){
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		ILeaveService service=new LeaveServiceImpl();
		
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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update(HttpServletRequest request, HttpServletResponse response){
		ILeaveService service = new LeaveServiceImpl();

		Leaves leave = new Leaves();
		leave.setName(request.getParameter("name"));
		leave.setDept(request.getParameter("dept"));
		String id = request.getParameter("id");
		try {
			leave.setStartdate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("startdate")) );
			leave.setEnddate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("enddate")) );
			leave.setLeaveNumber(Integer.parseInt(request.getParameter("leaveNumber")));
			leave.setType(Integer.parseInt(request.getParameter("type")));
			leave.setReason(request.getParameter("reason"));
			leave.setApprover(request.getParameter("approver"));
			leave.setId(Integer.parseInt(request.getParameter("id")));
			boolean flag=service.update(leave);
			PrintWriter out=response.getWriter();
			if (flag==true) {
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
