package com.qa.rbvapes.controllers;

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
import com.qa.rbvapes.domains.Orders;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:schema-test.sql",
		"classpath:data-test.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles = "test")
public class OrderControllerTest {

	@Autowired
	private MockMvc mock;

	@Autowired
	private ObjectMapper map;

	private Long id = 1L;
	private final String URL = "http://localhost:8080/";

	@Test
	public void testCreate() throws Exception {
		Orders newO = new Orders(1, 1L, 1, 15.00);
		Orders expected = new Orders(2L, 1, "AromaKing", 1L, "CottonCandy", 1, 15.00);

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST, URL + "createOrder")
				.contentType(MediaType.APPLICATION_JSON).content(map.writeValueAsString(newO))
				.accept(MediaType.APPLICATION_JSON);

		ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(map.writeValueAsString(expected));

		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}

	@Test
	public void testReadAll() throws Exception {
		List<Orders> expected = List.of(new Orders(1L, 1, "AromaKing", 1L, "CottonCandy", 2, 30.00));

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET,
				URL + "readAllOrders");

		ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(map.writeValueAsString(expected));

		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}

	@Test
	public void testReadById() throws Exception {
		Orders expected = new Orders(1L, 1, "AromaKing", 1L, "CottonCandy", 2, 30.00);

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET,
				URL + "readOrderById/" + id);

		ResultMatcher matchStatus = MockMvcResultMatchers.status().isFound();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(map.writeValueAsString(expected));

		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}

	@Test
	public void testUpdate() throws Exception {
		Orders newO = new Orders(1, 1L, 1, 15.00);
		Orders expected = new Orders(1L, 1, "AromaKing", 1L, "CottonCandy", 1, 15.00);

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
				.request(HttpMethod.PUT, URL + "updateOrder/" + id).contentType(MediaType.APPLICATION_JSON)
				.content(map.writeValueAsString(newO)).accept(MediaType.APPLICATION_JSON);

		ResultMatcher matchStatus = MockMvcResultMatchers.status().isAccepted();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(map.writeValueAsString(expected));

		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}

	@Test
	public void testDelete() throws Exception {
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.DELETE,
				URL + "deleteOrder/" + id);

		ResultMatcher matchStatus = MockMvcResultMatchers.status().isNoContent();

		this.mock.perform(mockRequest).andExpect(matchStatus);
	}
}
