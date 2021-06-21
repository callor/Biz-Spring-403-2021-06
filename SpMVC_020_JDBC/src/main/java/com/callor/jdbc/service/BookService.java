package com.callor.jdbc.service;

import java.util.List;

import com.callor.jdbc.model.BookVO;

public interface BookService {

	public List<BookVO> selectAll();

}
