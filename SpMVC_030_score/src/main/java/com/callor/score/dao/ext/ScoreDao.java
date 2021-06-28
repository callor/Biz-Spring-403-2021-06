package com.callor.score.dao.ext;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.callor.score.dao.GenericDao;
import com.callor.score.model.ScoreDTO;
import com.callor.score.model.ScoreVO;
import com.callor.score.model.SubjectAndScoreDTO;

public interface ScoreDao extends GenericDao<ScoreVO, Long>{
	
	public List<ScoreDTO> selectViewAll();
	public List<ScoreDTO> findByStNum(String st_num);
	public List<SubjectAndScoreDTO> selectSubjectAndScore(String st_num);

	/*
	 * mybatis에서 
	 * SQL Select의 결과가 
	 * 숫자일 경우 resultType으로 wrapper class를 지정한다
	 * int : Integer, long : Long
	 * 
	 * 문자열일 경우 resultType으로 String을 반드시 지정한다
	 * String : String
	 * 
	 * Dao method의 return type도 
	 * 			wrapper class type으로 지정 
	 */
	public Integer scoreCount(String st_num);
	public Integer scoreSum(String st_num);
	
	/*
	 * Mybatis method, mapper에서 사용할
	 * 변수가 2개 이상일 경우
	 * 각각의 변수에 @Param("변수이름")을 반드시
	 * 명시해야 한다
	 * 
	 * 변수가 1개만 있을 경우는
	 * 변수 이름이 달라도 괜찮다
	 */
	// #{st_num},#{sc_sbcode}, #{sc_score}
	public Integer insertOrUpdate(
			@Param("st_num") String sc_num, 
			@Param("sc_sbcode") String sc_sbcode, 
			@Param("sc_score") String sc_score);
	
	public Integer insertOrUpdateForList(
			@Param("st_num") String st_num, 
			@Param("scoreMaps") List<Map<String, String>> scoreMaps);
	
}
