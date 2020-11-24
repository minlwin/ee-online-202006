package com.jdc.timer;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class TimerDemoBean {

	@EJB
	private MessageContainer container;
	
	public List<Message> getMessages() {
		return container.getMessages();
	}
}
