package com.jdc.cdi.producers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@ApplicationScoped
public class StateProducer {

	@Produces
	private List<State> states;
	
	@Inject
	private StateService service;

	@PostConstruct
	private void init() {
		states = service.getAll();
	}
}
