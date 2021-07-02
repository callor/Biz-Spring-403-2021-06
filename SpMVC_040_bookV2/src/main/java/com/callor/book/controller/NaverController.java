package com.callor.book.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.book.config.NaverQualifier;
import com.callor.book.model.BookDTO;
import com.callor.book.service.BookService;
import com.callor.book.service.impl.NaverMainService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@RequestMapping(value="/naver")
@Controller
public class NaverController {
	
	@Qualifier(NaverQualifier.NAVER_MAIN_SERVICE_V1)
	protected final NaverMainService nService;
	
	@RequestMapping(value="/{CAT}",method=RequestMethod.GET)
	public String home(
			@PathVariable(name = "CAT") String cat,
			@RequestParam(name = "search",
					required = false, 
					defaultValue = "") String search,
			Model model) throws MalformedURLException, IOException, ParseException {

		log.debug("CAT {}", cat);
		model.addAttribute("CAT",cat);
		
		nService.naverGetData(cat, search, model);
		return "home";
	
	}
}
