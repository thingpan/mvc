package com.mvc;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
class TestServlet{
	private int rNum;
	public TestServlet() {
		Random r =new Random();
		rNum= r.nextInt();
	}
	public Map<String,String> checkNum(int num){
		Map<String,String> result =new HashMap<>();
		int cnt=0;
		cnt++;
		if(rNum==cnt) {
			result.put("msg", "맞췄다");
			result.put("cnt", cnt+"");
		}
		return result;
	}
}
public class Web {

	public static void main(String[] args) {
		Scanner r = new Scanner(System.in);
		TestServlet testServlet = null;
		int num=0;
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("text url:");
			String uri = r.nextLine();
			if ("STOP".equals(uri.trim().toUpperCase())) {
				System.out.println("시스템을 종료합니다");
				return;
			}
			int idx=uri.lastIndexOf("/")+1;
			uri=uri.substring(idx);
			if("text".equals(uri)) {
				if(testServlet==null) {
					testServlet =new TestServlet();
				}
				System.out.println("맞출번호:");
				num=r.nextInt();
			}else if("check".equals(uri)) {
				if(testServlet==null) {
					testServlet=new TestServlet();
			      
				}
				testServlet.checkNum(num);
			}else {
				System.out.println("404 page not Found");
			}
		}
	}

}
