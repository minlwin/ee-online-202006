package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.jdc.cascade.Course;
import com.jdc.cascade.Lessons;

@TestMethodOrder(OrderAnnotation.class)
class CascadeTest {
	
	static EntityManagerFactory EMF;
	EntityManager em;

	/**
	 * Cascade Persist
	 */
	@Test
	@Order(1)
	void testForCascadePersist() {
		
		em.getTransaction().begin();
		
		// create course Java SE
		Course c = new Course();
		c.setName("Java SE");
		c.setFees(200000);
		
		// create Lessons Language Fundamentals, OOP, API, Database, JavaFX
		Lessons fundamental = new Lessons();
		fundamental.setTitle("Language Fundamentals");
		
		// add lesson to course
		c.addLesson(fundamental);
		
		em.persist(c);
		
		em.getTransaction().commit();
		
		assertEquals(1, c.getId());
		assertEquals(1, fundamental.getId());
	}
	
	/**
	 * Cascade Merge
	 */
	@Test
	@Order(2)
	public void testForCascadeMerge() {
		
		Course c = em.find(Course.class, 1);
		Lessons l = c.getLessons().get(0);
		
		em.clear(); // detach
		
		// Add New Lesson to Course
		Lessons oop  = new Lessons();
		oop.setTitle("OOP");
		c.addLesson(oop);
		
		c.setFees(180000);
		l.getLetcures().add("Class and Object");
		l.getLetcures().add("Variables");
		
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
		
		Lessons l2 = em.find(Lessons.class, 2);
		assertNotNull(l2);
		assertEquals("OOP", l2.getTitle());
	}
	
	@Test
	@Order(4)
	public void testForOrphanRemoval() {
		
		em.getTransaction().begin();
		
		Lessons oop = em.find(Lessons.class, 2);

		em.remove(oop.getCourse());
		
		em.getTransaction().commit();
		em.clear();
		
		Lessons l = em.find(Lessons.class, 2);
		assertNull(l);
	}
	
	@Order(3)
	@Test
	void testForRemoveMethod() {
		
		em.getTransaction().begin();
		
		Course c = em.find(Course.class, 1);
		
		Lessons l = c.getLessons().get(0);
		c.remove(l);
		em.remove(l);
		
		em.getTransaction().commit();
		
		assertNull(em.find(Lessons.class, 1));
	}
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		EMF = Persistence.createEntityManagerFactory("jpa6");
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
