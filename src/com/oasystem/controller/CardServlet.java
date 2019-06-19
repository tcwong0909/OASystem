package com.oasystem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oasystem.bean.Card;
import com.oasystem.service.ICardService;
import com.oasystem.service.impl.CardServiceImpl;
import com.oasystem.utils.Status;

/**
 * Servlet implementation class cardServlet
 */
@WebServlet("/cardServlet/*")
public class CardServlet extends HttpServlet {
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

	public void add(HttpServletRequest request, HttpServletResponse response) {
			ICardService service=new CardServiceImpl();
			try {
				Card card=new Card();
				card.setName(request.getParameter("name"));
				card.setJob(request.getParameter("job"));
				card.setMb(request.getParameter("mb"));
				card.setTel(request.getParameter("tel"));
				PrintWriter out=response.getWriter();
				if (service.insert(card)) {
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

	public void delete(HttpServletRequest request, HttpServletResponse response) {
		Integer id=Integer.parseInt(request.getParameter("id"));
		ICardService service=new CardServiceImpl();
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
		ICardService service=new CardServiceImpl();
		try {
			Card card=new Card();
			card.setName(request.getParameter("name"));
			card.setJob(request.getParameter("job"));
			card.setMb(request.getParameter("mb"));
			card.setTel(request.getParameter("tel"));
			card.setId(Integer.parseInt(request.getParameter("id")));
			PrintWriter out=response.getWriter();
			if (service.update(card)) {
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

	public void selectAll(HttpServletRequest request, HttpServletResponse response) {
		ICardService service=new CardServiceImpl();
		try {
			PrintWriter out=response.getWriter();
			out.print(JSON.toJSON(service.selectAll()));
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
