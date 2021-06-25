package com.callor.score.service;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.callor.score.model.ScoreInputVO;
import com.callor.score.model.StudentVO;

public interface StudentServcie {
	
	public List<StudentVO> selectAll();
	public Map<String,Object> selectMaps();
	
	public String makeStNum();
	public String makeStNum(String prefix);
	
	public int insert(StudentVO stVO);
	public int update(StudentVO stVO);
	public String detail(Model model, String st_num);
	public String scoreInput(ScoreInputVO scInputVO);

}
