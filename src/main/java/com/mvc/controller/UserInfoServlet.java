package com.mvc.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonView;
import repository.UserInfoRepository;

public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfoRepository uiRepo = new UserInfoRepository();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = CommonView.getCmd(request);
		if ("list".equals(uri)) {

			request.setAttribute("userInfoList", uiRepo.selectuserInfoList());
		} else if ("view".equals(uri)) {
			String uiNum = request.getParameter("uiNum");
			Map<String, String> userInfo = uiRepo.selectUserInfo(uiNum);
			request.setAttribute("userInfo", userInfo);
			}else if("update".equals(uri)) {
			String uiNum = request.getParameter("uiNum");
			Map<String,String> userInfo = uiRepo.selectUserInfo(uiNum);
			request.setAttribute("userInfo", userInfo);
	
		}
	CommonView.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = CommonView.getCmd(request);
		if ("insert".equals(uri)) {
			Map<String, String> param = new HashMap<>();
			param.put("uiId", request.getParameter("uiId"));
			param.put("uiPwd", request.getParameter("uiPwd"));
			param.put("uiName", request.getParameter("uiName"));
			param.put("uiName", request.getParameter("uiNum"));
			int result = uiRepo.insertUserInfo(param);
			request.setAttribute("msg", "회원등록에 실패했습니다");		
			if (result == 1) {
				request.setAttribute("msg", "회원 등록이 성공하였습니다");
				request.setAttribute("url", "/user-info/list");
			}
		}
		else if ("update".equals(uri)) {
			Map<String, String> param = new HashMap<>();
			param.put("uiId", request.getParameter("uiId"));
			param.put("uiPwd", request.getParameter("uiPwd"));
			param.put("uiName", request.getParameter("uiName"));
			param.put("uiNum", request.getParameter("uiNum"));
			int result = uiRepo.insertUserInfo(param);
			request.setAttribute("msg", "회원수정에 실패했습니다");	
			request.setAttribute("url", "/user-info/update?uiNum="+request.getParameter("uiNum"));
			if (result == 1) {
				request.setAttribute("msg", "회원 수정이 성공하였습니다");
				request.setAttribute("url", "/user-info/list");
			}
		}else if("delete".equals(uri)) {
			String uiNum = request.getParameter("uiNum");
			int result = uiRepo.deleteUserInfo(uiNum);
			request.setAttribute("msg", "회원삭제가 실패하였습니다.");
			request.setAttribute("url", "/user-info/view?uiNum=" + request.getParameter("uiNum"));
			if(result==1) {
				request.setAttribute("msg", "회원삭제가 성공하였습니다.");
				request.setAttribute("url", "/user-info/list");
			}
		}
		CommonView.getMessagePage(request, response);
	}

}
