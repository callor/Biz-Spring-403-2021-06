package com.callor.gallery.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.callor.gallery.model.GalleryDTO;
import com.callor.gallery.persistance.ext.FileDao;
import com.callor.gallery.persistance.ext.GalleryDao;
import com.callor.gallery.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("galleryServiceV2")
public class GalleryServiceImplV2 extends GalleryServiceImplV1{

	/*
	 * 
	 * @RequireArgConstructor 문제로 상속받은 클래스에서
	 * 강제로 생성자 만들어야 함
	 * 
	 */
	public GalleryServiceImplV2(
				GalleryDao gaDao, 
				FileDao fDao, 
				@Qualifier("fileServiceV2")  FileService fService) {
		super(gaDao, fDao, fService);
	}

	@Override
	public GalleryDTO findByIdGellery(Long g_seq) {

		GalleryDTO gallery = gaDao.findByIdGalleryFilesResultMap(g_seq);
		if(gallery != null) {
			log.debug("갤러리 데이터 {}", gallery.toString());
		}
		return gallery;
	}


}
