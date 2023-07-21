package com.mvc.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.UserInfoRepository;

public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfoRepository usRepo =new UserInfoRepository(); 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/") + 1;
		uri = uri.substring(idx);
		String path = "/WEB-INF/views/";
		if ("list".equals(uri)) {

			request.setAttribute("userInfoList",usRepo.selecteuserInfoList());
			path += "user-info/list.jsp";
		} else if ("view".equals(uri)) {
			path += "user-info/view.jsp";
			String uiNum=request.getParameter("uiNum");
			Map<String, String> userInfo=usRepo.selectuserInfo(uiNum);
			request.setAttribute("userInfo", userInfo);
		
		} else if ("insert".equals(uri)) {
		
			path += "user-info/insert.jsp";
		} else if ("update".equals(uri)) {
	
			path += "user-info/update.jsp";
		} else if ("delete".equals(uri)) {
			path += "user-info/delete.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
