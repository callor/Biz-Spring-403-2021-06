package com.callor.jdbc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.jdbc.model.AuthorVO;
import com.callor.jdbc.pesistance.AuthorDao;
import com.callor.jdbc.service.AuthorService;

@Service("authorServiceV1")
public class AuthorServiceImplV1 implements AuthorService{
	
	@Autowired
	protected AuthorDao auDao;

	@Override
	public List<AuthorVO> selectAll() {
		return auDao.selectAll();
	}

	@Override
	public AuthorVO findByACode(String au_code) {
		return auDao.findById(au_code.trim());
	}

	@Override
	public List<AuthorVO> findByAName(String au_name) {
		return auDao.findByAName(au_name.trim());
	}

	@Override
	public List<AuthorVO> findByATel(String au_tel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AuthorVO> findByNameAndTel(String au_text) {

		List<AuthorVO> nameList = auDao.findByAName(au_text);
		List<AuthorVO> telList = auDao.findByATel(au_text);
		
		// nameList에 telList를 통째로 합치기
		// 두 list의 Generic type이 같을 경우 가능
		nameList.addAll(telList);
		return nameList;
		
	}

	
}
