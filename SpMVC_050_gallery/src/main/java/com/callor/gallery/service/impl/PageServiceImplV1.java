package com.callor.gallery.service.impl;

import org.springframework.stereotype.Service;

import com.callor.gallery.model.PageDTO;
import com.callor.gallery.service.PageService;

import lombok.Setter;


@Setter
@Service
public class PageServiceImplV1 implements PageService{
	
	// 한페이지에 보여질 데이터 리스트의 개수
	protected int listPerPage = 10;
	// 한페이지에 보여질 페이지 nav의 개수
	protected int nvasPerPage = 5;
	
	/*
	 * 전체 페이지수와 현재 페이지번호를 매개변수로 받아서
	 * paginatin을 그리는데 필요한 데이터를 생성하기
	 */
	@Override
	public PageDTO makePagination(int totalListSize, int currentPage) {
		// TODO Auto-generated method stub
		
		if(totalListSize < 1) return null;
		
		
		
		
		
		return null;
	}

	
	
}



