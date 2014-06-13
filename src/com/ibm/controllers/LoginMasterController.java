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

    /**
     * Default constructor. 
     */
    public LoginMasterController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		PrintWriter out=resp.getWriter();  
        String role = req.getParameter("userrole");
        String userid = req.getParameter("userId");
        String password = req.getParameter("Password");
        if (role.equals("Admin")){
        	if(userid.equals("MCMS")){
        		if(password.equals("administrator")){
        			RequestDispatcher rd = req.getRequestDispatcher("/AdminHomePage.jsp");
        			rd.forward(req, resp);
        		}
        	}
        } 
	    if(password.equals("admin")){  
	    chain.doFilter(req, resp);//sends request to next resource  
	    }  
	    else{  
	    out.print("username or password error!");  
	    RequestDispatcher rd=req.getRequestDispatcher("/index.html");  
	    rd.include(req, resp);  
	    }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
