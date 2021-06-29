package com.callor.book.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 * 
 * RestFull Service
 * API Service
 * Request 에 대하여 view(*.jsp, *.html)등을 보여주지 않고
 * 약속된 데이터를 Response 하는 서비스
 * 
 * 절대 view를 return하지 않는다
 * return 되는 type으로 데이터를 response 한다
 * 주로 String, JSON(List, VO, DTO)형식으로 response 한다
 * 
 */
@RestController
@RequestMapping(value="/api")
public class ApiController {
	
	@RequestMapping(value= {"/",""} ,method=RequestMethod.GET)
	public String home() {
		return "Republic of Korea";
	}
	
	@RequestMapping(value= {"/",""}, method=RequestMethod.POST )
	public String reqAjax( ) {
		
		return "OK";
	}
	
}
