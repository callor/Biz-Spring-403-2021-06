package com.callor.book.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.json.simple.parser.ParseException;

import com.callor.book.model.BookDTO;

public interface BookService {
	public int insert(String isbn) throws UnsupportedEncodingException, IOException, ParseException;

	public List<BookDTO> selectAll();

}
