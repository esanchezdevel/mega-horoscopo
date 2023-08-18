package com.mega.horoscopo.app.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WebInterceptor implements HandlerInterceptor {

	private static Logger logger = LogManager.getLogger(WebInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("Request received: {}", request);
		
		//TODO save request data in stats table
		
		return true;
	}
}
