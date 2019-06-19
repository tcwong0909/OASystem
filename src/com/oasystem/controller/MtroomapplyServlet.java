package com.oasystem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.alibaba.fastjson.JSON;
import com.oasystem.bean.Mtroomapply;
import com.oasystem.bean.OperationLog;
import com.oasystem.service.IMtroomapplyService;
import com.oasystem.service.IOperationLogService;
import com.oasystem.service.impl.MtroomapplyServiceImpl;
import com.oasystem.service.impl.OperationLogServiceImpl;
import com.oasystem.utils.Status;

/**
 * 会议室申请表controller
 * Servlet implementation class MtroomapplyServlet
 */
@WebServlet("/mtroomapplyServlet/*")
public class MtroomapplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = req.getPathInfo();
		if("/find".equals(path)){
			this.findAll(req, resp);
		}else if ("/edit".equals(path)) {
			this.edit(req, resp);
		}else if ("/remove".equals(path)) {
			this.remove(req, resp);
		}else if ("/add".equals(path)) {
			this.add(req, resp);
		}
	}


	/**
	 * 查询所有会议室申请表
	 * @param req
	 * @param resp
	 */
	public void findAll(HttpServletRequest req,HttpServletResponse resp){
		IMtroomapplyService mtroomapplyService = new MtroomapplyServiceImpl();
		try {
			PrintWriter out = resp.getWriter();
			out.print(JSON.toJSONString(mtroomapplyService.findAll()));
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 添加会议室申请表信息
	 * @param req
	 * @param resp
	 */
	public void add(HttpServletRequest req,HttpServletResponse resp){
		IMtroomapplyService mtroomapplyService = new MtroomapplyServiceImpl();
		Mtroomapply mtroomapply = new Mtroomapply();
		try {
			Date startDay = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("startdate"));
			Date endDay =new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("enddate"));
			String userName = (String) req.getSession().getAttribute("loginName");
			Integer type = Integer.parseInt(req.getParameter("type"));
			Integer mtId = Integer.parseInt(req.getParameter("roomtype"));
		
			String approver = "admin";
			mtroomapply.setStartDay(startDay);
			mtroomapply.setEndDay(endDay);
			mtroomapply.setUserName(userName);
			mtroomapply.setType(type);
			mtroomapply.setMtId(mtId);
			mtroomapply.setApprover(approver);
			mtroomapply.setStatus(0);
			System.out.println(mtroomapply);
			PrintWriter out = resp.getWriter();
			//System.out.println(mtroomapplyService.add(mtroomapply));
			if(mtroomapplyService.add(mtroomapply)){
				IOperationLogService ios = new OperationLogServiceImpl();
				OperationLog log = new OperationLog((String)req.getSession().getAttribute("loginName"),"添加了一个会议室的申请","",new Date());
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
	 * 删除会议室申请表信息
	 * @param req
	 * @param resp
	 */
	public void remove(HttpServletRequest req,HttpServletResponse resp){
		IMtroomapplyService mtroomapplyService = new MtroomapplyServiceImpl();
		Integer id = Integer.parseInt(req.getParameter("id"));
		try {
			PrintWriter out = resp.getWriter();
			if(mtroomapplyService.remove(id)){
				IOperationLogService ios = new OperationLogServiceImpl();
				OperationLog log = new OperationLog((String)req.getSession().getAttribute("loginName"),"删除了一个会议室的申请","",new Date());
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
	 * 编辑会议室申请表信息
	 * @param req
	 * @param resp
	 */
	public void edit(HttpServletRequest req,HttpServletResponse resp){
		IMtroomapplyService mtroomapplyService = new MtroomapplyServiceImpl();
		Mtroomapply mtroomapply = new Mtroomapply();
		try {
			Date startDay = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("startDay"));
			Date endDay =new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("endDay"));
			String userName = req.getParameter("userName");
			Integer type = Integer.parseInt(req.getParameter("type"));
			Integer mtId = Integer.parseInt(req.getParameter("mtId"));
			Integer id = Integer.parseInt(req.getParameter("id"));
			String approver = req.getParameter("approver");
			mtroomapply.setStartDay(startDay);
			mtroomapply.setEndDay(endDay);
			mtroomapply.setUserName(userName);
			mtroomapply.setType(type);
			mtroomapply.setMtId(mtId);
			mtroomapply.setId(id);
			mtroomapply.setApprover(approver);
			mtroomapply.setStatus(0);
			PrintWriter out = resp.getWriter();
			if(mtroomapplyService.edit(mtroomapply)){
				IOperationLogService ios = new OperationLogServiceImpl();
				OperationLog log = new OperationLog((String)req.getSession().getAttribute("loginName"),"修改了一个会议室的申请","",new Date());
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
