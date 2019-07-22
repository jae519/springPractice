package org.kftc.chapter3.flow6.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kftc.chapter3.flow6.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	private Log logger = LogFactory.getLog(UserController.class);

	@RequestMapping(value = "/create-user", method = RequestMethod.GET)
	public String showCreateUserPage(ModelMap model) {
		model.addAttribute("user", new User());
		return "user";
	}

	@RequestMapping(value = "/create-user", method = RequestMethod.POST)
	public String addTodo(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "user";
		}

		logger.info("user details " + user);
		return "redirect:list-users";
	}
	@RequestMapping(value = "/list-users", method = RequestMethod.GET)
	public String showAllUsers() {
		return "list-users";
	}
	
}
