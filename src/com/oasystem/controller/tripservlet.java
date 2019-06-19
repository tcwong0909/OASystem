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
import com.oasystem.bean.Trip;
import com.oasystem.service.IOperationLogService;
import com.oasystem.service.ITripService;
import com.oasystem.service.impl.OperationLogServiceImpl;
import com.oasystem.service.impl.TripServiceImpl;
import com.oasystem.utils.Status;

/**
 * 出差申请的控制层
 */
@WebServlet("/tripservlet/*")
public class tripservlet extends HttpServlet {

	public void addTrip(HttpServletRequest request, HttpServletResponse response) {
		ITripService service = new TripServiceImpl();
		Trip trip = new Trip();
		trip.setName(request.getParameter("name"));
		trip.setDept(request.getParameter("dept"));
		
		try {
			trip.setStardate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("stardate")));
			trip.setEnddate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("enddate")));
		
			trip.setPlace(request.getParameter("place"));
			trip.setLoanAmount(Double.parseDouble(request.getParameter("loanAmount")));
			trip.setTask(request.getParameter("task"));
			trip.setTripReason(request.getParameter("tripReason"));
			trip.setStatus(0);
		
			service.insert(trip);
			IOperationLogService ios = new OperationLogServiceImpl();
			OperationLog log = new OperationLog((String)request.getSession().getAttribute("loginName"),"添加了一条出差记录","",new Date());
			ios.insert(log);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 修改数据
	 * 
	 * @param request
	 * @param response
	 */
	public void update(HttpServletRequest request, HttpServletResponse response) {
		ITripService service = new TripServiceImpl();
		Trip trip = new Trip();
		trip.setName(request.getParameter("name"));
		trip.setDept(request.getParameter("dept"));
		try {
			//String time = request.getParameter("stardate");
			//System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("stardate")));
			trip.setStardate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("stardate")));
			//System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("stardate")));
			trip.setEnddate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("enddate")));
			trip.setPlace(request.getParameter("place"));
			trip.setLoanAmount(Double.parseDouble(request.getParameter("loanAmount")));
			trip.setTask(request.getParameter("task"));
			trip.setTripReason(request.getParameter("tripReason"));
			trip.setApprover(request.getParameter("approver"));
			trip.setId(Integer.parseInt(request.getParameter("id")));
			trip.setStatus(0);
			boolean flag = service.update(trip);
			PrintWriter out = response.getWriter();
			if (flag == true) {
				IOperationLogService ios = new OperationLogServiceImpl();
				OperationLog log = new OperationLog((String)request.getSession().getAttribute("loginName"),"修改了一条出差记录","",new Date());
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

	public void delete(HttpServletRequest request, HttpServletResponse response) {
		Integer id=Integer.parseInt(request.getParameter("id"));
		ITripService service = new TripServiceImpl();
		try {
			PrintWriter out = response.getWriter();
			if (service.delete(id)) {
				IOperationLogService ios = new OperationLogServiceImpl();
				OperationLog log = new OperationLog((String)request.getSession().getAttribute("loginName"),"删除了一条出差记录","",new Date());
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

	public void selectALL(HttpServletRequest request, HttpServletResponse response) {
		ITripService service = new TripServiceImpl();
		try {
			List<Trip> list = service.selectAll();
			//System.out.println(list);
			Map<String, Object> map = new HashMap<>();
			map.put("total", list.size());
			map.put("rows", list);
			PrintWriter out = response.getWriter();
			out.println(JSON.toJSON(map));
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
			addTrip(request, response);
		} else if ("/update".equals(pathInfo)) {
			update(request, response);
		} else if ("/delete".equals(pathInfo)) {
			delete(request, response);
		} else if ("/query".equals(pathInfo)) {
			selectALL(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
