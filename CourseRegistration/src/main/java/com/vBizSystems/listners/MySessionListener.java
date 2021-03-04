package com.vBizSystems.listners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("===HTTP Session Created======");
		String session_expirey = "none";
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("===HTTP Session Destroyed======");
	}
	
}
