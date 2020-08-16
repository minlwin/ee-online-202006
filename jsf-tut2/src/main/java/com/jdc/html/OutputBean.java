package com.jdc.html;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class OutputBean {

	private String str1 = "Label from Model";
	private String str2 = "Text from Model";
	private String str3 = "Go To Home";
	private String index = "index.xhtml";
	private String str4 = "Fromat from Model : {0}";
	private String value = "Java EE";

	public String getStr1() {
		return str1;
	}

	public String getStr2() {
		return str2;
	}

	public String getStr3() {
		return str3;
	}

	public String getIndex() {
		return index;
	}

	public String getStr4() {
		return str4;
	}

	public String getValue() {
		return value;
	}

}
