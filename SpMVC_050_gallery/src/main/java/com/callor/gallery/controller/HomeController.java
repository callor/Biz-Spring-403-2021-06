package com.callor.gallery.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.service.FileService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
public class HomeController {
	
	@Qualifier("fileServiceV2")
	protected final FileService fileService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}

	@RequestMapping(value="/",method=RequestMethod.POST)
	public String home(
			MultipartHttpServletRequest m_file,Model model) throws Exception {
		
//		List<MultipartFile> files = m_file.getFiles("m_file");
//		String fileName = fileService.fileUp(files.get(0));
//		model.addAttribute("file",fileName);
		
		List<String> fileNames = fileService.filesUp(m_file);
		model.addAttribute("FILES", fileNames);
		return "home";
	
	}
	
	
	/*
	 * MultipartHttpServletRequest
	 * 이 클래스는 @RequestParam을 붙이면 안됨
	 * 이 클래스에 @RequestParam을 붙이면 400오류가 난다.
	 */
	@RequestMapping(value = "/sub", method = RequestMethod.POST)
	public String home(
			@RequestParam("one_file") MultipartFile one_file,
			MultipartHttpServletRequest m_file) {
		
		log.debug("파일사이즈  {}", 
				m_file.getFile("m_file").getSize());
		
		/*
		 *  다수의 파일이 업로되면
		 *  파일들의 정보가 m_file 객체에 담기게 된다
		 *  
		 *  m_file 객체에서 getFiles() method를 사용하여
		 *  파일들 list를 추출한다
		 *  List<MulipartFile> type의 객체에 담는다
		 *  
		 *  이때 getFiles() 에는 form에서 설정된 
		 *  input tag의 name 값을 지정해준다
		 *  또한 input tag에는 multiple="multiple" 이 설정되어
		 *  있어야 한다.
		 *  
		 */
		List<MultipartFile> files = m_file.getFiles("m_file");
		for(MultipartFile file : files ) {
			log.debug("파일들 {}", file.getOriginalFilename());
		}
		return "home";
	}
}
