package com.mega.horoscopo.app.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mega.horoscopo.domain.model.entity.Stats;
import com.mega.horoscopo.domain.service.interfaces.StatsService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WebInterceptor implements HandlerInterceptor {

	private static Logger logger = LogManager.getLogger(WebInterceptor.class);

	private static final String USER_AGENT = "USER-AGENT";
	
	@Autowired
	private StatsService statsService;

	public WebInterceptor(StatsService statsService) {
		this.statsService = statsService;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("Request received: {}", request);
		
		Stats stats = new Stats();
		stats.setUserIp(request.getRemoteAddr());
		stats.setRequestMethod(request.getMethod());
		stats.setResource(request.getRequestURI());
		stats.setUserAgent(request.getHeader(USER_AGENT));
		
		statsService.registerVisit(stats);
		
		return true;
	}
}
