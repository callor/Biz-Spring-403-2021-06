package com.callor.book.service;

import java.util.List;

import com.callor.book.model.BookDTO;

public interface BookService {
	public int insert(String isbn) throws Exception;

	public List<BookDTO> selectAll();

}
