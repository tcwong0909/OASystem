package com.oasystem.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebFilter(urlPatterns= {"*.jsp","/loginServlet/*"})
public class LoginFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
	 
		HttpServletRequest req = (HttpServletRequest)arg0;
		HttpServletResponse resp = (HttpServletResponse)arg1;
		 
		String path = req.getPathInfo();
		if("/login".equals(path)) {
			chain.doFilter(req, resp);
		} else if(req.getSession().getAttribute("loginName")==null) {
		 req.getRequestDispatcher("/login.jsp").forward(req, resp);
			//resp.sendRedirect("/OASystem/loginServlet/login");
		} else {
			chain.doFilter(req, resp);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
