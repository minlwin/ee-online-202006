package com.jdc.test;

import static org.junit.jupiter.api.Assertions.*;

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

import com.jdc.demo.entity.Customer;
import com.jdc.demo.service.CustomerService;

@TestMethodOrder(OrderAnnotation.class)
class CustomerServiceTest {
	
	CustomerService service;
	EntityManager em;
	static EntityManagerFactory EMF;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		EMF = Persistence.createEntityManagerFactory("jpa7");
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
	void testForCreatAt() {
		Customer cust = new Customer();
		cust.setName("Aung Aung");
		service.save(cust);
		
		assertEquals(1, cust.getId());
		assertNotNull(cust.getCreateAt());
		assertNull(cust.getUpdateAt());
	}
	
	@Test
	@Order(2)
	void testForUpdateAt() {
		
		Customer cust = service.findById(1);
		assertNotNull(cust);
		
		cust.setPhone("0987678886");
		service.save(cust);
		
		assertNotNull(cust.getUpdateAt());
	}

}
