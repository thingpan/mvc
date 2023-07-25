package common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonView {
	private static final String PREFIX ="/WEB-INF/views";
	private static final String SUFFIX =".jsp";
	private static final String MESSAGE_PATH="/WEB-INF/views/common/msg.jsp";
	public static String getCmd(HttpServletRequest req) {
		String cmd =req.getRequestURI();
		int idx=cmd.lastIndexOf("/")+1;
		return cmd.substring(idx);
	}
	public static String getPath(HttpServletRequest req) {
		return PREFIX+req.getRequestURI()+SUFFIX;
		
	}
	
	public static void forward(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path =getPath(request);
		RequestDispatcher rd =request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
	public static void getMessagePage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd =request.getRequestDispatcher(MESSAGE_PATH);
		rd.forward(request, response);
	}
}
