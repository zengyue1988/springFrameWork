package com.moon.springBoot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.moon.springBoot.controller.GreetingController;

@RunWith(SpringJUnit4ClassRunner.class)
public class ApplicationTests {
	
	private MockMvc mvc;
	
	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new GreetingController()).build();
	}
	
	@Test
	public void test() throws Exception {
		ResultActions result = mvc.perform(MockMvcRequestBuilders.get("/greeting").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		System.out.println(result.andReturn().getResponse().getContentAsString());
	}
}
