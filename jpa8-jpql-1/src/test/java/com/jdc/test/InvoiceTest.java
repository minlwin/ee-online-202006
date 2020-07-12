package com.jdc.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jdc.update.entity.Invoice;
import com.jdc.update.service.InvoiceService;
import com.jdc.update.service.dto.DailyInvoiceDTO;
import com.jdc.update.service.dto.DailyInvoiceSummary;

class InvoiceTest {
	
	private InvoiceService service;
	private EntityManager em;
	private static EntityManagerFactory EMF;

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
		service = new InvoiceService(em);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

	@Test
	void testForAverage() {
		
		assertEquals(246667, service.getAverage(LocalDate.of(2020, 7, 10)));
		assertEquals(1727500, service.getAverage(LocalDate.of(2020, 7, 15)));
		assertEquals(866667, service.getAverage(LocalDate.of(2020, 8, 1)));
		assertEquals(0, service.getAverage(LocalDate.of(2020, 7, 1)));
		
	}
	
	@Test
	void testForSum() {
		assertEquals(740000, service.getTotal(LocalDate.of(2020, 7, 10)));
		assertEquals(6910000, service.getTotal(LocalDate.of(2020, 7, 15)));
		assertEquals(5200000, service.getTotal(LocalDate.of(2020, 8, 1)));
		assertEquals(0, service.getAverage(LocalDate.of(2020, 7, 1)));
	}

	@Test
	void testForMin() {
		assertEquals(180000, service.getMinForDay(LocalDate.of(2020, 7, 10)));
		assertEquals(150000, service.getMinForDay(LocalDate.of(2020, 7, 15)));
		assertEquals(100000, service.getMinForDay(LocalDate.of(2020, 8, 1)));
		assertEquals(0, service.getMinForDay(LocalDate.of(2020, 7, 1)));
	}

	@Test
	void testForMax() {
		assertEquals(350000, service.getMaxForDay(LocalDate.of(2020, 7, 10)));
		assertEquals(5300000, service.getMaxForDay(LocalDate.of(2020, 7, 15)));
		assertEquals(3000000, service.getMaxForDay(LocalDate.of(2020, 8, 1)));
		assertEquals(0, service.getMaxForDay(LocalDate.of(2020, 7, 1)));
	}
	
	@Test
	void testForBetween() {
		assertEquals(7, service.searchByInvoiceDate(LocalDate.of(2020, 7, 10), LocalDate.of(2020, 7, 15)).size());
	}
	
	@Test
	void testForIn() {
		
		List<String> townships = Arrays.asList("Bago Township", "Kawa Township");
		LocalDate paidDate = LocalDate.of(2020, 7, 30);
		
		assertEquals(4, service.searchByTownships(townships, paidDate).size());
	}
	
	@Test
	void testForSubQuery() {
		List<Invoice> result = service.searchMaxInvoice();
		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(5300000, result.get(0).getPaidAmount());
	}
	
	@Test
	void testForGroupBy() {
		List<DailyInvoiceDTO> result = service.searchDailyInvoices(LocalDate.of(2020, 7, 10));
		assertNotNull(result);
		assertEquals(1, result.size());
		
		DailyInvoiceDTO dto = result.get(0);
		assertNotNull(dto);
		assertEquals(3, dto.getInvoices());
		assertEquals(740000, dto.getTotal());
	}
	
	@Test
	void testForHomeWork() {
		LocalDate from = LocalDate.of(2020, 7, 1);
		LocalDate to = LocalDate.of(2020, 7, 30);
		
		List<DailyInvoiceSummary> list = service.getSummary(from, to);
		assertNotNull(list);
		assertEquals(2, list.size());
		
		DailyInvoiceSummary data1 = list.get(0);
		assertEquals(from.withDayOfMonth(10), data1.getInvoiceDate());
		
		
		DailyInvoiceSummary data2 = list.get(1);
		assertEquals(from.withDayOfMonth(15), data2.getInvoiceDate());
		
	}
}
