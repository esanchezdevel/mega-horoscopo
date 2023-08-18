package com.mega.horoscopo.app.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mega.horoscopo.domain.service.interfaces.StatsService;

@Configuration
public class InterceptorsConfiguration implements WebMvcConfigurer {

	@Autowired
	private StatsService statsService;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new WebInterceptor(statsService))
			.excludePathPatterns("/img/**", "/css/**", "/favicon.ico", "/error")
			.addPathPatterns("/**");
	}
}