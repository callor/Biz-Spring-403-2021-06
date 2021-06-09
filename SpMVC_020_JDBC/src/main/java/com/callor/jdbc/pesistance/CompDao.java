package com.callor.jdbc.pesistance;

import java.util.List;

import com.callor.jdbc.model.CompVO;

public interface CompDao extends GenericDao<CompVO, String>{
	
	public String findByMaxCode();
	public List<CompVO> findByCName(String cname);
	public List<CompVO> findByTel(String tel);
	public List<CompVO> findByCeo(String ceo);
	
}