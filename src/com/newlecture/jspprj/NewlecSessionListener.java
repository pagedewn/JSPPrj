package com.newlecture.jspprj;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class NewlecSessionListener implements HttpSessionListener, ServletRequestListener {
	
	public void sessionCreated(HttpSessionEvent event){
		System.out.println("���� ���� : "+event.getSession().getId());
	}
	
	public void sessionDestroyed(HttpSessionEvent event){
		System.out.println("���� ����: "+event.getSession().getId());
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent event) {
		// TODO Auto-generated method stub
		System.out.println("��û ���� Remote IP= "+ event.getServletRequest().getRemoteAddr());
	}

	@Override
	public void requestInitialized(ServletRequestEvent event) {
		// TODO Auto-generated method stub
		System.out.println("��û �ʱ�ȭ Remote IP= "+ event.getServletRequest().getRemoteAddr());
	}

	
}
