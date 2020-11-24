package com.jdc.timer;

import java.util.concurrent.ThreadLocalRandom;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

@LocalBean
@Stateless
public class RandomMessageTimer {

	@EJB
	private MessageContainer container;
	
	@Schedule(hour = "*", minute = "*", second = "30/5")
	public void generateMessage() {
		ThreadLocalRandom random = ThreadLocalRandom.current();
		int d1 = random.nextInt(100);
		int d2 = random.nextInt(100);
		
		String message = String.format("%d + %d = %d", d1, d2, (d1 + d2));
		container.add(message);
	}
}
