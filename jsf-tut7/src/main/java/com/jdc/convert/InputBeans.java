package com.jdc.convert;

import java.math.BigInteger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class InputBeans {

	private BigInteger data;

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

	public BigInteger getData() {
		return data;
	}

	public void setData(BigInteger data) {
		this.data = data;
	}

}
