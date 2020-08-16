package com.jdc.html;

import java.util.List;

public class SelectData {

	// Select One Menu
	private String subject;
	// Select One List Box
	private String interest;
	// Select One Radio
	private Gender gender;
	// Select boolean Check Box
	private boolean selected;

	private List<String> list1;
	private List<String> list2;
	private List<String> list3;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public List<String> getList1() {
		return list1;
	}

	public void setList1(List<String> list1) {
		this.list1 = list1;
	}

	public List<String> getList2() {
		return list2;
	}

	public void setList2(List<String> list2) {
		this.list2 = list2;
	}

	public List<String> getList3() {
		return list3;
	}

	public void setList3(List<String> list3) {
		this.list3 = list3;
	}

	public enum Gender {
		Male, Female
	}
}
