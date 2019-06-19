package com.oasystem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
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
import com.oasystem.bean.Income;
import com.oasystem.bean.OperationLog;
import com.oasystem.service.IOperationLogService;
import com.oasystem.service.IncomeService;
import com.oasystem.service.impl.IncomeServiceImpl;
import com.oasystem.service.impl.OperationLogServiceImpl;
import com.oasystem.utils.Status;

import sun.security.action.PutAllAction;

/**
 * Servlet implementation class incomeSerclet
 */
@WebServlet("/incomeSerclet/*")
public class incomeSerclet extends HttpServlet {
       
	public void addIncome(HttpServletRequest request, HttpServletResponse response){
		IncomeService service=new IncomeServiceImpl();
		Income income=new Income();
		income.setName(request.getParameter("name"));
		try {
			income.setApplyDay((new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("applyDay"))));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		income.setJob(request.getParameter("job"));
		income.setDept(request.getParameter("dept"));
		income.setApplicationReason(request.getParameter("applicationReason"));
		income.setApprover(request.getParameter("approver"));
		income.setStatus(0);
		try {
			service.insert(income);
			IOperationLogService ios = new OperationLogServiceImpl();
			OperationLog log = new OperationLog((String)request.getSession().getAttribute("loginName"),"添加了一个收入记录","",new Date());
			ios.insert(log);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void update(HttpServletRequest request, HttpServletResponse response) {
		IncomeService service=new IncomeServiceImpl();
		Income income=new Income();
		try {
			income.setName(request.getParameter("name"));
			income.setApplyDay((new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("applyDay"))));
			income.setDept(request.getParameter("dept"));
			income.setJob(request.getParameter("job"));
			income.setApplicationReason(request.getParameter("applicationReason"));
			income.setApprover(request.getParameter("approver"));
			income.setId(Integer.parseInt(request.getParameter("id")));
			income.setStatus(0);
			boolean falg=service.update(income);
			PrintWriter out=response.getWriter();
			if (falg==true) {
				IOperationLogService ios = new OperationLogServiceImpl();
				OperationLog log = new OperationLog((String)request.getSession().getAttribute("loginName"),"修改了一条收入记录","",new Date());
				ios.insert(log);
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
		int id = Integer.parseInt(request.getParameter("id"));
		IncomeService service = new IncomeServiceImpl();
		try {
			PrintWriter out = response.getWriter();
			if (service.delete(id) == true) {
				IOperationLogService ios = new OperationLogServiceImpl();
				OperationLog log = new OperationLog((String)request.getSession().getAttribute("loginName"),"删除了一条收入记录","",new Date());
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
		IncomeService service = new IncomeServiceImpl();
		try {
			List<Income> list = service.selectAll();
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo=request.getPathInfo();
		if ("/add".equals(pathInfo)) {
			addIncome(request, response);
		} else if ("/update".equals(pathInfo)) {
			update(request, response);
		} else if ("/delete".equals(pathInfo)) {
			delete(request, response);
		} else if ("/query".equals(pathInfo)) {
			selectALL(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
