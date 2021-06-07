package com.callor.jdbc.pesistance.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.callor.jdbc.model.BookVO;
import com.callor.jdbc.pesistance.BookDao;

public class BookDaoImplV1 implements BookDao {
	
	// jdbc-context.xml 에 선언된 jdbcTemplate bean 사용하기
	protected final JdbcTemplate JdbcTemplate;
	public BookDaoImplV1(JdbcTemplate jdbcTemplate) {
		this.JdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<BookVO> selectAll() {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM tbl_books ";
		List<BookVO> books = JdbcTemplate.query(sql,
				new BeanPropertyRowMapper<BookVO>(BookVO.class)				
		);
		return null;
	}

	@Override
	public BookVO findById(String pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(BookVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BookVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String pk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BookVO> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookVO> findByDate(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookVO> findByComp(String comp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookVO> findByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

}
