package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/hello2") //어노테이션
public class Nana extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8"); //내가 캐릭터를 이걸로 보내니까
		resp.setContentType("text/html; charset=UTF-8"); //넌 이걸로 읽어라.
		
		PrintWriter out = resp.getWriter();
		
		//req 는 입력도구
		String cnt_ = req.getParameter("cnt"); //_임시변수
		
		int cnt = 100;
		if(cnt_ != null && !cnt_.equals(""))
			cnt = Integer.parseInt(cnt_);
			
		
		for (int i=0; i<cnt; i++) {
			out.println((i+1)+ ": 안녕 servlet!!<br/>");
		}
	}
}
