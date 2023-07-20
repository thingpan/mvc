package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.ClassInfoRepository;


public class ClassInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClassInfoRepository ciRepo=new ClassInfoRepository(); 
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		int idx =uri.lastIndexOf("/");
		uri = uri.substring(idx+1);
		List<Map<String,String>> classInfoList =ciRepo.selectedClassInfoList();
		request.setAttribute("classInfoList", classInfoList);
		String path ="/WEB-INF/views/class-info/class-info-list.jsp";
		RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
	
	
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
