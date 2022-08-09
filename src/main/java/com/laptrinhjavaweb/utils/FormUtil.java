package com.laptrinhjavaweb.utils;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class FormUtil {
	
	// Tra ve T model(T la bat ki <T> T)
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	
	public static <T> T toModel(Class<T> clazz,HttpServletRequest rq) {
		
		T object = null;
		try {
			object = clazz.newInstance();
			//clazz.getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		try {
			BeanUtils.populate(object, rq.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return null;
		}
		
		
 		return object;
		
	}
}
