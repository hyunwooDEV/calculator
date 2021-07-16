<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
response.setCharacterEncoding("UTF-8"); //내가 캐릭터를 이걸로 보내니까
response.setContentType("text/html; charset=UTF-8"); //넌 이걸로 읽어라.

//req 는 입력도구
String cnt_ = request.getParameter("cnt"); //_임시변수

int cnt = 100;
if(cnt_ != null && !cnt_.equals(""))
	cnt = Integer.parseInt(cnt_);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%for (int i=0; i<cnt; i++) { %>
			안녕 Servlet!!<br/>
		<%} %>

</body>
</html>