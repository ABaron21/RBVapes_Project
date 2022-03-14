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
import com.qa.rbvapes.domains.Flavours;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:schema-test.sql",
		"classpath:data-test.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles = "test")
public class FlavourControllerTest {

	@Autowired
	private MockMvc mock;

	@Autowired
	private ObjectMapper map;

	private Long id = 1L;
	private final String URL = "http://localhost:8080/";

	@Test
	public void testCreate() throws Exception {
		Flavours newF = new Flavours("BlueIce", "Elux", 12);
		Flavours expected = new Flavours(2L, "BlueIce", "Elux", 12);

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
				.request(HttpMethod.POST, URL + "createFlavour").contentType(MediaType.APPLICATION_JSON)
				.content(map.writeValueAsString(newF)).accept(MediaType.APPLICATION_JSON);

		ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(map.writeValueAsString(expected));

		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}

	@Test
	public void testReadAll() throws Exception {
		List<Flavours> expected = List.of(new Flavours(1L, "CottonCandy", "AromaKing", 15));

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET,
				URL + "readAllFlavours");

		ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(map.writeValueAsString(expected));

		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);

	}

	@Test
	public void testReadByBrand() throws Exception {
		String name = "AromaKing";
		List<Flavours> expected = List.of(new Flavours(1L, "CottonCandy", "AromaKing", 15));

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET,
				URL + "readFlavoursByBrand/" + name);

		ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(map.writeValueAsString(expected));

		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);

	}

	@Test
	public void testUpdate() throws Exception {
		int newQ = 15;
		Flavours expected = new Flavours(1L, "CottonCandy", "AromaKing", 15);

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
				.request(HttpMethod.PUT, URL + "updateFlavour/" + id).contentType(MediaType.APPLICATION_JSON)
				.content(map.writeValueAsString(newQ)).accept(MediaType.APPLICATION_JSON);

		ResultMatcher matchStatus = MockMvcResultMatchers.status().isAccepted();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(map.writeValueAsString(expected));

		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}

	@Test
	public void testDelete() throws Exception {
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.DELETE,
				URL + "deleteFlavour/" + id);

		ResultMatcher matchStatus = MockMvcResultMatchers.status().isNoContent();

		this.mock.perform(mockRequest).andExpect(matchStatus);

	}
}
