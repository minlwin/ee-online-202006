package com.jdc.html;

import javax.enterprise.inject.Model;

@Model
public class InputBeans {

	private InputData data = new InputData();

	public InputData getData() {
		return data;
	}

	public void setData(InputData data) {
		this.data = data;
	}

}
