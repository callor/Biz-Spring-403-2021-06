package com.callor.book.service.impl.movie;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.callor.book.config.NaverQualifier;
import com.callor.book.config.NaverSecret;
import com.callor.book.model.MovieDTO;
import com.callor.book.service.NaverAbstractService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(NaverQualifier.NAVER_MOVIE_SERVICE_V1)
public class NaverMovieServiceImplV1 
		extends NaverAbstractService<MovieDTO>{

	@Override
	public String queryURL(String search_text) throws Exception {
		
		String searchUTF = URLEncoder.encode(search_text,"UTF-8");
		
		String queryURL = NaverSecret.NURL.MOVIE;
		queryURL += "?query=%s&display=10";
		
		queryURL = String.format(queryURL,searchUTF);
		log.debug("queryURL : {}",queryURL);
		return queryURL;
	
	}

	/*
	 * gSon 을 사용하여 jsonString을 List<MovieDTO>로 변환하기
	 */
	@Override
	public List<MovieDTO> getNaverList(String jsonString) throws Exception {
		
		JsonElement jsonElement 
				= JsonParser.parseString(jsonString);
		JsonElement oItems 
				= jsonElement.getAsJsonObject().get("items");
		
		Gson gson = new Gson();
		TypeToken<List<MovieDTO>> typeToken 
				= new TypeToken<List<MovieDTO>> () {};
		
		List<MovieDTO> movies 
				= gson.fromJson(oItems, typeToken.getType());		
		return movies;
	}
}
