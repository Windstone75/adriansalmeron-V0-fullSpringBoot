package com.asf.bricotuto.webapp.controlleur;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.asf.bricotuto.webapp.util.WebUtils;

@Controller
public class MenuController {
	@RequestMapping(value = { "/", "/home","/{locale:en|fr|es}/home"}, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("home");
		return model;
	}
	
	@RequestMapping(value = {"/about","/{locale:en|fr|es}/about"}, method = RequestMethod.GET)
	public ModelAndView aboutPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("about");
		return model;
	}

	@RequestMapping(value = {"/member","/{locale:en|fr|es}/member"}, method = RequestMethod.GET)
	public ModelAndView userPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("member/homeMember");
		return model;
	}
	
	@RequestMapping(value = {"/admin","/{locale:en|fr|es}/admin"}, method = RequestMethod.GET)
	public ModelAndView adminPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/homeAdmin");
		return model;
	}
	

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) { 
        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal(); 
            String userInfo = WebUtils.toString(loginedUser); 
           
            String message = "Hello "+principal.getName() //
                    + " : You do not have permission to access this page!";
            model.addAttribute("userInfo", userInfo); 
            model.addAttribute("message", message); 
        } 
        return "403Page";
    }
	

}
