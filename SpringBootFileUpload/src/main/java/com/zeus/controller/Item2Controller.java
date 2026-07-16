package com.zeus.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zeus.domain.Item2;
import com.zeus.service.Item2Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
//@MapperScan(basePackages = "com.zeus.mapper")
public class Item2Controller {
	//http://localhost:8080/board/insertForm
	
	@Autowired
	private Item2Service service;
	
	@Value("${upload.path}")
	private String uploadPath;
	
	@RequestMapping(value = "/item2/updateForm", method=RequestMethod.GET)
	public String item2UpdateForm(Item2 item, Model model) throws Exception {
		item = service.select(item);
		model.addAttribute("item", item);
		return "item2/updateForm";
	}
	
	@RequestMapping(value = "/item2/update", method=RequestMethod.POST)
	public String item2Update(Item2 item, Model model) throws Exception {
		List<MultipartFile> fileList = item.getPictures();
		String oldFileName = null;

		for (int i = 1; i <= 2; i++) {
			MultipartFile file = fileList.get(i-1);
			
			switch (i) {
				case 1: oldFileName = item.getPictureUrl2(); break;
				case 2: oldFileName = item.getPictureUrl2(); break;
				default: break;
			}
			
			if(file != null && file.getSize() > 0) {
				String createdFileName = uploadFile(file.getOriginalFilename(), file.getBytes());
				switch (i) {
					case 1: item.setPictureUrl1(createdFileName); break;
					case 2: item.setPictureUrl2(createdFileName); break;
					default: break;
				}
				if (oldFileName != null) {
					File _file = new File(uploadPath + File.separator + oldFileName);
					if(_file.exists()) _file.delete();
				}
			}
		}
		
		boolean result = service.update(item);			
		if (!result) return "item2/fail";
		else 		 return "item2/success";
	}
	
	
	@RequestMapping(value = "/item2/deleteForm", method=RequestMethod.GET)
	public String item2DeleteForm(Item2 item, Model model) throws Exception {
		item = service.select(item);
		model.addAttribute("item", item);
		return "item2/deleteForm";
	}
	
	@RequestMapping(value = "/item2/delete", method=RequestMethod.POST)
	public String item2Delete(Item2 item, Model model) throws Exception {
		item = service.select(item);

		String createFilename = null;
		for (int i = 1; i <= 2; i++) {
			switch (i) {
				case 1: createFilename = item.getPictureUrl1(); break;
				case 2: createFilename = item.getPictureUrl2(); break;
				default: break;
			}
			
			if(createFilename != null) {
				File file = new File(uploadPath + File.separator + createFilename);
				if(file.exists()) file.delete();
			}
		}

		boolean result = service.delete(item);
			
		if (!result) return "item2/fail";
		else 		 return "item2/success";
	}
	
