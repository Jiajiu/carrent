package com.jiu.sys.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * web的工具类
 * @author Jiu
 *
 */
public class WebUtils {
	
	public static ServletRequestAttributes getServletRequestAttributes() {
		return	(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	}
	
	/**
	 * 得到当前线程的请求对象
	 * @return
	 */
	public static HttpServletRequest getHttpServletRequest() {
		return getServletRequestAttributes().getRequest();
	}
	
	/**
	 * 得到当前线程的响应对象
	 * @return
	 */
	public static HttpServletResponse getHttpServletResponse() {
		return getServletRequestAttributes().getResponse();
	}
	
	/**
	 * 得到session对象
	 */
	public static HttpSession getHttpSession() {
		return getHttpServletRequest().getSession();
	}
	
	/**
	 * 得到ServletContext对象
	 */
	public static ServletContext getSerlvetContext() {
		return getHttpServletRequest().getServletContext();
	}
}
