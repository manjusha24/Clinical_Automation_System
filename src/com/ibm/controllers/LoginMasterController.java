package com.ibm.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class LoginMasterController
 */
public class LoginMasterController implements Filter {

    public LoginMasterController() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		 PrintWriter out=response.getWriter();  
         	String role = request.getParameter("userrole");
		    String password=request.getParameter("password");  
		    if(password.equals("admin")){  
		    chain.doFilter(request, response);//sends request to next resource  
		    }  
		    else{  
		    out.print("username or password error!");  
		    RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
		    rd.include(request, response);  
		    } 
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
