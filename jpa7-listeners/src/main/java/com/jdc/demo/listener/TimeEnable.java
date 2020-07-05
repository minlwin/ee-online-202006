package com.jdc.demo.listener;

import java.io.Serializable;

import com.jdc.demo.entity.TimeInfo;

public interface TimeEnable extends Serializable{

	void setTimes(TimeInfo times);
	
	TimeInfo getTimes();
}
