package com.jdc.convert;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class InputBeans {

	private Category inputTextCategory;
	private Category selectOneCategory;

	public Category getInputTextCategory() {
		return inputTextCategory;
	}

	public void setInputTextCategory(Category inputTextCategory) {
		this.inputTextCategory = inputTextCategory;
	}

	public Category getSelectOneCategory() {
		return selectOneCategory;
	}

	public void setSelectOneCategory(Category selectOneCategory) {
		this.selectOneCategory = selectOneCategory;
	}

}
