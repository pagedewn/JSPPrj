<%@page import="com.newlecture.jssprj.dao.jdbc.JdbcNoticeDao"%>
<%@page import="com.newlecture.jspprj.dao.NoticeDao"%>
<%@page import="com.newlecture.jspprj.model.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

String code=request.getParameter("c");



NoticeDao noticeDao = new JdbcNoticeDao();
noticeDao.delete(code);

response.sendRedirect("notice.jsp");

%>