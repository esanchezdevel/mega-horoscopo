package com.mega.horoscopo.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

	private static final Logger logger = LogManager.getLogger(MainController.class);
	
	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}
	
	@GetMapping("/sign/{sign}")
	public String sign(Model model, @PathVariable String sign) {
		logger.info("Request [/sign/{}", sign);
		
		return "sign";
	}
}
