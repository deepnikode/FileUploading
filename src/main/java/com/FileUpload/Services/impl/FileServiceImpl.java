package com.FileUpload.Services.impl;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.FileUpload.Services.FileService;

@Service
public class FileServiceImpl implements FileService 
{

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException  {
		
		
		//File Name
		String name=file.getOriginalFilename();
		System.out.println(name); // IMG_3644.jpeg
		
		//Generating random id for all names inorder to uniqely save all filenames
		//by this users can upload files having same name uniquely
		String randomID=UUID.randomUUID().toString();
		String fileName1=  randomID.concat(name.substring(name.lastIndexOf(".")));
		System.out.println(fileName1);	// 9a152d0d-e879-4cb2-a5c7-de4074956e7c.jpeg	
		
		//Full Path
		String filePath=path+ File.separator + fileName1;
		System.out.println(filePath); // images//9a152d0d-e879-4cb2-a5c7-de4074956e7c.jpeg
		
				
		//Create Folder if not created
		File f=new File(path);
		if(!f.exists())
		{
			f.mkdir();
		}
		
		//File Copy
		Files.copy(file.getInputStream(), Paths.get(filePath));
		
		return name;
	}

	@Override
	public InputStream getResource(String path, String fileName) {
        String fullPath = path + File.separator + fileName;

        InputStream is;
        try {
            is = new FileInputStream(fullPath);

            // DB logic to return InputStream...
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return is;
    }
}
