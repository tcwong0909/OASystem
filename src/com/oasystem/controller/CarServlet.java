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
import com.oasystem.bean.Car;
import com.oasystem.bean.OperationLog;
import com.oasystem.service.ICarService;
import com.oasystem.service.IOperationLogService;
import com.oasystem.service.impl.CarServiceImpl;
import com.oasystem.service.impl.OperationLogServiceImpl;
import com.oasystem.utils.Status;
import com.sun.java_cup.internal.runtime.virtual_parse_stack;

/**
 *车辆信息的控制层
 * @author Administrator
 *
 */
@SuppressWarnings("all")
@WebServlet("/carServlet/*")
public class CarServlet extends HttpServlet {
	/**
	 * 添加车辆信息
	 * @param request
	 * @param response
	 */
	public void addCar(HttpServletRequest request, HttpServletResponse response){
		ICarService service=new CarServiceImpl();
		Car car=new Car();
		car.setPlateNumber(request.getParameter("plateNumber"));
		car.setType(Integer.parseInt(request.getParameter("type")));
		car.setRemark(request.getParameter("remark"));
		try {
			PrintWriter out=response.getWriter();
			if (service.insert(car)) {
				IOperationLogService ios = new OperationLogServiceImpl();
				OperationLog log = new OperationLog((String)request.getSession().getAttribute("loginName"),"添加了一辆车的信息","",new Date());
				ios.insert(log);
				out.println(Status.SUCCESS);
			}else {
				out.print(Status.FAILURE);
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 删除车辆信息
	 * @param request
	 * @param response
	 */
	public void delete(HttpServletRequest request, HttpServletResponse response){
		ICarService service=new CarServiceImpl();
		Integer id=Integer.parseInt(request.getParameter("id"));
		try {
			PrintWriter out=response.getWriter();
			if (service.delete(id)) {
				IOperationLogService ios = new OperationLogServiceImpl();
				OperationLog log = new OperationLog((String)request.getSession().getAttribute("loginName"),"删除了一辆车的信息","",new Date());
				ios.insert(log);
				out.println(Status.SUCCESS);
			} else {
				out.println(Status.FAILURE);
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 *修改车辆信息
	 */
	public void updateCar(HttpServletRequest request, HttpServletResponse response){
		ICarService service=new CarServiceImpl();
		Car car=new Car();
		car.setPlateNumber(request.getParameter("plateNumber"));
		car.setType(Integer.parseInt(request.getParameter("type")));
		car.setRemark(request.getParameter("remark"));
		car.setCarNumber(Integer.parseInt(request.getParameter("carNumber")));
		car.setId(Integer.parseInt(request.getParameter("id")));
		try {
			PrintWriter out=response.getWriter();
			if (service.update(car)) {
				IOperationLogService ios = new OperationLogServiceImpl();
				OperationLog log = new OperationLog((String)request.getSession().getAttribute("loginName"),"修改了一辆车的信息","",new Date());
				ios.insert(log);
				out.println(Status.SUCCESS);
			}else {
				out.print(Status.FAILURE);
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 查询所有的车辆信息
	 */
	public void selectAll(HttpServletRequest request, HttpServletResponse response){
		System.out.println(1);
		ICarService service=new CarServiceImpl();
		try {
			PrintWriter out=response.getWriter();
			out.println(JSON.toJSON(service.selectAll()));
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo=request.getPathInfo();
		if ("/add".equals(pathInfo)) {
			addCar(request, response);
		}else if ("/delete".equals(pathInfo)) {
			delete(request, response);
		}else if ("/update".equals(pathInfo)) {
			updateCar(request, response);
		}else if ("/edit".equals(pathInfo)) {
			selectAll(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
