package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/hello2") //������̼�
public class Nana extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8"); //���� ĳ���͸� �̰ɷ� �����ϱ�
		resp.setContentType("text/html; charset=UTF-8"); //�� �̰ɷ� �о��.
		
		PrintWriter out = resp.getWriter();
		
		//req �� �Էµ���
		String cnt_ = req.getParameter("cnt"); //_�ӽú���
		
		int cnt = 100;
		if(cnt_ != null && !cnt_.equals(""))
			cnt = Integer.parseInt(cnt_);
			
		
		for (int i=0; i<cnt; i++) {
			out.println((i+1)+ ": �ȳ� servlet!!<br/>");
		}
	}
}
