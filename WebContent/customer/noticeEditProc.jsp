<%@page import="com.newlecture.jssprj.dao.jdbc.JdbcNoticeDao"%>
<%@page import="com.newlecture.jspprj.dao.NoticeDao"%>
<%@page import="com.newlecture.jspprj.model.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String title=request.getParameter("title");;
String content=request.getParameter("content");
String code=request.getParameter("code");
System.out.println(code);

Notice notice= new Notice();
notice.setTitle(title);
notice.setContent(content);
notice.setCode(code);

NoticeDao noticeDao = new JdbcNoticeDao();
noticeDao.update(notice);

response.sendRedirect("noticeDetail.jsp?c="+code);

%>