package com.asf.bricotuto.webapp.failurehandler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobaleFailureHandler {

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAnyException(HttpServletRequest request, Exception e) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/error/404");
		return modelAndView;
	}
}
