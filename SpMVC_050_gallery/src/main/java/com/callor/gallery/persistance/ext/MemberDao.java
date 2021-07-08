package com.callor.gallery.persistance.ext;

import com.callor.gallery.model.MemberVO;
import com.callor.gallery.persistance.GenericDao;

public interface MemberDao extends GenericDao<MemberVO, String>{
	
	public int insertOrUpdate(MemberVO memberVO);

}
