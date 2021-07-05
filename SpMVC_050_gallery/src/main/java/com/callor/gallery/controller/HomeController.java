package com.callor.gallery.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}

	/*
	 * MultipartHttpServletRequest
	 * 이 클래스는 @RequestParam을 붙이면 안됨
	 * 이 클래스에 @RequestParam을 붙이면 400오류가 난다.
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(
			@RequestParam("one_file") MultipartFile one_file,
			MultipartHttpServletRequest m_file) {
		
		log.debug("파일사이즈  {}", 
				m_file.getFile("m_file").getSize());
		return "home";
	
	}
}
