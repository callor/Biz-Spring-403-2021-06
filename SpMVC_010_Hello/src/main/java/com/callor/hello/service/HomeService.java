package com.callor.hello.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

/*
 * Spring 프로젝트에서 클래스를 선언하고
 * 각 클래스에 stereotype을 부착하기
 * stererotype :  Component, Controller, Service, Repository ...
 * 
 * 클래스에 stereotype을 부착하는 순간
 * 	spring에게 이 클래스는 컨테이너에 보관해 달라 라고 요청하는 것
 *  이 클래스들을 객체로 생성하여 보관하고 있어달라 
 */
@Service
public class HomeService {

	public Integer add(int num1, int num2) {
		return num1 + num2;
	}

	public List<String> suffle() {
		return null;
	}

}
