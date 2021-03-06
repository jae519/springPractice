package org.kftc.chapter3.flow3.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.kftc.chapter3.flow3.controller.BasicModelMapController;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

public class BasicModelMapControllerTest {
	private MockMvc mockMvc;
	
	@Before
	public void setup()
	{
		this.mockMvc = MockMvcBuilders.standaloneSetup(
				new BasicModelMapController()
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
	public void testWelcomModelMap() throws Exception
	{
		System.out.println("test");
		this.mockMvc
		.perform(
				get("/welcome-model-map")
						.accept(MediaType
								.parseMediaType("application/html;charset=UTF-8")))
		.andExpect(model().attribute("name", "XYZ"))
		.andExpect(view().name("welcome-model-map"));
		System.out.println("test done (if test fails, this line does not be executed.");
				
	}
	
}
