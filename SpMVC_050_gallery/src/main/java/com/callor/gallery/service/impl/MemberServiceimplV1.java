package com.callor.gallery.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.gallery.model.MemberVO;
import com.callor.gallery.persistance.ext.MemberDao;
import com.callor.gallery.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service("memberServiceV1")
public class MemberServiceimplV1 implements MemberService {

	protected final MemberDao memDao;
	
	@Autowired
	public void create_member_table(MemberDao dummy) {
		Map<String, String> maps = new HashMap<String, String>();
		memDao.create_table(maps);
	}
	
	
	/*
	 * 1. 회원가입에서 최초로 가입된 member는 ADMIN이다
	 * 		회원테이블에 데이터가 있냐 없냐?
	 * 		selectAll() method를 사용하여 최초 가입된 member인지 파악
	 * 
	 * 2. ADMIN 권한을 갖는 최초의 가입자는 level 0 이다
	 * 3. ADMIN 이 아닌 일반 가입가는 기본 level이 9 이다
	 * 4. level 6 보다 큰 member는 이미지 보기만 가능하다
	 * 5. 이미지 등록을 하려면 level이 6보다 작아야 한다.
	 * 6. 최초 가입한 member가 가입승인이 되면 level을 6으로 설정한다.
	 * 7. 이미 가입된 member의 m_userid 정보가 JOIN을 통해서 전달되면
	 * 		회원 정보를 Update한다
	 */
	@Override
	public MemberVO join(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO update(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO findById(String m_userid) {
		// TODO Auto-generated method stub
		return null;
	}

}
