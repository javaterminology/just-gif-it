package com.raja.justgifit.controller;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {
	
	private final static Logger logger =  LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	@Value("${multipart.location}")
	private String location;
	
	@RequestMapping(value="/upload", 
			method = RequestMethod.POST, 
			produces = MediaType.IMAGE_GIF_VALUE)
	public String upload(@RequestPart("file") MultipartFile file,
			@RequestParam("start") int start,
			@RequestParam("end") int end,
			@RequestParam("speed") int speed,
			@RequestParam("repeat") boolean repeat) {
		
		
		File videoFile = new File(location+"/"+System.currentTimeMillis()+".mp4");
		try {
			file.transferTo(videoFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		logger.info("video file saved to:"+videoFile.getAbsolutePath());
		return "";
	}

}
