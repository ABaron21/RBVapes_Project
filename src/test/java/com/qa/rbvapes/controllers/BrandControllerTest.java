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
import com.qa.rbvapes.domains.Brands;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:schema-test.sql",
		"classpath:data-test.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles = "test")
public class BrandControllerTest {

	@Autowired
	private MockMvc mock;

	@Autowired
	private ObjectMapper map;

	private int id = 1;
	private final String URL = "http://localhost:8080/";

	@Test
	public void testCreate() throws Exception {
		Brands newB = new Brands("Elux", 3000, 10.00);
		Brands expected = new Brands(2, "Elux", 3000, 10.00);

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST, URL + "createBrand")
				.contentType(MediaType.APPLICATION_JSON).content(map.writeValueAsString(newB))
				.accept(MediaType.APPLICATION_JSON);

		ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(map.writeValueAsString(expected));

		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);

	}

	@Test
	public void testReadAll() throws Exception {
		List<Brands> expected = List.of(new Brands(id, "AromaKing", 7000, 15.00));

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET,
				URL + "readAllBrands");

		ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(map.writeValueAsString(expected));

		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);

	}

	@Test
	public void testReadByBrandName() throws Exception {
		String name = "AromaKing";
		Brands expected = new Brands(id, "AromaKing", 7000, 15.00);

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET,
				URL + "readByBrandName/" + name);

		ResultMatcher matchStatus = MockMvcResultMatchers.status().isFound();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(map.writeValueAsString(expected));

		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);

	}

	@Test
	public void testUpdate() throws Exception {
		Brands newB = new Brands("Elux", 3000, 10.00);
		Brands expected = new Brands(1, "Elux", 3000, 10.00);

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
				.request(HttpMethod.PUT, URL + "updateBrand/" + id).contentType(MediaType.APPLICATION_JSON)
				.content(map.writeValueAsString(newB)).accept(MediaType.APPLICATION_JSON);

		ResultMatcher matchStatus = MockMvcResultMatchers.status().isAccepted();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(map.writeValueAsString(expected));

		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}

	@Test
	public void testDelete() throws Exception {
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.DELETE,
				URL + "deleteBrand/" + id);

		ResultMatcher matchStatus = MockMvcResultMatchers.status().isNoContent();

		this.mock.perform(mockRequest).andExpect(matchStatus);

	}
}
