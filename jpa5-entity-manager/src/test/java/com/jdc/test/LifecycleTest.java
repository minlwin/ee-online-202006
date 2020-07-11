package com.jdc.test;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jdc.em.entity.Course;

class LifecycleTest {

	static EntityManagerFactory EMF;
	EntityManager em;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		EMF = Persistence.createEntityManagerFactory("jpa5");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		EMF.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = EMF.createEntityManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

	@Test
	void test() {
		
		Course c = new Course();
		c.setName("Java SE");
		
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		
		em.detach(c);
		System.out.println(em.contains(c));
		
		em.getTransaction().begin();
		c = em.merge(c);
		em.getTransaction().commit();
		System.out.println(em.contains(c));
	}

}
