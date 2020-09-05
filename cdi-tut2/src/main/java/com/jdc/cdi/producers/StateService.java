package com.jdc.cdi.producers;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@LocalBean
@Stateless
public class StateService {

	@PersistenceContext
	private EntityManager em;
	
	public List<State> getAll() {
		return em.createNamedQuery("State.getAll", State.class).getResultList();
	}
}
