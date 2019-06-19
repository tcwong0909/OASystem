package com.oasystem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oasystem.bean.Schedule;
import com.oasystem.service.IScheduleService;
import com.oasystem.service.impl.ScheduleServiceImpl;
import com.oasystem.utils.Status;
 
@WebServlet("/scheduleServlet/*")
public class ScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String pathInfo = request.getPathInfo();
		 if ("/add".equals(pathInfo)) {
			this.add(request,response);
		} else if ("/find".equals(pathInfo)) {
			this.find(request, response);
		}
	}

	 /**
	  * 添加所有日志备注记录
	  * @param request
	  * @param response
	  */
	public void add(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getParameter("date"));
		String user = (String) request.getSession().getAttribute("loginName");
		String remark  = request.getParameter("remark");
		try {
			Date time = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("time"));
			IScheduleService scheduleService = new ScheduleServiceImpl();
			Schedule schedule = new Schedule();
			schedule.setUser(user);
			schedule.setTime(time);
			schedule.setRemark(remark);
			PrintWriter out = response.getWriter();
			if(scheduleService.add(schedule)){
				out.print(Status.SUCCESS);
			}else{
				out.print(Status.FAILURE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查找所有日志备注记录
	 * @param request
	 * @param response
	 */
	public void find(HttpServletRequest request, HttpServletResponse response) {
		String user = (String) request.getSession().getAttribute("loginName");
		IScheduleService scheduleService = new ScheduleServiceImpl();
		try {
			List<Schedule> list = scheduleService.findAll(user);
			PrintWriter out = response.getWriter();
			out.print(JSON.toJSONString(list));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		doGet(request, response);
	}

}
