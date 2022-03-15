package com.qa.rbvapes.controllers;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.rbvapes.domains.OrderInfo;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:schema-test.sql",
		"classpath:data-test.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles = "test")
public class OrderInfoControllerTest {

	@Autowired
	private MockMvc mock;

	@Autowired
	private ObjectMapper map;

	private Long id = 1L;
	private final String URL = "http://localhost:8080/";
	private LocalDate date = LocalDate.now();
	private LocalDate dateD = date.plus(3, ChronoUnit.DAYS);

	@Test
	public void testCreate() throws Exception {
		OrderInfo newInfo = new OrderInfo(1L, 1L, date, dateD);
		OrderInfo expected = new OrderInfo(2L, 1L, 1L, date, dateD);

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
				.request(HttpMethod.POST, URL + "createOrderInfo").contentType(MediaType.APPLICATION_JSON)
				.content(map.writeValueAsString(newInfo)).accept(MediaType.APPLICATION_JSON);

		ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(map.writeValueAsString(expected));

		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);

	}

	@Test
	public void testReadAll() throws Exception {
		List<OrderInfo> expected = List.of(new OrderInfo(id, 1L, 1L, date, dateD));

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET, URL + "readAllInfo");

		ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(map.writeValueAsString(expected));

		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}

	@Test
	public void testReadByDelivery() throws Exception {
		String dateExpect = "2022-03-18";
		List<OrderInfo> expected = List.of(new OrderInfo(id, 1L, 1L, date, dateD));

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET,
				URL + "readByDelivery/" + dateExpect);

		ResultMatcher matchStatus = MockMvcResultMatchers.status().isFound();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(map.writeValueAsString(expected));

		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}

	@Test
	public void testReadByDatePlaced() throws Exception {
		String datePlaced = "2022-03-15";
		List<OrderInfo> expected = List.of(new OrderInfo(id, 1L, 1L, date, dateD));

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET,
				URL + "readByDatePlaced/" + datePlaced);

		ResultMatcher matchStatus = MockMvcResultMatchers.status().isFound();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(map.writeValueAsString(expected));

		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}

	@Test
	public void testUpdate() throws Exception {
		OrderInfo newInfo = new OrderInfo(1L, 1L, date, dateD);
		OrderInfo expected = new OrderInfo(1L, 1L, 1L, date, dateD);

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
				.request(HttpMethod.PUT, URL + "updateInfo/" + id).contentType(MediaType.APPLICATION_JSON)
				.content(map.writeValueAsString(newInfo)).accept(MediaType.APPLICATION_JSON);

		ResultMatcher matchStatus = MockMvcResultMatchers.status().isAccepted();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(map.writeValueAsString(expected));

		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}

	@Test
	public void testDelete() throws Exception {
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.DELETE,
				URL + "deleteInfo/" + id);

		ResultMatcher matchStatus = MockMvcResultMatchers.status().isNoContent();

		this.mock.perform(mockRequest).andExpect(matchStatus);
	}
}
