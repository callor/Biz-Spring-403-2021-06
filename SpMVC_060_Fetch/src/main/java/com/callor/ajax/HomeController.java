package com.callor.ajax;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.ajax.model.UserDTO;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/json", method = RequestMethod.GET)
	public String json(Model model) {
		return "json";
	}
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form(Model model) {
		return "form";
	}
	
	/*
	 * Web client와 JSON 데이터 교환하기
	 * Web JSON 데이터를 보내면
	 * Controller에서는 
	 * 		@RequestBody 속성을 사용하여 데이터를 받고
	 * 
	 * Web에 다시 JSON 데이터를 return하기 위해선
	 * 		@ResponseBody 속성을 사용하여 데이터를 return한다 
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/json", method = RequestMethod.POST)
	public String json(@RequestBody  String user_id, Model model) {
		return user_id;
	}

	/*
	 * Controller 에서 web 에서 보낸 데이터가 2가지 이상의 변수에 해당하면
	 * 무조건 VO, DTO를 만들어서 받아라
	 * 
	 * @RequestBody는 Jackson Bind에 의해서 
	 * Web에서 전달된 JSON 데이터를 DTO 클래스에 binding한다.
	 * 
	 * Spring 4.x에서는 Jackson bind가 기본으로 포함이 되었었다
	 * Spring 5.x에서는 Jackson bind가 분리되어서
	 * pom.xml에서 jackson-bind를 포함시켜줘야 한다.
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/json/dto", method = RequestMethod.POST)
	public UserDTO json(@RequestBody  UserDTO userDTO, Model model) {
		System.out.print("Web에서 받은 데이터 : ");
		System.out.println(userDTO.toString());
		return userDTO;
	}
	
	@ResponseBody
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public UserDTO form(@RequestBody UserDTO userDTO, Model model) {
		return userDTO;
	}
	
}
