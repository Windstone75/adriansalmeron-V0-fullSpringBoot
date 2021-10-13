package com.asf.adriansalmeron.webapp.controlleur.member;

import javax.servlet.http.HttpServletRequest;

import com.asf.adriansalmeron.webapp.service.authentification.AuthService;
import com.asf.adriansalmeron.webapp.service.mail.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.asf.adriansalmeron.model.bean.User.AppUser;
import com.asf.adriansalmeron.model.bean.User.UserToken;
import com.asf.adriansalmeron.model.exception.FunctionalException;
import com.asf.adriansalmeron.model.exception.UserTokenException;

@Controller
public class AuthController {

	@Autowired
	private AuthService authService;
	@Autowired
	private EmailService emailService;

	/**
	 * Show SignIn Page
	 * 
	 * @param error
	 * @param logout
	 * @return
	 */
	@RequestMapping(value = { "/{locale:en|fr|es}/signin", "/signin" }, method = RequestMethod.GET)
	public ModelAndView showSignInPage(@RequestParam(value = "error", required = false) String error) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		ModelAndView model = new ModelAndView();
		model.addObject("user", auth.getDetails());

		if (error != null) {
			model.addObject("error", error);
		}
		model.setViewName("authentification/signin");
		return model;
	}

	/**
	 * Show SignUp User
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/{locale:en|fr|es}/signup", "/signup" }, method = RequestMethod.GET)
	public ModelAndView showSignUpUser() {
		ModelAndView model = new ModelAndView();
		AppUser user = new AppUser();
		model.addObject("user", user);
		model.setViewName("authentification/signup");
		return model;
	}

	/**
	 * Save new User
	 * 
	 * @param user
	 * @param result
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "/{locale:en|fr|es}/signup", "/signup" }, method = RequestMethod.POST)
	public ModelAndView registerUserAccount(@ModelAttribute("user") @Validated AppUser user,
			BindingResult bindingResult) {
		ModelAndView model = new ModelAndView();
		model.setViewName("authentification/signup");

		Boolean isPasswordMatch = !user.getPassword().equals(user.getMatchingPassword());
		try {
			if (bindingResult.hasErrors() || isPasswordMatch) {
				// Verification password Match
				if (!user.getPassword().equals(user.getMatchingPassword())) {
					model.addObject("errorform", "Password don't match");
				}
				return model;
			}
			// Save User
		
			UserToken coToken = authService.registerNewUserAccount(user);

			// send email confirmation
			emailService.sendConfirmationTokenMail(user.getEmail(), coToken.getToken());

			model.addObject("user", user);
			model.setViewName("authentification/successRegister");
			return model;

		} catch (FunctionalException funcEx) {
			
			model.addObject("errorform", funcEx.getMessage());
			return model;
		}

	}

	/**
	 * Confirm Registration user with Token
	 * 
	 * @param request
	 * @param model
	 * @param token
	 * @return
	 * @throws UserTokenException
	 */
	@ExceptionHandler(UserTokenException.class)
	@RequestMapping(value = { "/{locale:en|fr|es}/regitrationConfirm",
			"/regitrationConfirm" }, method = RequestMethod.GET)
	public ModelAndView confirmRegistration(HttpServletRequest request, ModelAndView modelAndView,
			@RequestParam("token") String token, final RedirectAttributes redirectAttributes) {
		try {
			authService.validateRegistrationToken(token);
			redirectAttributes.addFlashAttribute("flashSuccess", "Your account is activate!");
			modelAndView.setViewName("redirect:/signin");
			return modelAndView;
		} catch (UserTokenException e) {

			modelAndView.setViewName("error/invalidToken");
			modelAndView.addObject("messageException", e.getMessage());
			return modelAndView;
		}

	}

	/**
	 * Show Reset Password
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/{locale:en|fr|es}/forgotPassword", "/forgotPassword" }, method = RequestMethod.GET)
	public ModelAndView showResetPassword(ModelAndView modelAndView) {

		modelAndView.addObject("user", new AppUser());
		modelAndView.setViewName("authentification/forgotPassword");
		return modelAndView;
	}

	/**
	 * 
	 * Reset Password save token(ResetPassword) and send mail
	 * 
	 * @param user
	 * @param result
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "/{locale:en|fr|es}/forgotPassword", "/forgotPassword" }, method = RequestMethod.POST)
	public ModelAndView resetPassword(@RequestParam("email") String userEmail, HttpServletRequest request,
			ModelAndView modelAndView) {
		try {
			// resetPassword
			UserToken coToken = authService.resetPassword(userEmail);
			// send email reset
			emailService.sendResetPasswordMail(coToken.getUser().getEmail(), coToken.getToken());
			modelAndView.setViewName("authentification/successRegister");
			return modelAndView;

		} catch (FunctionalException funcEx) {
			// Initialise Show ForgotPassword
			modelAndView.addObject("errorform", funcEx.getMessage());
			modelAndView.addObject("user", new AppUser());
			modelAndView.setViewName("authentification/forgotPassword");

			return modelAndView;
		}
	}

	/**
	 * Show change password 
	 * 
	 * @param request
	 * @param model
	 * @param token
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = { "/{locale:en|fr|es}/changePassword", "/changePassword" }, method = RequestMethod.GET)
	public ModelAndView showChangePasswordPage(HttpServletRequest request, @RequestParam("token") String token,
			ModelAndView modelAndView) {
		AppUser user;
	

		try {
			user = authService.validateResetPasswordToken(token);
			modelAndView.addObject("user", user);
			modelAndView.addObject("tokenReset",token);
			modelAndView.setViewName("authentification/changePassword");
			return modelAndView;
		} catch (UserTokenException e) {
			modelAndView.setViewName("error/invalidToken");
			modelAndView.addObject("messageException", e.getMessage());
			return modelAndView;
		}
	}

	/**
	 * change password with UserToken
	 * 
	 * @param user
	 * @param result
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "/{locale:en|fr|es}/changePassword", "/changePassword" }, method = RequestMethod.POST)
	public ModelAndView ChangePassword(HttpServletRequest request, @ModelAttribute("user") AppUser user,
			ModelAndView modelAndView, final RedirectAttributes redirectAttributes) {
		
		try {
			String token = request.getParameter("tokenReset");
			// Verification password Match
			if (!user.getPassword().equals(user.getMatchingPassword())) {
				redirectAttributes.addFlashAttribute("errorform", "Password don't match");
				modelAndView.setViewName("redirect:/changePassword?token="+token);
				return modelAndView;
			}
			// update User (user,token)
			
			authService.changeUserPasswordWithToken(user.getPassword(), token);
			redirectAttributes.addFlashAttribute("flashSuccess", "Reset password successfully !");
			modelAndView.setViewName("redirect:/signin");
			return modelAndView;
			

		} catch (UserTokenException e) {
			modelAndView.setViewName("error/invalidToken");
			modelAndView.addObject("messageException", e.getMessage());
			return modelAndView;
		}

	}
}
