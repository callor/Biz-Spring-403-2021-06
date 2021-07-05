package com.callor.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.book.config.NaverQualifier;
import com.callor.book.model.BookDTO;
import com.callor.book.service.NaverAbstractService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
public class HomeController {
	
	@Qualifier(NaverQualifier.NAVER_BOOK_SERVICE_V2)
	protected final NaverAbstractService<BookDTO> nBookService;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home() {
		return "redirect:/naver/BOOK";
	}

	@RequestMapping(value="/not",method=RequestMethod.GET)
	public String home(
			@RequestParam(name="category",
			required = false,
			defaultValue = "") String category, Model model ) {

		// model.addAttribute("CAT",category);
		if(category.equalsIgnoreCase("BOOK")) {
			return "redirect:/book";
		} else if ( category.equalsIgnoreCase("MOVIE")) {
			return "redirect:/movie";
		} else if( category.equalsIgnoreCase("NEWS")) {
			return "redirect:/news";
		}
		return "redirect:/book";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home1(
			@RequestParam(name = "search",
					required = false,
					defaultValue = "") String search, Model model) throws Exception {
		
		if(search != null && !search.equals("")) {
			
			String queryURL = nBookService.queryURL(search.trim());
			String jsonString = nBookService.getJsonString(queryURL);
			List<BookDTO> bookList = nBookService.getNaverList(jsonString);
			model.addAttribute("BOOKS",bookList);
		}
		return "home";
	}
	
}
