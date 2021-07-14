package com.test.web;

import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/calc3")
public class calc3 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cookie[] cookies = req.getCookies();

		String value = req.getParameter("value");
		String operator = req.getParameter("operator");
		String dot = req.getParameter("dot");
		
		String exp = "";

		if(cookies != null)
		for(Cookie c : cookies) {
			if(c.getName().equals("exp")) {
				exp = c.getValue();
				break;
			}
		}
		
		if(operator != null && operator.equals("=")) {
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
			try {
				exp = String.valueOf(engine.eval(exp));
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
		exp += (value == null) ? "" : value;
		exp += (operator == null) ? "" : operator;
		exp += (dot == null) ? "" : dot;
		}
		
		Cookie expCookie = new Cookie("exp", exp);
		resp.addCookie(expCookie);
		resp.sendRedirect("calcpage");
		
		
		// application
		// 사용범위: 전역범위에서 사용
		// 생명주기: WAS가 시작해서 종료할때까지
		// 저장위치: WAS 서버의 메모리
	
		// session
		// 사용범위: 세션 범위에서 사용하는 저장공간
		// 생명주기: 세션이 시작해서 종료할 때 까지
		// 저장위치: WAS 서버의 메모리
		
		// cookie
		// 사용범위: WebBrowser별 지정한 path 범주 공간
		// 생명주기: Browser에 전달한 시간부터 만료시간 까지
		// 저장위치: WebBrowser의 메모리 또는 파일
		
		
		
		
	}

}
