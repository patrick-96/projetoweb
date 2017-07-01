package com.gmail.islaianemaia.controller;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FiltroAut
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD
		}
					, urlPatterns = { "/*" })
public class FiltroAut implements Filter {

    
    public FiltroAut() {
        
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hsr = (HttpServletRequest) request;
		
		HttpSession sessao = hsr.getSession();
		String url = hsr.getRequestURI();
		
		if(sessao.getAttribute("usuLogado") != null || url.lastIndexOf("login.html")>-1 
				|| url.lastIndexOf("autcontroler")>-1){
		chain.doFilter(request, response);
		}else{
			
			((HttpServletResponse) response) .sendRedirect("login.html");
		}
	}

	 
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
