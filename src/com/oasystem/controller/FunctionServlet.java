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
import com.oasystem.bean.Function;
import com.oasystem.bean.OperationLog;
import com.oasystem.service.IFunctionService;
import com.oasystem.service.IOperationLogService;
import com.oasystem.service.impl.FunctionServiceImpl;
import com.oasystem.service.impl.OperationLogServiceImpl;
import com.oasystem.utils.Status;


@WebServlet(urlPatterns={"/functionServlet/*"})
public class FunctionServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		if ("/query".equals(pathInfo)) {
			this.query(req,resp);
		}else if ("/update".equals(pathInfo)) {
			this.update(req,resp);
		}else if ("/add".equals(pathInfo)) {
			this.add(req,resp);
		}else if ("/delete".equals(pathInfo)) {
			this.delete(req,resp);
		}
		
		
	}
	
	private void delete(HttpServletRequest req, HttpServletResponse resp) {
		 IFunctionService is = new FunctionServiceImpl();
		 int id = Integer.parseInt(req.getParameter("id"));
		 int rows =is.deleteById(id);
		 try {
				PrintWriter out = resp.getWriter();
				if (rows>1) {
					IOperationLogService ios = new OperationLogServiceImpl();
					OperationLog log = new OperationLog((String)req.getSession().getAttribute("loginName"),"删除了一个权限","",new Date());
					ios.insert(log);
					out.print(Status.SUCCESS);
				}else {
					out.print(Status.FAILURE);
				}
			
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 		
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) {
		IFunctionService is = new FunctionServiceImpl();
		Function f = new Function(req.getParameter("name"));
		int rows = is.insert(f);
		 try {
				PrintWriter out = resp.getWriter();
				if (rows>1) {
					IOperationLogService ios = new OperationLogServiceImpl();
					OperationLog log = new OperationLog((String)req.getSession().getAttribute("loginName"),"添加了一个权限","",new Date());
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

	private void update(HttpServletRequest req, HttpServletResponse resp) {
		 IFunctionService is = new FunctionServiceImpl();
		 Function f = new Function(Integer.parseInt(req.getParameter("id")),req.getParameter("name"));
		 int rows = is.update(f);
		 try {
				PrintWriter out = resp.getWriter();
				if (rows>1) {
					IOperationLogService ios = new OperationLogServiceImpl();
					OperationLog log = new OperationLog((String)req.getSession().getAttribute("loginName"),"修改了一个权限","",new Date());
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

	private void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		 IFunctionService ls1 = new FunctionServiceImpl();
		 IFunctionService ls2 = new FunctionServiceImpl();
	
			int cp =Integer.parseInt( req.getParameter("page"));
			int ls =Integer.parseInt( req.getParameter("rows"));
		 
			List<Function>	list = ls1.selectLimit(cp, ls);
		    List<Function> list1 = ls2.selectAll();
		
		  Map<String ,Object> map = new HashMap<String ,Object>();
		   map.put("total", list1.size());
			map.put("rows", list);
			 
			 PrintWriter out = resp.getWriter();
			 out.print(JSON.toJSON(map));
			 out.flush();
			 out.close();
		}
 

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 doGet(req, resp);
	}
	
}
