package com.asf.bricotuto.webapp.controlleur.admin.database;



import org.springframework.stereotype.Controller;

@Controller
public class UserTableAdminController {
	
	//private  UserAdminService uService = new UserAdminService();
		/**
	 * Save new User
	 * 
	 * @param user
	 * @param result
	 * @param model
	 * @param request
	 * @return
	 */
	/*	@RequestMapping(value = { "/{locale:en|fr|es}/signup", "/signup" }, method = RequestMethod.POST)
	public String registerUserAccount(@ModelAttribute("user") @Validated AppUser user, Model model,
			HttpServletRequest request) {
		
			// Verification password Match
		//	if (!user.getPassword().equals(user.getMatchingPassword())) {
			//	model.addAttribute("errorPasswordMatches", "Password don't match");
				//return "/signup";
			//}
			// Save User
			//UserToken coToken = uService.registerNewUserAccount(user);
			// send email confirmation
			//emailService.sendConfirmationTokenMail(user.getEmail(), coToken.getToken());
			//model.addAttribute("user", user);
			return "successRegister";

	}
	*/


}
