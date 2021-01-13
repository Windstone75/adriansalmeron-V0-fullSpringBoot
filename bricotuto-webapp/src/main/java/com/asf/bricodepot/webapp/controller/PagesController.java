package com.asf.bricodepot.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asf.formationtuto.model.bean.User.User;

@Controller
public class PagesController {
	@GetMapping("/")
	public String home(@RequestParam(defaultValue = "Inconnu") String name,ModelMap modelMap) {
		User user = new User();
		user.setLogin("test");
		
				modelMap.put("name",user.getLogin());
		
				
		return "pages/home";
	}

}
