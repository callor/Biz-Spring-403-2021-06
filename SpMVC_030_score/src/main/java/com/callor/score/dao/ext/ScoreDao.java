package com.callor.score.dao.ext;

import java.util.List;

import com.callor.score.dao.GenericDao;
import com.callor.score.model.ScoreDTO;
import com.callor.score.model.ScoreVO;
import com.callor.score.model.SubjectAndScoreDTO;

public interface ScoreDao extends GenericDao<ScoreVO, Long>{
	
	public List<ScoreDTO> selectViewAll();
	public List<ScoreDTO> findByStNum(String st_num);
	public List<SubjectAndScoreDTO> selectSubjectAndScore(String st_num);

}
