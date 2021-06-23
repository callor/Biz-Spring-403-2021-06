package com.callor.score.dao;

import java.util.List;

/*
 * 
 * Generic interface
 * 아직 매개변수, return type 정해지 않은 인터페이스
 * 같은 기능의 method 갖는 인터페이스를 설계할때
 * 복사 붙이기등을 하지 않고
 * 공통된 method를 쉽게구현하기 위하여 
 * 표준 parent형 인터페이스를 만든것
 *  
 */
public interface GenericDao<VO, PK> {

	public List<VO> selectAll();
	public VO findById(PK pk);
	
	public int insert(VO vo);
	public int update(VO vo);
	public int delete(PK pk);
	
}
