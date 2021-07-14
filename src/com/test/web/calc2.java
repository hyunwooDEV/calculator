package com.test.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/calc2")
public class calc2 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext application = req.getServletContext();
		HttpSession session = req.getSession();
		Cookie[] cookies = req.getCookies();
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		String v_ = req.getParameter("v");
		String op = req.getParameter("operator");
		
		int v = 0;
		
		if(!v_.equals("")) {v = Integer.parseInt(v_);}
		
		// ���
		if(op.equals("=")) {
			
			//int x = (Integer)application.getAttribute("value");
			//int x = (Integer)session.getAttribute("value");
			int x = 0;
			for(Cookie c : cookies) {
				if(c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
			}
			int y = v;
			//String operator = (String)application.getAttribute("op");
			//String operator = (String)session.getAttribute("op");
			
			
			String operator = "";
			for(Cookie c : cookies) {
				if(c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}
			}
			int result = 0;
			
			if (operator.equals("+"))
				result = x+y;
			else 
				result = x-y;
			
			out.println("result:"+ result);
		}
		// ���� ����
		else {
//		application.setAttribute("value", v);
//		application.setAttribute("op", op);
			
//		session.setAttribute("value", v);
//		session.setAttribute("op", op);
			
		Cookie valueCookie = new Cookie("value", String.valueOf(v));
		Cookie opCookie = new Cookie("op", op);
		valueCookie.setPath("/calc2");
		valueCookie.setMaxAge(60*60*24);
		opCookie.setPath("/calc2");
		resp.addCookie(valueCookie);
		resp.addCookie(opCookie);
		
		resp.sendRedirect("calc2.html");
		}
		
		// application
		// ������: ������������ ���
		// �����ֱ�: WAS�� �����ؼ� �����Ҷ�����
		// ������ġ: WAS ������ �޸�
	
		// session
		// ������: ���� �������� ����ϴ� �������
		// �����ֱ�: ������ �����ؼ� ������ �� ����
		// ������ġ: WAS ������ �޸�
		
		// cookie
		// ������: WebBrowser�� ������ path ���� ����
		// �����ֱ�: Browser�� ������ �ð����� ����ð� ����
		// ������ġ: WebBrowser�� �޸� �Ǵ� ����
		
		
		
		
	}

}
