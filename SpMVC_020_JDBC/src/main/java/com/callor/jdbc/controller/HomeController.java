package com.callor.jdbc.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.jdbc.service.RentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	// string.properties 파일에 설정된 속성값 가져와서 변수에 setting
	@Value("${user.name}")
	protected String user_name;
	
	@Value("${user.email}")
	protected String user_email;
	
	/*
	 * 보편적인 Spring에서 bean을 사용하는 코드
	 * @Autowired
	 * privatre BooDao bookdao
	 * 이 코드에서 메모리 leak(누수)현상이 보고되어
	 * 다음의 코드를 권장한다.
	 */
	// protected final BookDao bookDao;
	protected final RentService rentService;
	public HomeController(RentService rentService) {
		this.rentService = rentService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		log.debug("Uesrn Name : {}", user_name);
		log.debug("Uesrn Email : {}", user_email);
		
		rentService.viewBookAndComp();
		return "home";
		
	}
	
}
