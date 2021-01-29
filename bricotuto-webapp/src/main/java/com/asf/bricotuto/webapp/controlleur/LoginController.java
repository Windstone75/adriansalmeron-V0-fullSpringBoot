package com.asf.bricotuto.webapp.controlleur;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.asf.bricotuto.model.bean.User.AppUser;
import com.asf.bricotuto.model.bean.User.ConfirmationToken;
import com.asf.bricotuto.model.exception.UserAlreadyExistException;
import com.asf.bricotuto.webapp.service.mail.EmailService;
import com.asf.bricotuto.webapp.service.user.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private EmailService emailService;

	/**
	 * Page login
	 * 
	 * @param error
	 * @param logout
	 * @return
	 */
	@RequestMapping(value = { "/{locale:en|fr|es}/login", "/login" }, method = RequestMethod.GET)
	public ModelAndView loginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid Password or email");
		}
		model.setViewName("login");
		return model;
	}

	/**
	 * page registration User
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/{locale:en|fr|es}/signup", "/signup" }, method = RequestMethod.GET)
	public String showRegistrationUser(Model model) {
		AppUser user = new AppUser();
		model.addAttribute("user", user);

		return "signup";
	}

	@RequestMapping(value = { "/{locale:en|fr|es}/signup", "/signup" }, method = RequestMethod.POST)
	public String registerUserAccount(@ModelAttribute("user") @Validated AppUser user, BindingResult result,
			Model model, HttpServletRequest request) {
		try {
			// Global Errors User Login
			if (result.hasErrors()) {
				for (int i = 0; i < result.getGlobalErrors().size(); i++) {
					ObjectError errorglobal = result.getGlobalErrors().get(i);
					// error PasswordMatches
					if (errorglobal.getCode().contentEquals("PasswordMatches")) {
						model.addAttribute("errorPasswordMatches", errorglobal.getDefaultMessage());
					}
				}
				return "/signup";
			}
			// Save User
			ConfirmationToken coToken = userService.registerNewUserAccount(user);
			//send email confirmation
			emailService.sendConfirmationTokenMail(user.getEmail(), coToken.getToken());
			model.addAttribute("user", user);
			return "home";

		} catch (UserAlreadyExistException uaeEx) {
			model.addAttribute("message", uaeEx.getMessage());
			return "signup";
		}

	}

	@RequestMapping(value = { "/{locale:en|fr|es}/regitrationConfirm", "/regitrationConfirm" }, method = RequestMethod.GET)
	public String confirmRegistration(HttpServletRequest request, Model model, @RequestParam("token") String token) {
		try {
			System.out.println("token recupere :"+token);
			userService.verificationToken(token);
			return "redirect:/login";

		} catch (Exception e) {
			String messageValue = e.getMessage();
			model.addAttribute("message", messageValue);
			return "redirect:/badUser";
		}

	}
}