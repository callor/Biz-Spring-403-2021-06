package com.callor.book.service.impl.movie;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.simple.parser.ParseException;

import com.callor.book.model.MovieDTO;
import com.callor.book.service.NaverMovieService;

public class NaverMovieServiceImplV1 implements NaverMovieService{

	@Override
	public String queryURL(String search_text) {
		return null;
	}

	@Override
	public String getJsonString(String queryURL) throws MalformedURLException, IOException {
		return null;
	}

	@Override
	public List<MovieDTO> getNaverList(String jsonString) throws ParseException {
		return null;
	}

}
