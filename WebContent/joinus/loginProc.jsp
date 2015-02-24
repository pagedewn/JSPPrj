<%@page import="com.newlecture.jspprj.model.Member"%>
<%@page import="com.newlecture.jssprj.dao.jdbc.JdbcMemberDao"%>
<%@page import="com.newlecture.jspprj.dao.MemberDao"%>
<%@page import="com.newlecture.jssprj.dao.jdbc.JdbcNoticeDao"%>
<%@page import="com.newlecture.jspprj.dao.NoticeDao"%>
<%@page import="com.newlecture.jspprj.model.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String uid = request.getParameter("uid");
	String pwd = request.getParameter("pwd");

	Member m = new JdbcMemberDao().getMember(uid);

	String msg = "";
	if (m == null)
		msg = "id가 틀렸습니다.";
	else if (!m.getPwd().equals(pwd))
		msg = "비밀번호가 틀렸습니다.";
	else {
		session.setAttribute("uid", uid);
	}

	/* response.sendRedirect("../customer/notice.jsp"); */
	if(!msg.equals("")){
	request.setAttribute("msg", msg);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
	dispatcher.forward(request, response);
	}
	
	response.sendRedirect("../index.jsp");
	
%>