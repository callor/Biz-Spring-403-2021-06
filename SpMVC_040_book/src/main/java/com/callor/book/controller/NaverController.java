package com.callor.book.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.simple.parser.ParseException;
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
	@RequestMapping(value="/book",
				method=RequestMethod.GET)
	public List<BookDTO> book(String search) throws MalformedURLException, IOException, ParseException {
		
		String queryURL =  nBookService.queryURL(search);
		String  jsonString = nBookService.getJsonString(queryURL);
		List<BookDTO> bookList = nBookService.getNaverList(jsonString);
		return bookList;
	
	}
}
