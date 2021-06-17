package com.callor.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.callor.jdbc.model.UserVO;

public class Main {
	
	/*
	 * primitive type의 변수는 함수에 매개변수로 전달하였을때
	 * 함수에서 매개변수의 값을 변경하여도
	 * 호출하기 전 원래 변수의 값은 변함이 없다
	 * 
	 * type형 변수(Class type의 변수, Class로 생성된 객체변수)는
	 * 함수에 매개변수로 전달하였을때
	 * 변수의 요소중 일부를 변경하거나, 추가, 삭제하면
	 * 원래 함수에 전달하기 전의 변수값이 변경된다
	 * 
	 */
	public static void main(String[] args) {
		
		int num1 = 0;
		add(num1);
		System.out.println(num1);
		
		List<UserVO> userList = new ArrayList<UserVO>();
		System.out.println("최초:" + userList.toString());
		
		add(userList);
		add(userList);
		add(userList);
		System.out.println("add 후:" + userList.toString());
	}
	public static void add(int num) {
		num = 1000;
	}
	public static void add(List<UserVO> users) {
		
		Random rnd = new Random();
		UserVO userVO = new UserVO();
		userVO.setName("홍길동");
		userVO.setUsername( String.valueOf(rnd.nextInt(100)) );
		users.add(userVO);
		
	}

}
