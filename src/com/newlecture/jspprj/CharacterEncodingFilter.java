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
		//System.out.println("before « ≈Õ¿”µ’");
		request.setCharacterEncoding(encoding);
		chain.doFilter(request,	response);
		//System.out.println("after « ≈Õ¿”µ’");
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		encoding=filterConfig.getInitParameter("encoding");
	}

}
