package com.interview.imanage.stackassess.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.interview.imanage.stackassess.exception.StackEmptyException;
import com.interview.imanage.stackassess.exception.StackOverflowException;
import com.interview.imanage.stackassess.service.impl.StackImpl;

@Import(StackController.class)
@ComponentScan(basePackages = "com")
@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(StackController.class)
public class StackControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	StackImpl stackService;

	@InjectMocks
	private StackController stackController;

	List<Integer> initList = new ArrayList<Integer>();

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(stackController).build();
	}

	@Test
	@Order(1)
	public void testFetchAll() throws Exception {

		Mockito.when(stackService.listAll()).thenReturn(initList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/data");
		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
		String expectedResult = "[]";
		JSONAssert.assertEquals(expectedResult, result.getResponse().getContentAsString(), false);
	}

	@Test
	@Order(2)
	public void testPush() throws Exception {
		try {
			RequestBuilder pushrequestBuilder = MockMvcRequestBuilders.post("/data")
					.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
					.content(new ObjectMapper().writeValueAsString(Integer.valueOf(100)));
			MvcResult resulttest = mockMvc.perform(pushrequestBuilder).andExpect(status().isOk()).andReturn();
			MockHttpServletResponse response = resulttest.getResponse();
			assertEquals(HttpStatus.OK.value(), response.getStatus());

		} catch (StackOverflowException e) {

		}
	}

	@Test
	@Order(3)
	public void testPop() throws Exception {
		try {
			RequestBuilder pushrequestBuilder = MockMvcRequestBuilders.delete("/data")
					.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
			MvcResult resulttest = mockMvc.perform(pushrequestBuilder).andExpect(status().isOk()).andReturn();
			MockHttpServletResponse response = resulttest.getResponse();
			assertEquals(HttpStatus.OK.value(), response.getStatus());

		} catch (StackEmptyException e) {

		}
	}

	@Test
	@Order(4)
	public void testGetStackSize() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/size");
		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
		System.out.println("Res" + result.getResponse().getContentAsString());
		JSONAssert.assertEquals(new ObjectMapper().writeValueAsString(Integer.valueOf(0)),
				result.getResponse().getContentAsString(), false);
	}

	@Test
	@Order(5)
	public void testAlterStackSize() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/size").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(Integer.valueOf(100)));
		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}

}
