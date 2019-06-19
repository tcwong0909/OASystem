package com.oasystem.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.oasystem.bean.User;
import com.oasystem.service.IOperationLogService;
import com.oasystem.service.impl.OperationLogServiceImpl;
import com.oasystem.utils.Status;

@WebServlet(urlPatterns={"/logServlet/*"})
public class OperationLogServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String pathInfo = req.getPathInfo();	 
		 if (pathInfo.equals("/query")) {
			this.query(req,resp);
		}else if ("/delete".equals(pathInfo)) {
			this.delete(req, resp);
		}
	}
	
	
	public void delete(HttpServletRequest req, HttpServletResponse resp) {
		IOperationLogService ios = new OperationLogServiceImpl();
		int id = Integer.parseInt(req.getParameter("id"));
		int rows = ios.delete(id);
		try {
			PrintWriter out = resp.getWriter();
			if (rows>1) {
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



	public void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		IOperationLogService ios = new OperationLogServiceImpl();
		IOperationLogService ios1 = new OperationLogServiceImpl();
		String kw = req.getParameter("kw");
		if (kw == null) {
			kw = "";
		}
		int cp =Integer.parseInt( req.getParameter("page"));
		int ls =Integer.parseInt( req.getParameter("rows"));
		 
		 List<OperationLog> list = ios.selectLimit(kw, cp, ls);
		 int list1 = ios1.selectCount();
		 Map<String , Object> map = new HashMap<>();
		map.put("total", list1);
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
