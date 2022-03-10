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
import com.qa.rbvapes.domains.Customers;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:schema-test.sql",
		"classpath:data-test.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles = "test")
public class CustomerControllerTest {

	@Autowired
	private MockMvc mock;

	@Autowired
	private ObjectMapper map;

	private Long id = 1L;
	private final String URL = "http://localhost:8080/";

	@Test
	public void testCreateCustomer() throws Exception {
		Customers newC = new Customers("Ben", "Address2", "Number2");
		Customers expectedC = new Customers(2L, "Ben", "Address2", "Number2");

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
				.request(HttpMethod.POST, URL + "createCustomer").contentType(MediaType.APPLICATION_JSON)
				.content(map.writeValueAsString(newC)).accept(MediaType.APPLICATION_JSON);

		ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(map.writeValueAsString(expectedC));

		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}

	@Test
	public void testReadAll() throws Exception {
		List<Customers> expected = List.of(new Customers(1L, "Alex", "Address", "Number"));

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET,
				URL + "readAllCustomers");

		ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(map.writeValueAsString(expected));

		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}

	@Test
	public void testReadById() throws Exception {
		Customers expected = new Customers(1L, "Alex", "Address", "Number");

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET,
				URL + "readCustomerById/" + id);

		ResultMatcher matchStatus = MockMvcResultMatchers.status().isFound();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(map.writeValueAsString(expected));

		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}

	@Test
	public void testDelete() throws Exception {
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.DELETE,
				URL + "deleteCustomer/" + id);

		ResultMatcher matchStatus = MockMvcResultMatchers.status().isNoContent();

		this.mock.perform(mockRequest).andExpect(matchStatus);
	}

	@Test
	public void testUpdate() throws Exception {
		Customers updateC = new Customers("Ben", "Address2", "Number2");
		Customers expectedC = new Customers(1L, "Ben", "Address2", "Number2");

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
				.request(HttpMethod.PUT, URL + "updateCustomer/" + id).contentType(MediaType.APPLICATION_JSON)
				.content(map.writeValueAsString(updateC)).accept(MediaType.APPLICATION_JSON);

		ResultMatcher matchStatus = MockMvcResultMatchers.status().isAccepted();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(map.writeValueAsString(expectedC));

		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}
}
