package com.callor.book.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NaverService {
	
	/*
	 * naver에 요청하기
	 * BookURL + "?query=" + 검색문자열
	 * 
	 */
	
	protected final String BookURL 
		= "https://openapi.naver.com/v1/search/book.json";
	protected final String NewsURL 
		= "https://openapi.naver.com/v1/search/news.json";
	protected final String MovieURL
		= "https://openapi.naver.com/v1/search/movie.json";
	
	
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
		queryURL.append(BookURL); // queryString += BookURL
		
		String queryString = String.format("?query=%s",searchUTF8);
		queryURL.append(queryString);
		queryString = String.format("&display=%d", 20);
		queryURL.append(queryString);
		return queryURL.toString();
	
	}
}
