package com.callor.jdbc.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.jdbc.pesistance.BookDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	/*
	 * 보편적인 Spring에서 bean을 사용하는 코드
	 * @Autowired
	 * privatre BooDao bookdao
	 * 이 코드에서 메모리 leak(누수)현상이 보고되어
	 * 다음의 코드를 권장한다.
	 */
	protected final BookDao bookDao;
	public HomeController(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		bookDao.selectAll();
		return "home";
		
	}
	
}
