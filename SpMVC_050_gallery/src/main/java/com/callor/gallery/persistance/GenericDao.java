package com.callor.gallery.persistance;

import java.util.List;
import java.util.Map;

public interface GenericDao<VO, PK> {
	
	public List<VO> selectAll();
	public VO findById(PK pk);
	
	public int insert(VO vo);
	public int update(VO vo);
	public int delete(PK pk);
	
	public int create_table(Map<String,String> resultMaps);

}
