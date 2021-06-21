package com.callor.jdbc.pesistance.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.jdbc.model.BookVO;
import com.callor.jdbc.pesistance.BookDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("bookDaoV1")
public class BookDaoImplV1 implements BookDao {

	// Console로 log를 찍기 위하여 log 객체 생성	
	// lombok @Slf4j 를 사용하여 아래 코드를 대신한다
	//	private static Logger log 
	//			= LoggerFactory.getLogger("SERVICE");
	
	// jdbc-context.xml 에 선언된 jdbcTemplate bean 사용하기
	protected final JdbcTemplate jdbcTemplate;
	public BookDaoImplV1(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<BookVO> selectAll() {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM tbl_books ";
		/*
		 * jdbcTemplate.query(sql,return type)
		 * sql문을 실행한 후 return type형태로 데이터를
		 * 변환하여 return 해달라
		 */
		List<BookVO> books = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<BookVO>(BookVO.class)				
		);
		log.debug("SELECT {}",books.toString());
		return books;
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
