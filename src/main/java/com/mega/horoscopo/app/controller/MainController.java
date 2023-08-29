package com.mega.horoscopo.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mega.horoscopo.app.service.interfaces.SignService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MainController {

	private static final Logger logger = LogManager.getLogger(MainController.class);
	
	@Autowired
	private SignService signService;
	
	@GetMapping("/")
	public String index(HttpServletResponse response, Model model) {
		return "index";
	}
	
	@GetMapping("/sign/{sign}")
	public String sign(Model model, @PathVariable String sign, @CookieValue(value = "sign-token", defaultValue = "") String token) {
		logger.info("Request: /sign/{}", sign);
		
		String page = signService.execute(token);
		logger.info("page: {}", page);
		return page;
	}
}
