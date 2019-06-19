package com.oasystem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oasystem.bean.Meetingroom;
import com.oasystem.bean.OperationLog;
import com.oasystem.service.IMeetingroomService;
import com.oasystem.service.IOperationLogService;
import com.oasystem.service.impl.MeetingroomServiceImpl;
import com.oasystem.service.impl.OperationLogServiceImpl;
import com.oasystem.utils.Status;

/**
 * 会议室控制层
 * Servlet implementation class MeetingroomServlet
 */
@WebServlet("/meetingroomServlet/*")
public class MeetingroomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getPathInfo();
		if("/find".equals(path)){
			this.findAll(req, resp);
		}else if ("/edit".equals(path)) {
			this.editMeetingroom(req, resp);
		}else if ("/remove".equals(path)) {
			this.removeMeetingroom(req, resp);
		}else if ("/add".equals(path)) {
			this.addMeetingroom(req, resp);
		}
	}

	/**
	 * 查询所有会议室列表
	 * @param req
	 * @param resp
	 */
	public void findAll(HttpServletRequest req,HttpServletResponse resp){
		IMeetingroomService meetingroomService = new MeetingroomServiceImpl();
		try {
			PrintWriter out = resp.getWriter();
			out.print(JSON.toJSONString(meetingroomService.findAllMeetingroom()));
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 添加会议室信息
	 * @param req
	 * @param resp
	 */
	public void addMeetingroom(HttpServletRequest req,HttpServletResponse resp){
		IMeetingroomService meetingroomService = new MeetingroomServiceImpl();
		Meetingroom meetingroom = new Meetingroom();
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		meetingroom.setName(name);
		meetingroom.setDescription(description);
		try {
			PrintWriter out = resp.getWriter();
			if(meetingroomService.addMeetingroom(meetingroom)){
				IOperationLogService ios = new OperationLogServiceImpl();
				OperationLog log = new OperationLog((String)req.getSession().getAttribute("loginName"),"添加了一个会议室","",new Date());
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
	 * 删除会议室信息
	 * @param req
	 * @param resp
	 */
	public void removeMeetingroom(HttpServletRequest req,HttpServletResponse resp){
		IMeetingroomService meetingroomService = new MeetingroomServiceImpl();
		Integer id = Integer.parseInt(req.getParameter("id"));
		try {
			PrintWriter out = resp.getWriter();
			if(meetingroomService.romoveMeetingroom(id)){
				IOperationLogService ios = new OperationLogServiceImpl();
				OperationLog log = new OperationLog((String)req.getSession().getAttribute("loginName"),"删除了一个会议室","",new Date());
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
	 * 编辑会议室信息
	 * @param req
	 * @param resp
	 */
	public void editMeetingroom(HttpServletRequest req,HttpServletResponse resp){
		IMeetingroomService meetingroomService = new MeetingroomServiceImpl();
		Meetingroom meetingroom = new Meetingroom();
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		Integer id= Integer.parseInt(req.getParameter("id"));
		meetingroom.setName(name);
		meetingroom.setDescription(description);
		meetingroom.setId(id);
		try {
			PrintWriter out = resp.getWriter();
			if(meetingroomService.editMeetingroom(meetingroom)){
				IOperationLogService ios = new OperationLogServiceImpl();
				OperationLog log = new OperationLog((String)req.getSession().getAttribute("loginName"),"修改了一个会议室","",new Date());
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
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
