package com.jdc.demo.listener;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.jdc.demo.entity.TimeInfo;

public class TimesListner {
	
	@PrePersist
	public void prePersist(Object entity) {
		
		if(entity instanceof TimeEnable) {
			TimeEnable data = (TimeEnable) entity;
			TimeInfo times = data.getTimes();
			if(null == times) {
				times = new TimeInfo();
				data.setTimes(times);
			}
			
			times.setCreateAt(LocalDateTime.now());
		}
		
	}

	@PreUpdate
	public void preUpdate(Object entity) {
		
		if(entity instanceof TimeEnable) {
			((TimeEnable)entity).getTimes().setUpdateAt(LocalDateTime.now());
		}
	}
}
