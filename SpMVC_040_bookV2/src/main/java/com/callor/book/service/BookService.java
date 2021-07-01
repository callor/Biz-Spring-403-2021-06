package com.callor.book.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.json.simple.parser.ParseException;

public interface BookService {
	public int insert(String isbn) throws UnsupportedEncodingException, IOException, ParseException;
}
