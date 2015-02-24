package com.newlecture.jspprj;

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

@WebServlet("/index")
public class Index extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		ServletContext application  = request.getServletContext();
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		
		String app_sum="0";
		String ses_sum="0";
		String coo_sum="0";
		if(application.getAttribute("sum")!=null){
			app_sum=application.getAttribute("sum").toString();
		}
		
		if(session.getAttribute("sum")!=null){
			ses_sum=session.getAttribute("sum").toString();
		}
		if(cookies !=null)
			for(Cookie cookie : cookies)
				if("sum".equals(cookie.getName()))
					coo_sum=cookie.getValue();
		

		
		PrintWriter out= response.getWriter();
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"EUC-KR\">");
		out.write("<title>���ϱ�!</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<p><a href= \"add\">����ϱ�</a></p>");
		out.write("<p>������ ��� �� app:"+app_sum+"</p>");
		out.write("<p>������ ��� �� session:"+ses_sum+"</p>");
		out.write("<p>������ ��� �� cookie:"+coo_sum+"</p>");
		out.write("</body>");
		out.write("</html>");
	}

	
}
