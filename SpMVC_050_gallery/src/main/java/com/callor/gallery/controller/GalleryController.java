package com.callor.gallery.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.model.GalleryDTO;
import com.callor.gallery.model.GalleryFilesDTO;
import com.callor.gallery.model.MemberVO;
import com.callor.gallery.service.GalleryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping(value="/gallery")
public class GalleryController {
	
	@Qualifier("galleryServiceV2")
	protected final GalleryService gaService;
	
	/*
	 * 주소창에 직접 입력후 Enter 로 요청할 때 Request를 처리
	 * 		http://localhost:8080/rootPath/gallery/dumy
	 * 
	 * a tag 를 클릭했을때
	 * 		<a href="${rootPath}/gallery/dumy>열기</a> 
	 * 
	 * JS
	 * 		location.href="${rootPath}/gallery/dumy" 가 실행됬을때
	 */
	@RequestMapping(value="/dumy",method=RequestMethod.GET)
	public String dumy() {
		return "home";
	}

	/*
	 * <form action="${rootPath}/dumy" method="POST">
	 * 		<input name="str">
	 * 		<button type="submit">전송</button>
	 * </form>
	 */
	@RequestMapping(value="/dumy",method=RequestMethod.POST)
	public String dumy(String str) {
		return "home";
	}
	
	// localhost:8080/rootPath/gallery/ 또는
	// localhost:8080/rootPath/gallery 로 요청했을 때
	@RequestMapping(value={"/", ""},method=RequestMethod.GET)
	public String list(
		@RequestParam (value = "pageNum", 
				required = false, 
				defaultValue = "1") String pageNum,
		@RequestParam(value="search_column", required = false, defaultValue = "NONE")
				String search_column,
		@RequestParam(value="search_text", required = false, defaultValue = "NONE")
				String search_text,
		Model model) throws Exception {
		
		int intPageNum = Integer.valueOf(pageNum);
		if(intPageNum > 0) {
			model.addAttribute("PAGE_NUM",intPageNum);
		}
		
		// tbl_gallery table 전체 List를 가져와서
		// 전체 리스트를 표시하기 위해서 몇페이지의 nav가 필요한지
		// List<GalleryDTO> gallerPageList = gaService.selectAllPage(intPageNum,model);
		// model.addAttribute("GALLERYS",gallerPageList);
		
		// search_column, search_text를 사용하여 조건검색
		gaService.findBySearchPage(
				search_column, search_text,intPageNum,model);
		
		
		model.addAttribute("BODY","GA-LIST");
		return "home";
		
	}
	
	@RequestMapping(value="/input",method=RequestMethod.GET)
	public String input(Model model,HttpSession session) {
		
		MemberVO mVO = (MemberVO) session.getAttribute("MEMBER");
		if(mVO == null) {
			return "redirect:/member/login";
		}
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat st = new SimpleDateFormat("hh:mm:ss");
		
		String curDate = sd.format(date);
		String curTime = st.format(date);
		
		GalleryDTO gaDTO = GalleryDTO.builder()
							.g_date(curDate)
							.g_time(curTime)
							.g_writer("callor")
							.build();
		
		model.addAttribute("CMD",gaDTO);
		model.addAttribute("BODY","GA-INPUT");
		return "home";
	
	}
	
	@RequestMapping(value="/input",method=RequestMethod.POST)
	public String input(
			GalleryDTO gaDTO, 
			MultipartFile one_file,
			MultipartHttpServletRequest m_file,
			Model model) throws Exception {

		log.debug("겔러리 정보 {}", gaDTO.toString());
		log.debug("싱글 파일 {}", one_file.getOriginalFilename());
		log.debug("멀티파일 {}", m_file.getFileMap().toString());
		
		gaService.input(gaDTO, one_file, m_file);
		
		return "redirect:/gallery";
	}
	
	@RequestMapping(value="/detail/{seq}",method=RequestMethod.GET)
	public String detail(
			@PathVariable("seq") String seq, Model model) {

		Long g_seq = 0L;
		try {
			g_seq = Long.valueOf(seq);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			return "redirect:/gallery";
		}
		
		List<GalleryFilesDTO> gfList 
			= gaService.findByIdGalleryFiles(g_seq);
		model.addAttribute("GFLIST",gfList);
		model.addAttribute("BODY","GA-DETAIL");
		return "home";
		
	}
	
	@RequestMapping(value="/detail2/{seq}",method=RequestMethod.GET)
	public String detail(
			@PathVariable("seq") String seq, Model model, HttpSession session) {
		
		Long g_seq = 0L;
		try {
			g_seq = Long.valueOf(seq);
		} catch (Exception e) {
			// TODO: handle exception
			log.debug("갤러리 ID 값 오류");
			return "redirect:/";
		}

		GalleryDTO galleryDTO = gaService.findByIdGellery(g_seq);
		model.addAttribute("GALLERY",galleryDTO);
		model.addAttribute("BODY","GA-DETAIL-V2");
		return "home";
		
	}
	
	/*
	 * 첨부파일이 있는 게시물의 삭제
	 * 
	 */
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(
		 @RequestParam("g_seq")	String seq,HttpSession session) {

		// 삭제를 요구하면 
		// 1. 로그인이 되었나 확인
		// MemberVO memVO = (MemberVO) session.getAttribute("MEMBER");
		// if(memVO == null) {
		//	return "redirect:/member/login";
		// }
		
		Long g_seq = 0L;
		try {
			g_seq = Long.valueOf(seq);
		} catch (Exception e) {
			// TODO: handle exception
			log.debug("갤러리 SEQ 오류");
			return "redirect:/gallery";
		}
		
		int ret = gaService.delete(g_seq);
		
		return "redirect:/gallery";
	}
	
	@ResponseBody
	@RequestMapping(value="/file/delete/{seq}",method=RequestMethod.GET)
	public String file_delete( 
			@PathVariable("seq") String seq) {
		
		Long g_seq = 0L;
		try {
			g_seq = Long.valueOf(seq);
		} catch (Exception e) {
			// TODO: handle exception
			return "FAIL_SEQ";
		}
		
		int ret = gaService.file_delete(g_seq);

		if(ret > 0) return "OK";
		else return "FAIL";

	}
	
}
