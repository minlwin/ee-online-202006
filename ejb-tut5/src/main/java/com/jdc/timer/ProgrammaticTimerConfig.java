package com.jdc.timer;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ProgrammaticTimerConfig {

	private TimerId timerInfo;
	
	@EJB
	private ProgrammaticTimer timer;

	@PostConstruct
	private void init() {
		timerInfo = new TimerId();
	}

	public void save() {
		timer.createTimer(timerInfo);
	}
	
	public TimerId getTimerInfo() {
		return timerInfo;
	}

	public void setTimerInfo(TimerId timerInfo) {
		this.timerInfo = timerInfo;
	}
	

}
