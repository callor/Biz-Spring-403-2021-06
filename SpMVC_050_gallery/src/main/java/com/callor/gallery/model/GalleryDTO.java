package com.callor.gallery.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GalleryDTO {
	
	/*
	 * 사진 갤러리 게시판을 만들기 위해서
	 * Contents를 저장할 table 구조의 DTO를 생성하기
	 */
	private Long g_seq; // PK, 자동설정
	private String g_writer; // 작성자
	private String g_date; // 작성일자
	private String g_time; // 작성시각
	private String g_subject; // 제목
	private String g_content; // 내용
	private String g_image; // 사진갤러리의 대표 이미지
	
	// Gallery와 연관된 FileList를 담을 List type의 변수를 추가
	// mapper에서 Collection으로 채울 데이터
	List<FileDTO> fileList;

}





