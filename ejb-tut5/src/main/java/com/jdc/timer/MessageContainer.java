package com.jdc.timer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@LocalBean
@Singleton
@Startup
public class MessageContainer {
	
	private List<Message> messages;
	
	@PostConstruct
	private void init() {
		messages = new ArrayList<>();
	}
	
	public List<Message> getMessages() {
		return messages;
	}
	
	public void add(String message) {
		Message m = new Message();
		m.setId(messages.size() + 1);
		m.setMessage(message);
		m.setTime(LocalDateTime.now());
		messages.add(m);
	}

}
