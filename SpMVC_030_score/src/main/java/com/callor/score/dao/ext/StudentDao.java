package com.callor.score.dao.ext;

import com.callor.score.dao.GenericDao;
import com.callor.score.model.StudentVO;

public interface StudentDao extends GenericDao<StudentVO, String>{
	
	// 학생테이블에 저장된 데이터에서
	// 가장 마지막의 학번(가장 큰번호)를 추출하기
	public String getMaxStNum();

}
