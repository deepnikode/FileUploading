package com.FileUpload.Services;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FileService {
	
	//Declaring Methods
	String uploadImage(String path, MultipartFile file) throws IOException;
	InputStream getResource(String path, String fileName);

}
