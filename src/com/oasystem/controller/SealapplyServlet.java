package com.oasystem.controller;

import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oasystem.bean.Sealapply;
import com.oasystem.service.ISealapplyService;
import com.oasystem.service.impl.SealapplyServiceImpl;
import com.oasystem.utils.Status;

/**
 * Servlet implementation class sealapplyServlet
 */
@WebServlet("/sealapplyServlet/*")
public class SealapplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		if ("/add".equals(pathInfo)) {
			add(request, response);
		} else if ("/delete".equals(pathInfo)) {
			delete(request, response);
		} else if ("/update".equals(pathInfo)) {
			edit(request, response);
		} else if ("/find".equals(pathInfo)) {
			selectAll(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * 印章申请
	 * @param request
	 * @param response
	 */
	public void add(HttpServletRequest request, HttpServletResponse response) {
		ISealapplyService service=new SealapplyServiceImpl();
		Sealapply sealapply=new Sealapply();
		try {
			sealapply.setApplyer(request.getParameter("applyer"));
			sealapply.setApplyDay(new SimpleDateFormat("YYYY-MM-dd").parse(request.getParameter("applyDay")));
			sealapply.setDept(request.getParameter("dept"));
			sealapply.setReason(request.getParameter("reason"));
			sealapply.setApprover(request.getParameter("approver"));
			sealapply.setSealId(Integer.parseInt(request.getParameter("sealId")));
			PrintWriter out = response.getWriter();
			if (service.insert(sealapply)) {
				out.println(Status.SUCCESS);
			}else {
				out.println(Status.FAILURE);
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) {
		Integer id=Integer.parseInt(request.getParameter("id"));
		ISealapplyService service=new SealapplyServiceImpl();
		try {
			PrintWriter out=response.getWriter();
			if (service.delete(id)) {
				out.println(Status.SUCCESS);
			} else {
				out.println(Status.FAILURE);
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void edit(HttpServletRequest request, HttpServletResponse response) {
		ISealapplyService service=new SealapplyServiceImpl();
		Sealapply sealapply=new Sealapply();
		try {
			sealapply.setApplyer(request.getParameter("applyer"));
			sealapply.setApplyDay(new SimpleDateFormat("YYYY-MM-dd").parse(request.getParameter("applyDay")));
			sealapply.setDept(request.getParameter("dept"));
			sealapply.setReason(request.getParameter("reason"));
			sealapply.setApprover(request.getParameter("approver"));
			sealapply.setStatus(Integer.parseInt(request.getParameter("status")));
			sealapply.setSealId(Integer.parseInt(request.getParameter("sealId")));
			sealapply.setId(Integer.parseInt(request.getParameter("id")));
			PrintWriter out = response.getWriter();
			if (service.update(sealapply)) {
				out.println(Status.SUCCESS);
			}else {
				out.println(Status.FAILURE);
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectAll(HttpServletRequest request, HttpServletResponse response) {
		ISealapplyService service=new SealapplyServiceImpl();
		try {
			PrintWriter out=response.getWriter();
			List<Sealapply> list = service.selectAll();
			out.print(JSON.toJSON(list));
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
