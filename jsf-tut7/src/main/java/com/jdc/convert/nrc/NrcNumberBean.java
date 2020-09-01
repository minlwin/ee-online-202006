package com.jdc.convert.nrc;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class NrcNumberBean {

	private NrcNumber nrc;
	
	@PostConstruct
	private void init() {
		nrc = new NrcNumber();
		nrc.setStateCode("12");
		nrc.setCityCode("YKN");
		nrc.setType("N");
		nrc.setRegistNumber(6666);
	}
	
	public NrcNumber getNrc() {
		return nrc;
	}
}
