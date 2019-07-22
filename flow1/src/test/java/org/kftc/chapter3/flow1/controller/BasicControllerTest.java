package org.kftc.chapter3.flow1.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.kftc.chapter3.flow1.controller.BasicController;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class BasicControllerTest {
	private MockMvc mockMvc;
	
	@Before
	public void setup()
	{
		this.mockMvc = MockMvcBuilders.standaloneSetup(
				new BasicController()
				).build();
		System.out.println("before");
	}
	
	@Test
	public void basicTest() throws Exception
	{
		System.out.println("test");
		this.mockMvc
		.perform(
				get("/welcome")
				.accept(MediaType.parseMediaType("application/html;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/html;charset=UTF-8"))
				.andExpect(content().string("Welcome to Spring MVC"));
		System.out.println("test done (if test fails, this line does not be executed.");
				
	}
	
}
