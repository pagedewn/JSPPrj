<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.io.PrintWriter"%>
<%
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		int x = 0;
		int y = 0;

		if (request.getMethod().equals("POST")) {
			String _x = request.getParameter("x");
			String _y = request.getParameter("y");
			if (_x != null && !_x.equals(""))
				x = Integer.parseInt(_x);
			if (_y != null && !_y.equals(""))
				y = Integer.parseInt(_y);

		}
		int sum = x + y;
		String _save=request.getParameter("save");
		if (_save != null) { // save버튼이 눌렸을 경우 처리
			String _sum = request.getParameter("sum");
			//_save=new String(_save.getBytes("ISO-8859-1"),"UTF-8");  //이미 있기 때문에
			System.out.println(_save);
			if(_save.equals("앱")){
				//ServletContext application = request.getServletContext();
				application.setAttribute("sum", _sum);
				System.out.println("saved in app");
			}
			else if(_save.equals("session")){
				//HttpSession session = request.getSession();
				session.setAttribute("sum", _sum);
				System.out.println("saved in session");
			}
			else if(_save.equals("cookie")){
				Cookie cookie = new Cookie("sum", _sum);
				cookie.setMaxAge(24*60*60);
				response.addCookie(cookie);
				System.out.println("saved in cookie");
			}
		}
		//PrintWriter out = response.getWriter();
%>

		<!DOCTYPE html>
		<html>
		<head>
		<meta charset="EUC-KR">
		<title>더하기!</title>
		</head>
		<body>
		<form action="add.jsp"method="post">
			<ul>
				<li><label for="x">X:</label><input name="x"/></li>
				<li><label for="y">Y:</label><input name="y"/></li>	
				<li><label for="sum">Sum:</label><input name="sum" value=<%=sum%>></li>
			</ul>
			<p><input type="submit" value="덧셈"/></p>
				<input type="submit" name="save" value="앱" />
				<input type="submit" name="save" value="session" />
			<input type="submit" name="save" value="cookie" />
		</form>
		<p><a href= "index">Home</a></p>
		</body>
		</html>