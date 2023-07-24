package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
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
		String path ="/WEB-INF/views/";
		if ("list".equals(uri)) {

			request.setAttribute("userInfoList", ciRepo.selectedClassInfoList());
			path += "class-info/list.jsp";
		} else if ("view".equals(uri)) {
			path += "class-info/view.jsp";
			String ciNum = request.getParameter("ciNum");
			Map<String, String> userInfo = ciRepo.selectclassInfo(ciNum);
			request.setAttribute("userInfo", userInfo);

		} else if ("insert".equals(uri)) {

			path += "class-info/insert.jsp";
		} else if ("update".equals(uri)) {
			String ciNum =request.getParameter("ciNum");
			Map<String,String>classInfo =ciRepo.selectclassInfo(ciNum);
			path += "class-info/update.jsp";
		} else if ("delete".equals(uri)) {
			path += "class-info/delete.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/") + 1;
		uri = uri.substring(idx);
		String path = "/WEB-INF/views/common/msg.jsp";
		if ("insert".equals(uri)) {
			Map<String, String> param = new HashMap<>();
			param.put("ciName", request.getParameter("ciName"));
			param.put("ciDesc", request.getParameter("ciDesc"));
			int result = ciRepo.insertClassInfo(param);
			request.setAttribute("msg", "강의등록에 실패했습니다");		
			if (result == 1) {
				request.setAttribute("msg", "강의 등록이 성공하였습니다");
				request.setAttribute("url", "/class-info1/list");
			}
		}
		else if ("update".equals(uri)) {
			Map<String, String> param = new HashMap<>();
			param.put("ciName", request.getParameter("ciName"));
			param.put("ciDesc", request.getParameter("ciDesc"));
			param.put("ciNum", request.getParameter("ciNum"));
			int result = ciRepo.insertClassInfo(param);
			request.setAttribute("msg", "강의 수정에 실패했습니다");
			request.setAttribute("url", "/class-info1/update?ciNum="+request.getParameter("ciNum"));	
			if (result == 1) {
				request.setAttribute("msg", "강의 등록이 수정 되었습니다");
				request.setAttribute("url", "/class-info1/list");
			}
		}
		else if("delete".equals(uri)) {
			String ciNum = request.getParameter("ciNum");
			int result = ciRepo.deleteClassInfo(ciNum);
			request.setAttribute("msg", "강의가 취소가 실패하였습니다.");
			request.setAttribute("url", "/class-info1/view?uiNum=" + request.getParameter("uiNum"));
			if(result==1) {
				request.setAttribute("msg", "강의가 취소가 되었습니다.");
				request.setAttribute("url", "/class-info1/list");
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
