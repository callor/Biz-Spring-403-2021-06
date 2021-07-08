package com.callor.gallery.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
		
		List<MemberVO> members = memDao.selectAll();
		log.debug("Members {}",members.toString());
		
		// 아직 member table에 데이터가 하나도 없는 상태
		// 최초로 가입신청이 된 상태
		// 최초로 가입되는 member는 ADMIN
		// ADMIN은 level이 0 이다
		if(members == null || members.size() < 1) {
			memberVO.setM_level(0);
		} else {
			memberVO.setM_level(9);
		}
		memDao.insertOrUpdate(memberVO);
		return memberVO;
	
	}

	@Override
	public MemberVO update(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO findById(String m_userid) {

		MemberVO memberVO = memDao.findById(m_userid.trim());
		
		if(memberVO == null) {
			// 가입되지 않은 사용자 ID
			log.debug("가입되지 않은 사용자 {}", m_userid );
		} else {
			log.debug("조회된 사용자 정보 : {}", memberVO.toString());	
		}
		return memberVO;
	}


	@Override
	public MemberVO login(MemberVO memberVO, Model model) {
		// TODO Auto-generated method stub
		
		// 1. memberVO에서 m_userid를 getter 한 후
		// 2. findById() 를 통해 id 조회
		// 3. 만약 결과가 null 이면 : 가입되지 않은 ID
		// 4. 결과가 null이 아니면
		// 5. 비밀번호 일치 조회
		// 6. 일치하지 않으면 : 비밀번호 오류 로그인 거부
		// 7. 일치하면 : 로그인 처리
		
		MemberVO findVO = memDao.findById(memberVO.getM_userid());
		if(findVO == null) {
			model.addAttribute("LOGIN_FAIL","NOT_USERID");
			return null;
		}
		
		// 비밀번호 비교
		if(findVO.getM_password().equals(memberVO.getM_password())) {
			return findVO;
		}
		
		model.addAttribute("LOGIN_FAIL","NEQ_PASS");
		return null;
	
	}

}
