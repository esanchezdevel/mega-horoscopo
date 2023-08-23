package com.mega.horoscopo.app.controller;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Base64;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mega.horoscopo.app.dto.PaypalAccessTokenResponseDTO;
import com.mega.horoscopo.app.service.interfaces.SignService;
import com.mega.horoscopo.infrastructure.configuration.PaypalConfiguration;
import com.mega.horoscopo.infrastructure.http.PaypalClient;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MainController {

	private static final Logger logger = LogManager.getLogger(MainController.class);
	
	private static final String PAGE_PAYMENT = "payment";
	
	@Autowired
	private SignService signService;
	
	@Autowired
	private PaypalClient paypalClient;
	
	@Autowired
	private PaypalConfiguration paypalConfiguration;
	
	@GetMapping("/")
	public String index(HttpServletResponse response, Model model) {
		
		//TODO remove after test. create a cookie
		Cookie cookie = new Cookie("sign-token", "test-token");
		cookie.setMaxAge(7 * 24 * 60 * 60); // expires in 7 days
		cookie.setHttpOnly(true);

		//TODO remove after test. add cookie to response
		response.addCookie(cookie);
		
		//TODO request for test purpose. move to right place when is done
		String auth = paypalConfiguration.getClientId() + ":" + paypalConfiguration.getClientSecret();

		byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
		String credentials = "Basic " + new String(encodedAuth);
		
		PaypalAccessTokenResponseDTO accessToken = paypalClient.getAccessToken(credentials, "grant_type=client_credentials");
		
		logger.info("Paypal Access Token received: {}", accessToken);
		
		return "index";
	}
	
	@GetMapping("/sign/{sign}")
	public String sign(Model model, @PathVariable String sign, @CookieValue(value = "sign-token", defaultValue = "") String token) {
		logger.info("Request: /sign/{}", sign);
		
		String page = signService.execute(token);
		logger.info("page: {}", page);
		if (page.equals(PAGE_PAYMENT)) {
			//TODO redirect to payment page
			return page;
		} else {
			return page;
		}
	}
}
