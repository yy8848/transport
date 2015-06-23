package com.pjtc.transport.web;

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

import com.pjtc.transport.domain.User;
import com.pjtc.transport.web.common.Constants;

public class AuthenticationFilter implements Filter {

	private FilterConfig filterConfig = null;

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	public void destroy() {
		this.filterConfig = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession(false);

		if (session == null || 
				session.getAttribute(Constants.SESSION_ATTR_USER) == null) {
			System.out.println("The user is not authenticated yet");
			((HttpServletResponse) response).sendRedirect("/public/login.html");
		} else {
			System.out.println("The user has already been authenticated");
			chain.doFilter(request, response);
		}

	}
}
