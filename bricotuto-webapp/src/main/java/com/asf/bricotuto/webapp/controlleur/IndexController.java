package com.asf.bricotuto.webapp.controlleur;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

	@Controller
	public class IndexController {
		
		@GetMapping("/")
		public String goToIndex(Model model, @RequestParam(value="name", required=false, defaultValue="")String name) {
			 model.addAttribute("name", name);
			System.out.println("Verif passage au sein du controller");
			return "index";
		}
		
	}