	@RequestMapping(value = "/item2/display", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<byte[]> item2Display(Item2 item, Model model, int no) throws Exception {
		// 이미지 -> byte[] 전송 // File -> byte[] -> InputStream
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		MediaType mediaType = null;
		String createFileName = null;

		try {
			item = service.select(item);
			
			switch (no) {
				case 1: createFileName = item.getPictureUrl1(); break;
				case 2: createFileName = item.getPictureUrl2(); break;
				default: break;
			}
			
			int index = createFileName.lastIndexOf("."); // 확장자 위치파악
			String formatName = createFileName.substring(index + 1); // 확장자 걸러내기
			
			switch (formatName.toUpperCase()) {
				case "JPEG": mediaType = MediaType.IMAGE_JPEG; break;
				case "JPG": mediaType = MediaType.IMAGE_JPEG; break;
				case "GIF": mediaType = MediaType.IMAGE_GIF; break;
				case "PNG": mediaType = MediaType.IMAGE_PNG; break;	
				default: mediaType = null; break;
			}
			
			HttpHeaders httpHeaders = new HttpHeaders();
			// 저장된 파일 C:/upload/파일명.확장자
			in = new FileInputStream(uploadPath + File.separator + createFileName);
			// httpHeaders ContentType 등록
			if(mediaType != null) httpHeaders.setContentType(mediaType);
			// 객체 생성		
			entity = new ResponseEntity<byte[]> (IOUtils.toByteArray(in), httpHeaders, HttpStatus.CREATED);
		} catch (Exception e) {
			entity = new ResponseEntity<byte[]> (HttpStatus.BAD_REQUEST);
		} finally {
			if(in!=null) in.close();
		}
		return entity;
	}
	
//	@RequestMapping(value = "/item2/display2", method=RequestMethod.GET)
//	@ResponseBody
//	public ResponseEntity<byte[]> item2Display2(Item2 item, Model model) throws Exception {
//		// 이미지 -> byte[] 전송 // File -> byte[] -> InputStream
//		InputStream in = null;
//		ResponseEntity<byte[]> entity = null;
//		MediaType mediaType = null;
//		
//		try {
//			item = service.select(item);
//			String createFileName = item.getPictureUrl2();
//			int index = createFileName.lastIndexOf("."); // 확장자 위치파악
//			String formatName = createFileName.substring(index + 1); // 확장자 걸러내기
//			
//			switch (formatName.toUpperCase()) {
//				case "JPEG": mediaType = MediaType.IMAGE_JPEG; break;
//				case "JPG": mediaType = MediaType.IMAGE_JPEG; break;
//				case "GIF": mediaType = MediaType.IMAGE_GIF; break;
//				case "PNG": mediaType = MediaType.IMAGE_PNG; break;	
//				default: mediaType = null; break;
//			}
//			
//			HttpHeaders httpHeaders = new HttpHeaders();
//			// 저장된 파일 C:/upload/파일명.확장자
//			in = new FileInputStream(uploadPath + File.separator + createFileName);
//			// httpHeaders ContentType 등록
//			if(mediaType != null) httpHeaders.setContentType(mediaType);
//			// 객체 생성		
//			entity = new ResponseEntity<byte[]> (IOUtils.toByteArray(in), httpHeaders, HttpStatus.CREATED);
//		} catch (Exception e) {
//			entity = new ResponseEntity<byte[]> (HttpStatus.BAD_REQUEST);
//		} finally {
//			if(in!=null) in.close();
//		}
//		return entity;
//	}
	
	@RequestMapping(value = "/item2/listForm", method=RequestMethod.GET)
	public String item2List(Item2 item, Model model) throws Exception {
		List<Item2> list = service.list();
		model.addAttribute("list", list);
		return "item2/listForm";
	}
	
	// File upload 화면
	@RequestMapping(value = "/item2/insertForm", method=RequestMethod.GET)
	public String item2InsertForm(Item2 item, Model model) {
		model.addAttribute("item", item);
		return "item2/insertForm";
	}
	// DB 저장요청
	@RequestMapping(value = "/item2/insert", method=RequestMethod.POST)
	public String item2Insert(Item2 item, Model model) throws Exception {
		List<MultipartFile> fileList = item.getPictures();
		
		for (int i = 1; i <= 2; i++) {
			MultipartFile file = fileList.get(i-1);
			log.info("원래파일명 : " + file.getOriginalFilename());
			log.info("파일사이즈 : " + file.getSize());
			log.info("컨텐츠타입 : " + file.getContentType());
			
			String createdFileName = uploadFile(file.getOriginalFilename(), file.getBytes());
			switch (i) {
				case 1: item.setPictureUrl1(createdFileName); break;
				case 2: item.setPictureUrl2(createdFileName); break;
				default: break;
			}
		}
//		int count = 0;
//		for (MultipartFile file : fileList) {
//			log.info("원래파일명 : " + file.getOriginalFilename());
//			log.info("파일사이즈 : " + file.getSize());
//			log.info("컨텐츠타입 : " + file.getContentType());
//			
//			String createdFileName = uploadFile(file.getOriginalFilename(), file.getBytes());
//			if (count==0) item.setPictureUrl1(createdFileName);
//			if (count==1) item.setPictureUrl2(createdFileName);
//			count++;
//		}
		boolean result = service.insert(item);
		
		if (!result) return "item2/fail";
		else 		 return "item2/success";
	}
	
	private String uploadFile(String originalName, byte[] fileData) throws Exception {
		// src/test/java 에서 출력 테스트
		// UID 생성 + originalName -> 06a491c8-d11a-42f4-99ed-c4bbcafa8d5e_홍길동.jpg
		// uploadPath -> @Value("${upload.path}") -> application.properties -> C:/upload
		UUID uid = UUID.randomUUID();
		String createdFileName = uid.toString() + "_" + originalName;
		File target = new File(uploadPath, createdFileName);
		FileCopyUtils.copy(fileData, target);
		
		return createdFileName;
	}

}
