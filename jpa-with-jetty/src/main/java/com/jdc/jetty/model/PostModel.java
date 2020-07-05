package com.jdc.jetty.model;

import java.util.List;

import javax.persistence.EntityManager;

import com.jdc.jetty.model.entity.Post;

public class PostModel {
	
	private EntityManager em;

	public PostModel(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void save(Post p) {
		
		em.getTransaction().begin();
		
		if(p.getId() == 0) {
			em.persist(p); 
		} else  {
			em.merge(p);
		}
		
		em.getTransaction().commit();
	}
	
	public List<Post> findAll() {
		return em.createNamedQuery("Post.findAll", Post.class).getResultList();
	}

	public void terminate() {

		if(null != em && em.isOpen()) {
			em.close();
		}
	}

}
