package com.jdc.online.shop.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.enterprise.context.Dependent;
import javax.servlet.http.Part;

@Dependent
public class ImageUtils implements Serializable{

	private static final long serialVersionUID = 1L;

	private Part inputFile;

	public Part getInputFile() {
		return inputFile;
	}

	public void setInputFile(Part inputFile) {
		this.inputFile = inputFile;
	}
	
	public InputStream getInputStream() throws IOException {
		
		if(null != inputFile) {
			return inputFile.getInputStream();
		}
		return null;
	}
	
	public String getExtension() {
		
		if(null != inputFile) {
			String fileName = inputFile.getSubmittedFileName();
			String [] array = fileName.split("\\.");
			
			if(array.length > 1) {
				return array[array.length - 1];
			}
		}
		
		return null;
	}

}
