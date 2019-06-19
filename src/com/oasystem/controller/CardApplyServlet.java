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

import com.alibaba.fastjson.JSON;
import com.oasystem.bean.CardApply;
import com.oasystem.bean.OperationLog;
import com.oasystem.service.ICardApplyService;
import com.oasystem.service.IOperationLogService;
import com.oasystem.service.impl.CardApplyServiceImpl;
import com.oasystem.service.impl.OperationLogServiceImpl;
import com.oasystem.utils.Status;

/**
 * 名片申请控制层
 */
@WebServlet("/cardApplyServlet/*")
public class CardApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 增加名片申请的方法
	 * 
	 * @param request
	 * @param respons
	 */
	public void add(HttpServletRequest request, HttpServletResponse respons) {
		ICardApplyService service=new CardApplyServiceImpl();
		try {
			CardApply card=new CardApply();
			card.setApplyDate(new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("applyDate")));
			card.setName(request.getParameter("name"));
			card.setDept(request.getParameter("dept"));
			card.setJob(request.getParameter("job"));
			card.setMb(request.getParameter("mb"));
			card.setTel(request.getParameter("tel"));
			card.setCardNumber(Integer.parseInt(request.getParameter("cardNumber")));
			card.setStatus(0);
			card.setRemark(request.getParameter("remark"));
			PrintWriter out = respons.getWriter();
			if (service.insert(card)) {
				IOperationLogService ios = new OperationLogServiceImpl();
				OperationLog log = new OperationLog((String)request.getSession().getAttribute("loginName"),"添加了一张名片","",new Date());
				ios.insert(log);
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

	/**
	 * 删除名片申请的方法
	 * 
	 * @param request
	 * @param respons
	 */
	public void delete(HttpServletRequest request, HttpServletResponse respons) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		ICardApplyService service=new CardApplyServiceImpl();
		try {
			PrintWriter out = respons.getWriter();
			if (service.delete(id)) {
				IOperationLogService ios = new OperationLogServiceImpl();
				OperationLog log = new OperationLog((String)request.getSession().getAttribute("loginName"),"删除了一张名片","",new Date());
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

	/**
	 * 修改名片申请的方法
	 * 
	 * @param request
	 * @param respons
	 */
	public void edit(HttpServletRequest request, HttpServletResponse respons) {
		ICardApplyService service=new CardApplyServiceImpl();
		try {
			CardApply card=new CardApply();
			card.setApplyDate(new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("applyDate")));
			card.setName(request.getParameter("name"));
			card.setDept(request.getParameter("dept"));
			card.setJob(request.getParameter("job"));
			card.setMb(request.getParameter("mb"));
			card.setTel(request.getParameter("tel"));
			card.setCardNumber(Integer.parseInt(request.getParameter("cardNumber")));
			card.setRemark(request.getParameter("remark"));
			card.setStatus(0);
			card.setApprover(request.getParameter("approver"));
			card.setId(Integer.parseInt(request.getParameter("id")));
			PrintWriter out = respons.getWriter();
			if (service.update(card)) {
				IOperationLogService ios = new OperationLogServiceImpl();
				OperationLog log = new OperationLog((String)request.getSession().getAttribute("loginName"),"修改了一张名片","",new Date());
				ios.insert(log);
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

	/**
	 * 查询所有名片申请信息的方法
	 * 
	 * @param request
	 * @param respons
	 */
	public void selectAll(HttpServletRequest request, HttpServletResponse respons) {
		ICardApplyService service=new CardApplyServiceImpl();
		try {
			PrintWriter out = respons.getWriter();
			//System.out.println(service.selectAll());
			out.println(JSON.toJSON(service.selectAll()));
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
		doGet(request, response);
	}
}
