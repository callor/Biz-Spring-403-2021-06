package com.callor.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.callor.book.config.NaverQualifier;
import com.callor.book.model.BookDTO;
import com.callor.book.model.MovieDTO;
import com.callor.book.model.NewsDTO;
import com.callor.book.service.NaverAbstractService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service(NaverQualifier.NAVER_MAIN_SERVICE_V1)
public class NaverMainService {

	@Qualifier(NaverQualifier.NAVER_BOOK_SERVICE_V2)
	protected final NaverAbstractService<BookDTO> nBookService;
	
	@Qualifier(NaverQualifier.NAVER_MOVIE_SERVICE_V1)
	protected final NaverAbstractService<MovieDTO> nMovieService;

	@Qualifier(NaverQualifier.NAVER_NEWS_SERVICE_V1)
	protected final NaverAbstractService<NewsDTO> nNewsService;

	@Qualifier(NaverQualifier.NAVER_NEWS_SERVICE_V2)
	protected final NaverAbstractService<NewsDTO> nNewsServiceV2;
	
	public void naverGetData(String cat, String search,Model model) throws Exception {
		
		if(search != null && !search.equals("")) {
			if(cat.equalsIgnoreCase("BOOK")) {
				// 도서 검색 서비스
				
				String queryURL = nBookService.queryURL(search);
				String jSonString = nBookService.getJsonString(queryURL);
				List<BookDTO> books = nBookService.getNaverList(jSonString);
				model.addAttribute("BOOKS",books);
				
			} else if (cat.equalsIgnoreCase("NEWS")) {
				// 뉴스 검색 서비스
				/*
				 * 
				 * V1
				 * queryURL을 생성하고
				 * naver에 JSON String을 요청하고
				 * Gson을 사용하여 parsing 하여 List<NewsDTO>를 얻었다
				 * 
				 * V2
				 * queryURL을 생성하고
				 * naver에 JSON String을 요청하는 대신
				 * ( getJsonString() method를 사용하지 않겠다 )
				 * getNaverList() method에 queryURL을 직접 주입하여
				 * 데이터를 가져오기
				 * 
				 */
				String queryURL = nNewsService.queryURL(search);
				
				// String jsonString = nNewsService.getJsonString(queryURL);
				// log.debug("JsonString : {}",jsonString);
				
				// List<NewsDTO> newsList = nNewsService.getNaverList(jsonString);
				List<NewsDTO> newsList = nNewsServiceV2.getNaverList(queryURL);
				
				model.addAttribute("NEWS_LIST",newsList);

			} else if(cat.equalsIgnoreCase("MOVIE")) {
				// 영화검색 서비스
				String queryURL = nMovieService.queryURL(search);
				String jsonString = nMovieService.getJsonString(queryURL);
				log.debug("JsonString : {}",jsonString);
				List<MovieDTO> movies = nMovieService.getNaverList(jsonString);
				model.addAttribute("MOVIES",movies);
			}
		}
	}

	public String naverGetJsonString(String cat, String search) throws Exception {
		// TODO Auto-generated method stub
		String queryURL = nNewsService.queryURL(search);
		String jsonString = nNewsService.getJsonString(queryURL);
		return jsonString;
	}
	
	public List<NewsDTO> naverGetList(String search) throws Exception {
		
		String queryURL = nNewsServiceV2.queryURL(search);
		return nNewsServiceV2.getNaverList(queryURL);
		
	}
}
