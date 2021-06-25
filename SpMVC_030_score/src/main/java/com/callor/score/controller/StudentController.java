package com.callor.score.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.model.StudentVO;
import com.callor.score.model.SubjectAndScoreDTO;
import com.callor.score.service.ScoreService;
import com.callor.score.service.StudentServcie;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@RequestMapping(value="/student")
@Controller
public class StudentController {

	protected final StudentServcie stService;
	protected final ScoreService scService;
	
	@RequestMapping(value= {"/",""},method=RequestMethod.GET)
	public String list(Model model) {
		
		List<StudentVO> stList = stService.selectAll();
		model.addAttribute("STUDENTS",stList);
		
		// String BODY = "STUDENT_LIST";
		// view.rendering(BODY)
		
		model.addAttribute("BODY","STUDENT_LIST");
		return "home";
	
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert(Model model) {
		
		StudentVO stVO = new StudentVO();
		stVO.setSt_num( stService.makeStNum() );
		
		model.addAttribute("STD",stVO);
		model.addAttribute("BODY","STUDENT_INPUT");
		return "home";
		
	}

	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(StudentVO studentVO, Model model) {
		
		log.debug("Req 학생정보 : {}", studentVO.toString());
		
		int ret = stService.insert(studentVO);
		
		model.addAttribute("BODY","STUDENT_INPUT");
		return "redirect:/student";
	}
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String detail(String st_num,Model model) {
		
		List<SubjectAndScoreDTO> ssList 
			= scService.selectScore(st_num);
	
		
		// StudentVO stVO = stService.find
		
		model.addAttribute("SSLIST",ssList);
		model.addAttribute("BODY","STUDENT_DETAIL");
		return "home";
	
	}
	
	
	
}
