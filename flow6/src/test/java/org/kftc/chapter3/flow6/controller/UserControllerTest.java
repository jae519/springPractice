package org.kftc.chapter3.flow6.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Before;
import org.junit.Test;
import org.kftc.chapter3.flow6.controller.UserController;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


public class UserControllerTest {

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(
				new UserController()).build();
	}

	@Test
	public void basicTest_WithAllValidationErrors() throws Exception {
		System.out.println("before test start");
		this.mockMvc
		.perform(
				post("/create-user")
				.accept(MediaType
						.parseMediaType("application/html;charset=UTF-8")))
						.andExpect(status().isOk())
						.andExpect(model().errorCount(4))
						.andExpect(
						model().attributeHasFieldErrorCode("user", "name",
								"Size"));
		System.out.println("test finised successfully");
	}
	
}
