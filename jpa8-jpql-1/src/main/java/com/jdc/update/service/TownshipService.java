package com.jdc.update.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.jdc.update.service.dto.TownshipDTO;

public class TownshipService {

	private EntityManager em;

	public TownshipService(EntityManager em) {
		super();
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> searchForObjectArray() {
		
		String jpql = "select t.id, t.name, t.division.name from Township t";
		return em.createQuery(jpql).getResultList();
	}

	public List<TownshipDTO> searchForDTO() {
		String jpql = "select new com.jdc.update.service.dto.TownshipDTO(t.id, t.name, t.division.name) from Township t";
		return em.createQuery(jpql, TownshipDTO.class).getResultList();
	}
	
	public List<TownshipDTO> searchForDTO2() {
		String jpql = "select new com.jdc.update.service.dto.TownshipDTO(t) from Township t";
		return em.createQuery(jpql, TownshipDTO.class).getResultList();
	}

	public long getAllCount() {
		String jqpl = "select count(t) from Township t";
		return em.createQuery(jqpl, Long.class).getSingleResult();
	}

	public List<String> getDistinctDivision() {
		String jqpl = "select distinct t.division.name from Township t";
		return em.createQuery(jqpl, String.class).getResultList();
	}
	
	
	
}
