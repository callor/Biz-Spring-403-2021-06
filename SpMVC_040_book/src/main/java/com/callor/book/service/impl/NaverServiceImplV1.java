package com.callor.book.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.book.config.NaverSecret;
import com.callor.book.model.BookDTO;
import com.callor.book.service.NaverService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NaverServiceImplV1 implements NaverService<BookDTO>{
	
	/*
	 * naver에 요청하기
	 * BookURL + "?query=" + 검색문자열
	 * 
	 */
	public String queryURL(String search) {
		
		// 검색하고자 하는 문자열을 UTF-8로 인코딩
		String searchUTF8 = null;
		try {
			 searchUTF8 = URLEncoder.encode(search,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		StringBuilder queryURL = new StringBuilder();
		queryURL.append(NaverSecret.NURL.BOOK); // queryString += BookURL
		
		String queryString = String.format("?query=%s",searchUTF8);
		queryURL.append(queryString);
		queryString = String.format("&display=%d", 20);
		queryURL.append(queryString);
		log.debug("queryURL {} ", queryURL.toString());
		return queryURL.toString();
	}

	/*
	 * queryURL을 naver에 전송하고 naver로 부터 결과를 받는 method
	 */
	@Override
	public String getJsonString(String queryURL) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<BookDTO> getNaverList(String jsonString) {
		// TODO Auto-generated method stub
		return null;
	}
}
