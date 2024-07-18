package com.FileUpload.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.FileUpload.Controller.Payload.FileResponse;
import com.FileUpload.Services.FileService;

@RestController
@RequestMapping("/file")
public class FileController 
{
	@Autowired
	private FileService fileService;
	
	// in order to get the property_value from application.properties file
	@Value("${project.image}")
	private String path;
	
	@PostMapping("/upload")
	public ResponseEntity<FileResponse> fileUpload(@RequestParam("image")MultipartFile image)
	{
		String fileName;
		try 
		{
			fileName = this.fileService.uploadImage(path, image);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(new FileResponse(null, "File not uploaded due to some Error"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		return new ResponseEntity<>(new FileResponse(fileName, "File is successfully uploaded"),HttpStatus.OK);
	}
}