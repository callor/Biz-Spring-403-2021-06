package com.callor.gallery.service.impl;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.service.FileService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service("fileServiceV1")
public class FileServiceImplV1 implements FileService{
	
	// 서버의 특별한 폴더에 접근하기 위해
	// 서버의 정보를 가져오기 위한 helper class
	protected final ServletContext context;
	protected final ResourceLoader resLoader;

	@Override
	public String fileUp(MultipartFile file) throws Exception {

		// 파일정보에서 파일이름 추출하기
		String originaFileName = file.getOriginalFilename();
		
		// 파일 이름이 비어있으면 null을 return
		if(originaFileName.isEmpty()) {
			return null;
		} 
		
		log.debug("파일이름 {} ", originaFileName);
		
		// file-context.xml에 설정된 
		// files 폴더 정보를 가져오기
		// 여기에 파일을 Upload 저장할 예정
		Resource res = resLoader.getResource("/files"); 
		// log.debug("path : {}",res.getURI().getPath());
		
		String filePath = res.getURI().getPath();
		
		return null;
	}

	@Override
	public List<String> filesUp(MultipartHttpServletRequest files) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}


