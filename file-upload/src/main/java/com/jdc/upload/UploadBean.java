package com.jdc.upload;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

@Named
@ViewScoped
public class UploadBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Part file;
	private List<Division> list = new ArrayList<>();
	
	public void upload() {
		
		if(null == file) {
			// error message
			FacesContext.getCurrentInstance()
				.addMessage(null, new FacesMessage("Please select file."));
			return;
		}
		
		String line = null;
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))){
			
			list = new ArrayList<>();

			while(null != (line = br.readLine())) {
				Division d = new Division();
				d.setName(line);
				list.add(d);
				d.setId(list.size());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public List<Division> getList() {
		return list;
	}

}
