package com.jdc.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jdc.em.entity.Course;

class FetchModeTest {
	
	static EntityManagerFactory EMF;
	EntityManager em;
	
	@Test
	void test1() {
		Course c = new Course();
		// eager mode
		c.setName("Java SE");
		
		// lazy attribute
		c.getTags().add("Language Fundamentals");
		c.getTags().add("OOP");
		c.getTags().add("Essential Java API");
		c.getTags().add("Java FX");
		c.getTags().add("JDBC API");
		
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		
	}
	
	/**
	 * Check Fetch Modes
	 */
	@Test
	void test2() {
		
		Course c = em.find(Course.class, 1);
		em.clear();
		
		// eager mode
		System.out.println(c.getName());
		
//		// lazy mode 
//		List<String> tags = c.getTags();
//		for(String str : tags) {
//			System.out.println(str);
//		}
		
	}
	
	/**
	 * Differences between find and getReference method
	 */
	@Test
	void test3() {
		// default select
		Course c = em.getReference(Course.class, 1);
//		em.clear(); // detach c
		
		// eager mode
		System.out.println(c.getName());
		
		// lazy mode 
		List<String> tags = c.getTags();
		for(String str : tags) {
			System.out.println(str);
		}
		
		
		// no result
		Course c1 = em.find(Course.class, 2);
		assertNull(c1);

		Course c2 = em.getReference(Course.class, 2);
//		assertNull(c2);
	}

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



}
