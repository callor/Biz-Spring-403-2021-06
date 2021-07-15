package com.callor.gallery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.callor.gallery.model.FileDTO;
import com.callor.gallery.model.GalleryDTO;
import com.callor.gallery.persistance.ext.FileDao;
import com.callor.gallery.persistance.ext.GalleryDao;
import com.callor.gallery.service.FileService;
import com.callor.gallery.service.PageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("galleryServiceV2")
public class GalleryServiceImplV2 extends GalleryServiceImplV1{


	/*
	 * @RequireArgConstructor 를 사용한 클래스를 상속받을때는
	 * 상속받은 클래스에서 강제로 생성자 만들어야 함
	 * 
	 * eClipse의 자동완성 기능을 사용하여 생성자를 만든다
	 * 만약 매개변수로 설정된 요소중에 interface를 상속받은 클래스가
	 * 2개 이상일 경우 @Qualifier()를 설정해야 하는데
	 * 
	 * 이때 각 매개변수의 요소 type 앞에 작성해 주면된다
	 */
	public GalleryServiceImplV2(GalleryDao gaDao, FileDao fDao, 
			@Qualifier("fileServiceV2") FileService fService, PageService pageService) {
		super(gaDao, fDao, fService, pageService);
		// TODO Auto-generated constructor stub
	}

	@Override
	public GalleryDTO findByIdGellery(Long g_seq) {

		GalleryDTO gallery = gaDao.findByIdGalleryFilesResultMap(g_seq);
		if(gallery != null) {
			log.debug("갤러리 데이터 {}", gallery.toString());
		}
		return gallery;
	}

	/*
	 * 첨부파일이 있는 게시물 삭제하기
	 * 1. 첨부파일을 제거한 후
	 * 		가. 첨부파일을 삭제하기 위하여 데이터를 다시 select하여
	 * 			첨부파일 이름을 가져오기
	 * 		나, 가져온 이름으로 파일을 삭제하고
	 * 2. 게시물 데이터를 삭제
	 * 
	 * 첨부파일 뿐만 아니라 JOIN 데이터가 또 있다.
	 * JOIN 데이터에 첨부파일 정보가 또~~ 있다
	 * 
	 * 1. JOIN 된 데이터의 첨부파일을 삭제한 후
	 * 2. JOIN 된 데이터를 삭제하고
	 * 3. 본문(Gallery)의 첨부파일을 삭제하고
	 * 4. 본문을 삭제
	 * 
	 */
	@Override
	public int delete(Long g_seq) {
		
		// Gallery 데이터와 fileList 데이터가 같이 포함된 데이터
		GalleryDTO gaDTO = gaDao.findByIdGalleryFilesResultMap(g_seq);
		if(gaDTO == null) {
			return 0;
		}

		List<FileDTO> fileList = gaDTO.getFileList();
		for(FileDTO file : fileList) {
			
			// 첨부파일 삭제
			
			String attFileName = file.getFile_upname();
			int ret = fService.delete(attFileName);
			
			// 데이터 한개씩 삭제
			if(ret > 0) {
				fDao.delete(file.getFile_seq());
			}
			
		}
		
		// 본문 첨부파일 삭제
		String imgFileName = gaDTO.getG_image();
		int ret = fService.delete(imgFileName);
		
		if(ret > 0) {
			// 본문 데이터 삭제
			gaDao.delete(g_seq);
		} else {
			log.debug("파일 삭제 실패로 데이터 삭제 하지 않음");
		}
		return 0;
	}
	
}
