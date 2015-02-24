package com.newlecture.jspprj;

import java.io.IOException;

import  javax.servlet.*;
	
public class CharacterEncodingFilter implements Filter{

	private String encoding;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(final ServletRequest request,final ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//System.out.println("before �����ӵ�");
		request.setCharacterEncoding(encoding);
		chain.doFilter(request,	response);
		//System.out.println("after �����ӵ�");
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		encoding=filterConfig.getInitParameter("encoding");
	}

}
