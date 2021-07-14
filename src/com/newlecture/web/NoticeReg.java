package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/notice-reg") //������̼�
public class NoticeReg extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8"); //���� ĳ���͸� �̰ɷ� �����ϱ�
		resp.setContentType("text/html; charset=UTF-8"); //�� �̰ɷ� �о��.
		//req.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		//req �� �Էµ���
		String title = req.getParameter("title"); 
		String content = req.getParameter("content"); 
		
		out.println(title);
		out.println(content);
	}
}
