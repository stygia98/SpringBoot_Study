package com.zeus.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.mybatis.spring.annotation.MapperScan;
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

import com.zeus.domain.Item;
import com.zeus.service.ItemService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@MapperScan(basePackages = "com.zeus.mapper")
public class ItemController {
	//http://localhost:8080/board/insertForm
	
	@Autowired
	private ItemService service;
	
	@Value("${upload.path}")
	private String uploadPath;
	
	@RequestMapping(value = "/item/updateForm", method=RequestMethod.GET)
	public String itemUpdateForm(Item item, Model model) throws Exception {
		item = service.select(item);
		model.addAttribute("item", item);
		return "item/updateForm";
	}
	
	@RequestMapping(value = "/item/update", method=RequestMethod.POST)
	public String itemUpdate(Item item, Model model) throws Exception {
		MultipartFile file = item.getPicture();
		String oldFileName = item.getPictureUrl();
		
		if(file != null && file.getSize() > 0) {
			String createdFileName = uploadFile(file.getOriginalFilename(), file.getBytes());
			item.setPictureUrl(createdFileName);
			if (oldFileName != null) {
				File _file = new File(uploadPath + File.separator + oldFileName);
				if(_file.exists()) _file.delete();
			}
		}
		
		boolean result = service.update(item);			
		if (!result) return "item/fail";
		else 		 return "item/success";
	}
	
	
	@RequestMapping(value = "/item/deleteForm", method=RequestMethod.GET)
	public String itemDeleteForm(Item item, Model model) throws Exception {
		item = service.select(item);
		model.addAttribute("item", item);
		return "item/deleteForm";
	}
	
	@RequestMapping(value = "/item/delete", method=RequestMethod.POST)
	public String itemDelete(Item item, Model model) throws Exception {
		item = service.select(item);
		String createFilename = item.getPictureUrl();
		if(createFilename != null) {
			File file = new File(uploadPath + File.separator + createFilename);
			if(file.exists()) file.delete();
		}
		
		boolean result = service.delete(item);
			
		if (!result) return "item/fail";
		else 		 return "item/success";
	}
	
	@RequestMapping(value = "/item/display", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<byte[]> itemDisplay(Item item, Model model) throws Exception {
		// 이미지 -> byte[] 전송 // File -> byte[] -> InputStream
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		MediaType mediaType = null;
		
		try {
			item = service.select(item);
			String createFileName = item.getPictureUrl();
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
	
	@RequestMapping(value = "/item/listForm", method=RequestMethod.GET)
	public String itemList(Item item, Model model) throws Exception {
		List<Item> list = service.list();
		model.addAttribute("list", list);
		return "item/listForm";
	}
	
	// File upload 화면
	@RequestMapping(value = "/item/insertForm", method=RequestMethod.GET)
	public String itemInsertForm(Item item, Model model) {
		model.addAttribute("item", item);
		return "item/insertForm";
	}
	// DB 저장요청
	@RequestMapping(value = "/item/insert", method=RequestMethod.POST)
	public String itemInsert(Item item, Model model) throws Exception {
		MultipartFile file = item.getPicture();
		log.info("원래파일명 : " + file.getOriginalFilename());
		log.info("파일사이즈 : " + file.getSize());
		log.info("컨텐츠타입 : " + file.getContentType());
		
		String createdFileName = uploadFile(file.getOriginalFilename(), file.getBytes());
		item.setPictureUrl(createdFileName);
		boolean result = service.insert(item);
		
		if (!result) return "item/fail";
		else 		 return "item/success";
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
