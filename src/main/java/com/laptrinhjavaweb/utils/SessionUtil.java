package com.laptrinhjavaweb.utils;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {
	
	private static SessionUtil sessionUtil = null;
	
	// New khi chýa co
	
	public static SessionUtil getInstance() {
		if(sessionUtil == null) {
			sessionUtil = new SessionUtil();
		}
		return sessionUtil ;
	}
	
	// set Value to Key
	public void putValue(HttpServletRequest rq, String key, Object value) {
		
		rq.getSession().setAttribute(key, value);
	}
	
	
	// return Object Value from key 
	public Object getValue(HttpServletRequest rq,String key) {
		
		return rq.getSession().getAttribute(key);
	}
	
	// Remove Value from key 
	public void removeValue(HttpServletRequest rq, String key) {
		
		rq.getSession().removeAttribute(key);
	}
	
	
	
	
	
	
}
