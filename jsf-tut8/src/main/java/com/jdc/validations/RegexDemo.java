package com.jdc.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

	public static void main(String[] args) {
		String regex = "^(\\d{3}[- .]?){2}\\d{4}$";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher("090 009 91811");
		
		System.out.println(matcher.find());
	}
}
