package com.callor.book.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

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
@Slf4j
public class ApiController {
	
	@RequestMapping(value= {"/",""} ,method=RequestMethod.GET)
	public String home() {
		return "Republic of Korea";
	}
	
	/*
	 * Ajax 통해서 전송되어온 데이터 받기
	 * Ajax POST로 전송된 데이터는 Request의 body(PayLoad)에 담겨서
	 * 전달되어 온다
	 * 일반적인 JSP(form, link)에서 보낸 데이터는
	 * 매개변수를 통하여 직접 전달받을 수 있는데
	 * Ajax를 통하여 받은 데이터는 그렇지 못하다
	 * 무조건 1개의 변수에 모든 데이터가 JSON 문자열 형태로 받아진다
	 * 
	 * JSON 문자열을 JSON, 객체 형식으로 변환(parsing)해야 하는
	 * 문제에 봉착한다.
	 * 
	 * Spring에서 Ajax로 전송된 데이터는 무조건 Map으로 받는다
	 * 그리고 매개변수에 @RequestBody를 반드시 설정해 둔다
	 * 
	 * 또한
	 * pom.xml에 
	 * jackson-databind Denpendency를 반드시 설정해 둔다
	 * 
	 */
	@RequestMapping(value= {"/",""}, method=RequestMethod.POST )
	public String reqAjax(@RequestBody Map<String, String> maps) {
		
		log.debug("Maps {}", maps.toString());
		log.debug("Search {}", maps.get("search"));
		log.debug("Name {}", maps.get("st_name"));
		
		return "OK";
		
	}
	
}
