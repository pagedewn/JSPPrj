package com.newlecture.jspprj;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class NewlecRequestListener implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent event) {
		// TODO Auto-generated method stub
		System.out.println("요청 종료 Remote IP= "+ event.getServletRequest().getRemoteAddr());
	}

	@Override
	public void requestInitialized(ServletRequestEvent event) {
		// TODO Auto-generated method stub
		System.out.println("요청 초기화 Remote IP= "+ event.getServletRequest().getRemoteAddr());
	}

}
