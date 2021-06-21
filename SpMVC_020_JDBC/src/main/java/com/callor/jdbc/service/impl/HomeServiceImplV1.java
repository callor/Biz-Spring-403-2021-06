package com.callor.jdbc.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.callor.jdbc.service.AuthorService;
import com.callor.jdbc.service.BookService;
import com.callor.jdbc.service.CompService;
import com.callor.jdbc.service.HomeService;

import lombok.RequiredArgsConstructor;

/*
 * private final, protected final로 선언된
 * 필드 맴버 변수를 초기화하는 코드를 갖는
 * 생성자를 만들어 준다
 */
@RequiredArgsConstructor

@Service("homeServiceV1")
public class HomeServiceImplV1 implements HomeService {

	protected final BookService bookService;
	protected final AuthorService auService;
	protected final CompService cpService;
	
	@Override
	public void dashBoard(Model model) {
		// TODO Auto-generated method stub
		
	}

}
