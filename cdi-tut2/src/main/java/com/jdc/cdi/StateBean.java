package com.jdc.cdi;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.cdi.producers.State;

@Named
@RequestScoped
public class StateBean {

	@Inject
	private List<State> states;
	
	public List<State> getStates() {
		return states;
	}
}
