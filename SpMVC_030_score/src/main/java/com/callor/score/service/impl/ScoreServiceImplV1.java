package com.callor.score.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.score.dao.ext.ScoreDao;
import com.callor.score.model.ScoreDTO;
import com.callor.score.service.ScoreService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service("scoreServiceV1")
public class ScoreServiceImplV1 implements ScoreService{

	protected final ScoreDao scDao;
	@Override
	public List<ScoreDTO> scoreAllList() {
		
		List<ScoreDTO> scoreList = scDao.selectViewAll();
		log.debug("Score {}", scoreList.toString());
		return scoreList;
		
	}
}
