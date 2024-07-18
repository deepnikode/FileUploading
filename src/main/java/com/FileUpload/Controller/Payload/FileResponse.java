package com.FileUpload.Controller.Payload;

public class FileResponse 
{
	private String FileName;
	private String message;
	
	//Constructor
	public FileResponse(String fileName, String message) {
		super();
		FileName = fileName;
		this.message = message;
	}
	
	//Getters & Setters
	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

	
}
