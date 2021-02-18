package com.asf.bricotuto.webapp.controlleur;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuHeaderController {
	/**
	 * Show homePage
	 * @return ModelAndView
	 */
	@RequestMapping(value = { "/", "/home", "/{locale:en|fr|es}/home" }, method = RequestMethod.GET)
	public ModelAndView showHomePage() {
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("/home");
		return modelView;
	}
	
	/**
	 * Show about homepage
	 * @return ModelAndView
	 */
	@RequestMapping(value = { "/about", "/{locale:en|fr|es}/about" }, method = RequestMethod.GET)
	public ModelAndView showAboutHomePage() {
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("/about/homeAbout");
		return modelView;
	}

	/**
	 * Show member homepage
	 * @return ModelAndView
	 */
	@RequestMapping(value = { "/member", "/{locale:en|fr|es}/member" }, method = RequestMethod.GET)
	public ModelAndView showMemberHomePage() {
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("/member/homeMember");
		return modelView;
	}

	/**
	 * Show admin homepage 
	 * @return ModelAndView
	 */
	@RequestMapping(value = { "/admin", "/{locale:en|fr|es}/admin" }, method = RequestMethod.GET)
	public ModelAndView showAdminHomepage() {
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("/admin/homeAdmin");
		return modelView;
	}

	/**
	 * Show 403 Page
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accessDenied() {	
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("/error/403");
		return modelView;
	}	

}
