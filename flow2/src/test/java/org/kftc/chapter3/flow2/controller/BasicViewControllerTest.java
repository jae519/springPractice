package org.kftc.chapter3.flow2.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.kftc.chapter3.flow2.controller.BasicViewController;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

public class BasicViewControllerTest {
	private MockMvc mockMvc;
	
	@Before
	public void setup()
	{
		this.mockMvc = MockMvcBuilders.standaloneSetup(
				new BasicViewController()
				).setViewResolvers(viewResolver()).build();
		System.out.println("before");
	}
	
	private ViewResolver viewResolver()
	{
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/jsp");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
		
	}
	
	@Test
	public void testWelcomView() throws Exception
	{
		System.out.println("test");
		this.mockMvc
		.perform(
				get("/welcome-view")
				.accept(MediaType.parseMediaType("application/html;charset=UTF-8")))
				.andExpect(view().name("welcome"));
		System.out.println("test done (if test fails, this line does not be executed.");
				
	}
	
}
