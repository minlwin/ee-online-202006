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
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.jdc.update.entity.Customer;
import com.jdc.update.service.CustomerService;

@TestMethodOrder(OrderAnnotation.class)
class CustomerServiceTest {
	
	static EntityManagerFactory EMF;
	EntityManager em;
	
	// Test Target Class
	CustomerService service;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		EMF = Persistence.createEntityManagerFactory("jpa8");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		EMF.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = EMF.createEntityManager();
		service = new CustomerService(em);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

	@Test
	@Order(1)
	void testForFindAll() {
		List<Customer> list = service.findAll();
		assertNotNull(list);
		assertEquals(24, list.size());
	}
	
	@Test
	@Order(2)
	void testForFindByTownshipName() {
		List<Customer> foundList = service.findByTownshipName("Bago Township");
		assertNotNull(foundList);
		assertEquals(3, foundList.size());
		
		List<Customer> notFoundList = service.findByTownshipName("Taungoo Township");
		assertNotNull(notFoundList);
		assertEquals(0, notFoundList.size());
	}

}
