package com.jdc.timer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.ScheduleExpression;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

@LocalBean
@Stateless
public class ProgrammaticTimer {

	@Resource
	private TimerService timerService;
	@EJB
	private MessageContainer container;
	
	public void createTimer(TimerId id) {
		ScheduleExpression timer = new ScheduleExpression()
				.hour("*")
				.minute("*")
				.second(String.format("*/%d", id.getInterval()));
		
		id.setCreation(LocalDateTime.now());		
		timerService.createCalendarTimer(timer, new TimerConfig(id, false));
	}
	
	@Timeout
	public void generateMessage(Timer timer) {
		TimerId id = (TimerId) timer.getInfo();
		String creation = id.getCreation().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
		container.add(String.format("Timer Name : %s, Creation : %s", id.getName(), creation));
	}
}
