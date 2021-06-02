package com.callor.hello.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.service.HomeService;

@Controller
public class HomeController {
	
	/*
	 * 전통적인 Java Code에서 HomeService 클래스를
	 * 객체로 선언하여 사용하는 방법
	 */
	// protected HomeService hService;
	// public HomeController() {
	// 	hService = new HomeService();
	// }
	
	/*
	 *  spring 버전 1
	 *  Spring Container에 보관된 객체중에서
	 *  HomeService 클래스를 이용하여 생성된 객체가 있으면
	 *  나에게 달라
	 *  
	 *  Spring Container는 자신이 보관하고 있는 객체들중에
	 *  같은 이름의 객체가 있으면 "주입"하여 사용할수 있도록
	 *  만들어준다 
	 *  
	 *  이 방식은 접속자가 많이 발생할경우
	 *  메모리 leak(누수)가 발생하여
	 *  성능이 저하는 현상이 발생할수 있다
	 *  
	 *  이 방식으로 객체를 주입받으려면
	 *  객체이름을 클래스명의 첫글자만 소문자로 하고
	 *  그대로 사용해야 한다.
	 */
	@Autowired
	HomeService homeService;

	/*
	 * spring 버전 new 
	 * 클래스를 객체로 선언할때
	 * private, protected로 접근을 제한하고
	 * final 로 또한번 제한을 한다
	 * 그리고 생성자에서 매개변수로 주입을 받아
	 * 선언된 객체를 사용할수 있도록 한다
	 * 메모리 관리 차원에서 권장하는 방식
	 */
	protected final HomeService hService;
	public HomeController(HomeService hService) {
		this.hService = hService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		System.out.println("첫번째 : " + homeService.add(200,500));
		System.out.println("두번째 : " + hService.add(30,40));
		
		model.addAttribute("LIST",hService.suffle());
		return "home";
		
	}
}
