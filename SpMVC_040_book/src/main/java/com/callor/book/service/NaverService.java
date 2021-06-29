package com.callor.book.service;

import java.util.List;

/*
 * Naver의 OpenAPI를 통하여 데이터를 검색하는 서비스
 * 도서정보, 뉴스정보, 영화정보를 가져올텐데
 * Naver에서 제공하는 데이터가 조금씩 차이가 난다
 * 
 * OpenAPI를 통해서 데이터를 가져올때
 * 받을 데이터에 대한 VO(DTO)를 생성해야 한다
 * 
 * Naver에 받을 데이터에 대한 VO를 만들어야 하는데
 * 각각 도서, 뉴스, 영화 데이터가 조금씩 달라서
 * 세개의 VO를 생성해야 한다
 * 각각 VO별로 서비스를 생성하기 위하여
 * 미리 인터페이스를 만드는데 VO구조가 달라
 * 다소 어려움이 있을 것을 예상된다
 * 
 * 그래서 인터페이스에 Generic을 선언하여
 * VO별로 필요에 따라 클래스를 만들수 있도록 한다
 * 
 */
public interface NaverService<T> {

	// 검색문자열을 받아서 검색을 위한 URL을 생성하여 return
	public String queryURL(String search_text);
	
	// queryURL을 Naver에 보내고
	// Naver가 보낸 데이터를 JSON형태의 문자열로 만들어 return
	public String getJsonString(String queryURL);
	
	// JSON 형태의 문자열을 받아서
	// VO를 담은 List type으로 return
	// JSON 문자열을 parsing하여 객체(리스트) type으로 변환
	public List<T> getNaverList(String jsonString);
	
}
