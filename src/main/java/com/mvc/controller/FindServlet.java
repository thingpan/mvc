package com.mvc.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int rNum;
	private int c=1;
	public FindServlet() {
		Random r =new Random();
		rNum=r.nextInt(100)+1;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		int idx =uri.lastIndexOf("/");
		uri =uri.substring(idx+1);
		String path="/WEB-INF/views/";
		if("find".equals(uri)) {
			path += "find/find.jsp";
		}else if("check".equals(uri)) {
			int num =Integer.parseInt(request.getParameter("num"));
			String msg="맞췄다";
		if(num !=rNum) { 
			 c++;
			 msg="틀렸다";
		}
			path += "find/result.jsp";
			request.setAttribute("msg", msg);
			request.setAttribute("c", c);
		}
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
