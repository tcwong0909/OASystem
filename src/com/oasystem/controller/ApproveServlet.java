package com.oasystem.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.oasystem.bean.Mtroomapply;
import com.oasystem.bean.OperationLog;
import com.oasystem.service.IApproveService;
import com.oasystem.service.ILeaveService;
import com.oasystem.service.IMtroomapplyService;
import com.oasystem.service.IOperationLogService;
import com.oasystem.service.impl.AppleServiceImpl;
import com.oasystem.service.impl.ApproveServiceImpl;
import com.oasystem.service.impl.LeaveServiceImpl;
import com.oasystem.service.impl.MtroomapplyServiceImpl;
import com.oasystem.service.impl.OperationLogServiceImpl;
import com.oasystem.utils.Status;

/**
 * 审批流程控制层
 * Servlet implementation class ApproveServlet
 */
@WebServlet("/approveServlet/*")
public class ApproveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getPathInfo();
		if("/find".equals(path)){
			this.findAll(req, resp);
		}else if ("/agree".equals(path)) {
			this.agree(req, resp);
		}else if ("/reject".equals(path)) {
			this.reject(req, resp);
		}
	}

		private void agree(HttpServletRequest req, HttpServletResponse resp) throws IOException {
				IMtroomapplyService imtr = new MtroomapplyServiceImpl();
				
				 ILeaveService ilea = new LeaveServiceImpl();
				//接收请求的是哪种申请
				
				String type =req.getParameter("type");
				//会议室的申请处理
				if ("mtr".equals(type)) {
					int status =Integer.parseInt(req.getParameter("status"));
					int id = Integer.parseInt(req.getParameter("id"));
					int rows = imtr.updateStatus(status, id);
					PrintWriter out = resp.getWriter();
					if (rows >0) {		 
						out.print(Status.SUCCESS);
					}else {
						out.print(Status.FAILURE);
					}
					out.flush();
					out.close();
					//请假的处理
				}else if ("lea".equals(type)) {
					int status =Integer.parseInt(req.getParameter("status"));
					int id = Integer.parseInt(req.getParameter("id"));
					boolean rows = ilea.updateStatus(status, id);
					PrintWriter out = resp.getWriter();
					if (rows) {
						out.print(Status.SUCCESS);
					}else {
						out.print(Status.FAILURE);
					}
					out.flush();
					out.close();
				} else {

				}
	}

		private void reject(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			IMtroomapplyService imtr = new MtroomapplyServiceImpl();
			
			 ILeaveService ilea = new LeaveServiceImpl();
			//接收请求的是哪种申请
			
			String type =req.getParameter("type");
			//会议室的申请处理
			if ("mtr".equals(type)) {
				int status =Integer.parseInt(req.getParameter("status"));
				int id = Integer.parseInt(req.getParameter("id"));
				int rows = imtr.updateStatus(status, id);
				PrintWriter out = resp.getWriter();
				if (rows >0) {		 
					out.print(Status.SUCCESS);
				}else {
					out.print(Status.FAILURE);
				}
				out.flush();
				out.close();
				//请假的处理
			}else if ("lea".equals(type)) {
				int status =Integer.parseInt(req.getParameter("status"));
				int id = Integer.parseInt(req.getParameter("id"));
				boolean rows = ilea.updateStatus(status, id);
				PrintWriter out = resp.getWriter();
				if (rows) {
					out.print(Status.SUCCESS);
				}else {
					out.print(Status.FAILURE);
				}
				out.flush();
				out.close();
			} else {

			}
		
	}

		/**
		 * 查询所有的待审批文件
		 * @param req
		 * @param resp
		 */
		public void findAll(HttpServletRequest req,HttpServletResponse resp){
			IApproveService approveService = new ApproveServiceImpl();
			Map<String, Object> map = new HashMap<>();
			String name = (String) req.getSession().getAttribute("loginName");
			
			try {
				map=approveService.findAll(name);
				//System.out.println(map);
				PrintWriter out = resp.getWriter();
				out.print(JSON.toJSONString(map));
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
