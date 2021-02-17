package com.asf.bricotuto.webapp.controlleur;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.asf.bricotuto.model.bean.User.AppUser;
import com.asf.bricotuto.model.bean.User.UserToken;
import com.asf.bricotuto.model.exception.UserAlreadyExistException;
import com.asf.bricotuto.webapp.service.authentification.AuthService;
import com.asf.bricotuto.webapp.service.mail.EmailService;

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
	public ModelAndView showSignInPage(@RequestParam(value = "error", required = false) String error){		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		ModelAndView model = new ModelAndView();
		model.addObject("user", auth.getDetails());		

		if (error != null) {
			model.addObject("error", error);
		}
		model.setViewName("/authentification/signin");
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
	public String showSignUpUser(Model model) {
		AppUser user = new AppUser();
		model.addAttribute("user", user);
		return "/authentification/signup";
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
	public String registerUserAccount(@ModelAttribute("user") @Validated AppUser user, Model model,
			HttpServletRequest request) {
		try {
			// Verification password Match
			if (!user.getPassword().equals(user.getMatchingPassword())) {
				model.addAttribute("errorPasswordMatches", "Password don't match");
				return "/authentification/signup";
			}
			// Save User
			UserToken coToken = authService.registerNewUserAccount(user);
			// send email confirmation
			emailService.sendConfirmationTokenMail(user.getEmail(), coToken.getToken());
			model.addAttribute("user", user);
			return "/authentification/successRegister";

		} catch (UserAlreadyExistException uaeEx) {
			model.addAttribute("message", uaeEx.getMessage());
			return "/authentification/signup";
		}

	}

	/**
	 * Confirm Registration user with Token
	 * 
	 * @param request
	 * @param model
	 * @param token
	 * @return
	 */
	@RequestMapping(value = { "/{locale:en|fr|es}/regitrationConfirm",
			"/regitrationConfirm" }, method = RequestMethod.GET)
	public String confirmRegistration(HttpServletRequest request, Model model, @RequestParam("token") String token) {
		try {
			System.out.println("token recupere :" + token);
			authService.validateRegistrationToken(token);
			return "redirect:/signin";

		} catch (Exception e) {
			String messageValue = e.getMessage();
			model.addAttribute("message", messageValue);
			return "redirect:/badUser";
		}

	}

	/**
	 * Show Error Registration user
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/{locale:en|fr|es}/badUser", "/badUser" }, method = RequestMethod.GET)
	public String errorRegistration(Model model, @RequestParam("message") String message) {
		System.out.println(message);
		model.addAttribute("message", message);
		return "/authentification/badUser";
	}

	/**
	 * Show Reset Password
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/{locale:en|fr|es}/forgotPassword", "/forgotPassword" }, method = RequestMethod.GET)
	public String showResetPassword(Model model) {
		AppUser user = new AppUser();
		model.addAttribute("user", user);
		return "/authentification/forgotPassword";
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
	public String resetPassword(@RequestParam("email") String userEmail, HttpServletRequest request, Model model) {

		System.out.println("Mail" + userEmail);
		try {
			// resetPassword
			UserToken coToken = authService.resetPassword(userEmail);
			// send email reset
			emailService.sendResetPasswordMail(coToken.getUser().getEmail(), coToken.getToken());
			return "/authentification/successRegister";

		} catch (Exception e) {
			AppUser user = new AppUser();
			model.addAttribute("user", user);
			model.addAttribute("error", e.getMessage());
			return "/authentification/forgotPassword";
		}
	}

	/**
	 * Show change password with UserToken
	 * 
	 * @param request
	 * @param model
	 * @param token
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = { "/{locale:en|fr|es}/changePassword", "/changePassword" }, method = RequestMethod.GET)
	public String showChangePasswordPage(Model model, HttpServletRequest request, @RequestParam("token") String token) {
		System.out.println("****************");
		HttpSession session = request.getSession();
		Object tokensession = session.getAttribute("resetpasswordtoken");

		if (token == null && tokensession != null) {
			token = tokensession.toString();
		} else if (token != null && tokensession == null) {
			session.setAttribute("resetpasswordtoken", token);
		}
		System.out.println("token session");

		System.out.println("token2:" + token);
		AppUser user;
		try {
			user = authService.validateResetPasswordToken(token);
			model.addAttribute("user", user);
			return "/authentification/changePassword";
		} catch (Exception e) {
			model.addAttribute("user", new AppUser());
			System.out.println("errorrrrrshangepassword");
			return "/authentification/changePassword";
		}
	}

	/**
	 * change password
	 * 
	 * @param user
	 * @param result
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "/{locale:en|fr|es}/changePassword", "/changePassword" }, method = RequestMethod.POST)
	public String ChangePassword(HttpServletRequest request, @ModelAttribute("user") AppUser user, Model model) {
		try {
			System.out.println("***********************************Debut change password post*****************");
			HttpSession session = request.getSession();
			String token = session.getAttribute("resetpasswordtoken").toString();
			// Verification password Match
			if (!user.getPassword().equals(user.getMatchingPassword())) {
				System.out.println("token password don t match" + token);
				model.addAttribute("errorPasswordMatches", "Password don't match");
				return "/authentification/changePassword";
			}
			// update User (user,token)
			System.out.println("password valider ,token:" + token);
			authService.changeUserPasswordWithToken(user.getPassword(), token);
			// send email confirmation
			return "redirect:/signin";

		} catch (Exception uaeEx) {
			model.addAttribute("message", uaeEx.getMessage());
			return "/authentification/changePassword";
		}

	}
}
