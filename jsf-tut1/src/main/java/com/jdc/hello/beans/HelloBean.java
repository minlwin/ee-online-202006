package com.jdc.hello.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.jdc.hello.beans.model.Member;

@Named
@ViewScoped
public class HelloBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Member member;
	private List<Member> list;

	@PostConstruct
	public void init() {
		member = new Member();
		list = new ArrayList<>();
	}
	
	public void save() {
		list.add(member);
		member = new Member();
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public List<Member> getList() {
		return list;
	}

	public void setList(List<Member> list) {
		this.list = list;
	}

}
