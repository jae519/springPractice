package org.kftc.chapter3.flow3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasicModelMapController {
	@RequestMapping(value = "/welcome-model-map")
	public String welcome(ModelMap model)
	{
		model.put("name", "XYZ");
		return "welcome-model-map";
	
	}
}
