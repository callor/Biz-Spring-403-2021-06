package com.callor.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.book.model.BookDTO;
import com.callor.book.service.NaverService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(value="/naver")
@Controller
public class NaverController {
	
	protected final NaverService<BookDTO> nBookService;
	
	@ResponseBody
	@RequestMapping(value="/book",method=RequestMethod.GET)
	public String book() {
		
		String queryURL =  nBookService.queryURL("자바");
		return nBookService.getJsonString(queryURL);
		
	}
	

}
