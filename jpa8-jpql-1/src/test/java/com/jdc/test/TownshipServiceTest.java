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
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.jdc.update.service.TownshipService;
import com.jdc.update.service.dto.TownshipDTO;

@TestMethodOrder(OrderAnnotation.class)
class TownshipServiceTest {
	
	private TownshipService service;
	private static EntityManagerFactory EMF;
	private EntityManager em;

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
		service = new TownshipService(em);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

	@Test
	@Order(1)
	void testForObjectArry() {
		
		List<Object[]> result = service.searchForObjectArray();
		assertEquals(37, result.size());
	}
	
	@Test
	@Order(2)
	void testForNewOperator() {
		List<TownshipDTO> result = service.searchForDTO();
		assertEquals(37, result.size());
	}

	@Test
	@Order(3)
	void testForNewOperator2() {
		List<TownshipDTO> result = service.searchForDTO2();
		assertEquals(37, result.size());
	}

	@Test
	@Order(4)
	void testForCount() {
		long count = service.getAllCount();
		assertEquals(37, count);
	}
	
	@Test
	@Order(5)
	void testForDistinct() {
		List<String> divisions = service.getDistinctDivision();
		assertEquals(2, divisions.size());
	}
	
}
