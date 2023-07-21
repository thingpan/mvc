package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.UserInfoRepository;

public class TestServlet extends HttpServlet {
	private UserInfoRepository usRepo =new UserInfoRepository(); 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/") + 1;
		uri = uri.substring(idx);
		String path = "/WEB-INF/views/";
		if ("list".equals(uri)) {
			path += "test-info/list.jsp";
		} else if ("view".equals(uri)) {
			path += "test-info/view.jsp";
		} else if ("insert".equals(uri)) {
			path += "test-info/insert.jsp";
		} else if ("update".equals(uri)) {
			path += "test-info/update.jsp";
		} else if ("delete".equals(uri)) {
			path += "test-info/delete.jsp";
		}
		path +="result/list.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
