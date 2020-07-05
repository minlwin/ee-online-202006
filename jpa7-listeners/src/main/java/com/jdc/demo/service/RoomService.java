package com.jdc.demo.service;

import javax.persistence.EntityManager;

import com.jdc.demo.entity.Room;

public class RoomService {

	private EntityManager em;

	public RoomService(EntityManager em) {
		super();
		this.em = em;
	}
	
	public Room findById(int id) {
		return em.find(Room.class, id);
	}
	
	public void save(Room room) {
		em.getTransaction().begin();
		
		if(room.getId() == 0) {
			em.persist(room);
		} else {
			em.merge(room);
		}
		
		em.getTransaction().commit();
	}
}
