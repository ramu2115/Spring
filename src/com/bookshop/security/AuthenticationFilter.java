package com.bookshop.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;


public class AuthenticationFilter implements Filter {
	
	private static final Logger LOGGER = Logger.getLogger(AuthenticationFilter.class.getName());

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		LOGGER.debug("Enter");
		HttpServletRequest h_request = (HttpServletRequest) request;
		if(h_request.getRequestURI().endsWith("login.htm"))
		{
			chain.doFilter(request, response);
		}
		else if(isAuthenticated(h_request))
		{
			chain.doFilter(request, response);		
		}
		
		else
		{
			HttpServletResponse h_response = (HttpServletResponse) response;
			h_response.sendRedirect("login.html");
		}
		LOGGER.debug("Exit");

	                                              }
	
	public boolean isAuthenticated(HttpServletRequest h_request)
	{
		LOGGER.debug("Enter");
		boolean flag =false;
		String user = null;
		HttpSession h_session = h_request.getSession(false);
		if(null != h_session)
		{
			user = (String) h_session.getAttribute("USER_KEY");
			if(null != user)
			{
				flag = true;
			}	
		}
		LOGGER.debug("Enter");
		
		return flag;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
