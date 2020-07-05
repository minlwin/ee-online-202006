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

import com.jdc.demo.entity.Room;
import com.jdc.demo.entity.Room.Type;
import com.jdc.demo.service.RoomService;

@TestMethodOrder(OrderAnnotation.class)
class RoomServiceTest {
	
	RoomService service;
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
		service = new RoomService(em);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

	@Test
	@Order(1)
	void testForCreateAt() {
		Room room = new Room();
		room.setNumer("101");
		service.save(room);
		
		assertEquals(1, room.getId());
		assertNotNull(room.getTimes().getCreateAt());
		assertNull(room.getTimes().getUpdateAt());
	}

	@Test
	@Order(2)
	void testForUpdateAt() {
		Room room = service.findById(1);
		assertNotNull(room);
		
		room.setType(Type.Single);
		service.save(room);
		
		assertNotNull(room.getTimes().getUpdateAt());
	}
}
