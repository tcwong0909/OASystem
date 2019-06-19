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
import com.oasystem.bean.Inform;
import com.oasystem.bean.OperationLog;
import com.oasystem.service.IInformService;
import com.oasystem.service.IOperationLogService;
import com.oasystem.service.impl.InformServiceImpl;
import com.oasystem.service.impl.OperationLogServiceImpl;
import com.oasystem.utils.Status;
/**
 * 通告信息控制层
 * Servlet implementation class InformServlet
 */
@WebServlet("/informServlet/*")
public class InformServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = req.getPathInfo();
		if("/add".equals(path)){
			this.addInform(req, resp);
		}else if ("/remove".equals(path)) {
			this.removeInform(req, resp);
		}else if ("/edit".equals(path)) {
			this.editInform(req, resp);
		}else if ("/findAll".equals(path)) {
			this.findAllInform(req, resp);
		}
		
	}
	
	/**
	 * 添加通告
	 * @param req
	 * @param resp
	 */
	public void addInform(HttpServletRequest req,HttpServletResponse resp){
		IInformService informService = new InformServiceImpl();
		Inform inform = new Inform();
		inform.setTitle(req.getParameter("title"));
		inform.setContent(req.getParameter("content"));
		try {
			inform.setStartDay(new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("startDay")));
			inform.setEndDay(new SimpleDateFormat("yyyy-MM/dd").parse(req.getParameter("endDay")));
			inform.setPublishDay(new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("publishDay")));
			inform.setType(Integer.parseInt(req.getParameter("type")));
			inform.setPublisher(req.getParameter("publisher"));
			PrintWriter out = resp.getWriter();
			if(informService.addInform(inform)){
				IOperationLogService ios = new OperationLogServiceImpl();
				OperationLog log = new OperationLog((String)req.getSession().getAttribute("loginName"),"添加了一条通告信息","",new Date());
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
	 * 删除通告信息
	 * @param req
	 * @param resp
	 */
	public void removeInform(HttpServletRequest req,HttpServletResponse resp){
		IInformService informService = new InformServiceImpl();
		Integer id = Integer.parseInt(req.getParameter("id"));
		try {
			PrintWriter out = resp.getWriter();
			if(informService.removeInform(id)){
				IOperationLogService ios = new OperationLogServiceImpl();
				OperationLog log = new OperationLog((String)req.getSession().getAttribute("loginName"),"删除了一条通告信息","",new Date());
				ios.insert(log);
				out.print(Status.SUCCESS);
			}else{
				out.print(Status.FAILURE);
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 编辑通告信息
	 * @param req
	 * @param resp
	 */
	public void editInform(HttpServletRequest req,HttpServletResponse resp){
		IInformService informService = new InformServiceImpl();
		Inform inform = new Inform();
		inform.setTitle(req.getParameter("title"));
		inform.setContent(req.getParameter("content"));
		try {
			Date time1 = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("startDay"));
			Date time2 = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("endDay"));
			inform.setStartDay(new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("startDay")));
			inform.setEndDay(new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("endDay")));
			inform.setPublishDay(new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("publishDay")));
			inform.setType(Integer.parseInt(req.getParameter("type")));
			inform.setPublisher(req.getParameter("publisher"));
			inform.setId(Integer.parseInt(req.getParameter("id")));
			PrintWriter out = resp.getWriter();
			if(informService.editInform(inform)){
				IOperationLogService ios = new OperationLogServiceImpl();
				OperationLog log = new OperationLog((String)req.getSession().getAttribute("loginName"),"编辑了一条通告信息","",new Date());
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
	 * 查询所有的通告信息
	 * @param req
	 * @param resp
	 */
	public void findAllInform(HttpServletRequest req,HttpServletResponse resp){
		IInformService informService = new InformServiceImpl();
		try {
			List<Inform> list = informService.findAllInforms();
			PrintWriter out = resp.getWriter();
			out.print(JSON.toJSONString(list));
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
